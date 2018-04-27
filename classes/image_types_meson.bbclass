inherit image_types

WIC_COMMAND_meson-gxl = "wic_command_meson_gxl"
WIC_COMMAND_meson-gxbb = "wic_command_meson_gxbb"
WIC_COMMAND_hardkernel-odroidc2 = "wic_command_odroidc2"

wic_command_odroidc2 () {
	dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=442
	dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.img of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=96 seek=97
}

wic_command_meson_gxl () {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=444
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
}

wic_command_meson_gxbb() {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=442
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
}

IMAGE_CMD_wic_append () {
	${WIC_COMMAND}
}
