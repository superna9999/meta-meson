inherit image_types

DEPENDS_append_wic = " virtual/trusted-firmware-a"

WIC_COMMAND = "wic_command_meson_gx"
WIC_COMMAND_amlogic-s400 = "wic_command_s400"

wic_command_meson_gx () {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=440
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.sd.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
}

wic_command_s400 () {
	dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin.mmc.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=1
}

IMAGE_CMD_wic_append () {
	${WIC_COMMAND}
}
