inherit image_types

# Heavly influenced by image_types_fsl.bblcass and image_types_odroid.bbclass from meta-odroid
# Constructs SDCard Image for GXL/GXM Devices

# Set alignment to 1MB [in KiB]
IMAGE_ROOTFS_ALIGNMENT_meson-gx = "4096"

SDIMG_ROOTFS_TYPE ?= "ext4"
SDIMG_ROOTFS = "${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.${SDIMG_ROOTFS_TYPE}"
IMAGE_TYPEDEP_sdcard = "${SDIMG_ROOTFS_TYPE}"

do_image_sdcard[depends] += "\
			parted-native:do_populate_sysroot \
			dosfstools-native:do_populate_sysroot \
                       	mtools-native:do_populate_sysroot \
                       	coreutils-native:do_populate_sysroot \
                       	virtual/kernel:do_deploy \
			"

SDCARD = "${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.sdcard"
SDCARD_ROOTFS ?= "${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.ext4"
SDCARD_GENERATION_COMMAND_meson-gxbb = "generate_meson_gxbb_sdcard"
SDCARD_GENERATION_COMMAND_meson-gxl = "generate_meson_gxl_sdcard"
SDCARD_GENERATION_COMMAND_meson-gxm = "generate_meson_gxl_sdcard"

generate_meson_gxl_sdcard () {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=${SDCARD} conv=notrunc bs=1 count=444
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=${SDCARD} conv=notrunc bs=512 skip=1 seek=1
}

generate_meson_gxbb_sdcard () {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=${SDCARD} conv=notrunc bs=1 count=442
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=${SDCARD} conv=notrunc bs=512 skip=1 seek=1
}

IMAGE_CMD_sdcard () {
    rm -f ${WORKDIR}/boot.img

    ROOTFS_SIZE=`du -bks ${SDIMG_ROOTFS} | awk '{print $1}'`
    # Round up RootFS size to the alignment size
    ROOTFS_SIZE_ALIGNED=$(expr ${ROOTFS_SIZE} + ${IMAGE_ROOTFS_ALIGNMENT} - 1)
    ROOTFS_SIZE_ALIGNED=$(expr ${ROOTFS_SIZE_ALIGNED} - ${ROOTFS_SIZE_ALIGNED} % ${IMAGE_ROOTFS_ALIGNMENT})
    SDIMG_SIZE=$(expr ${IMAGE_ROOTFS_ALIGNMENT} + ${ROOTFS_SIZE_ALIGNED})

    echo "Creating filesystem with RootFS ${ROOTFS_SIZE_ALIGNED} KiB"
    echo "Creating filesystem total size ${SDIMG_SIZE} KiB"

    # Initialize sdcard image file
    echo "dd if=/dev/zero of=${SDCARD} bs=1 count=0 seek=$(expr 1024 \* ${SDIMG_SIZE})"
    dd if=/dev/zero of=${SDCARD} bs=1 count=0 seek=$(expr 1024 \* ${SDIMG_SIZE})

    # Create partition table
    parted -s ${SDCARD} mklabel msdos
    # Create rootfs partition to the end of disk
    parted -s ${SDCARD} -- unit KiB mkpart primary ext2 $(expr ${IMAGE_ROOTFS_ALIGNMENT}) -1s
    parted ${SDCARD} print

    ${SDCARD_GENERATION_COMMAND}

    echo "dd if=${SDIMG_ROOTFS} of=${SDCARD} conv=notrunc seek=1 bs=$(expr 1024 \* ${IMAGE_ROOTFS_ALIGNMENT})"
    dd if=${SDIMG_ROOTFS} of=${SDCARD} conv=notrunc seek=1 bs=$(expr 1024 \* ${IMAGE_ROOTFS_ALIGNMENT}) && sync && sync
}
