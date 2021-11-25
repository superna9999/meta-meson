inherit image_types

WIC_COMMAND:meson-gxl = "wic_command_meson_gxl"
WIC_COMMAND:meson-gxm = "wic_command_meson_gxl"
WIC_COMMAND:meson-g12a = "wic_command_meson_gxl"
WIC_COMMAND:meson-g12b = "wic_command_meson_gxl"
WIC_COMMAND:meson-sm1 = "wic_command_meson_gxl"
WIC_COMMAND:meson-gxbb = "wic_command_meson_gxbb"
WIC_COMMAND:hardkernel-odroidc2 = "wic_command_odroidc2"
WIC_COMMAND:friendlyelec-nanopik2 = "wic_command_nanopik2"
WIC_COMMAND:amlogic-s400 = "wic_command_s400"

wic_command_odroidc2 () {
	dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=440
	dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.img of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=96 seek=97
}

wic_command_nanopik2 () {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=1
}

wic_command_meson_gxl () {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=440
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
}

wic_command_meson_gxbb() {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=440
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
}

wic_command_s400 () {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=1
}

IMAGE_CMD:wic:append () {
	${WIC_COMMAND}
}
