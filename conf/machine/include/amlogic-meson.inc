# Amlogic Meson SoCs configurations

MACHINE_EXTRA_RRECOMMENDS = " kernel-modules kernel-devicetree linux-firmware"

SERIAL_CONSOLE = "115200 ttyAML0"

KERNEL_IMAGETYPE = "uImage"
UBOOT_LOADADDRESS = "0x1080000"
UBOOT_ENTRYSYMBOL = "0x1080000"

IMAGE_BOOT_FILES ?= "uImage"

IMAGE_FSTYPES += "tar.bz2 wic"
WKS_FILE ?= "sdimage-bootpart-meson.wks"
do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot"
