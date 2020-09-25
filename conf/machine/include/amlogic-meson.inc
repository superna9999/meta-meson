# Amlogic Meson SoCs configurations

MACHINE_EXTRA_RRECOMMENDS = " kernel-modules kernel-devicetree"

SERIAL_CONSOLE = "115200 ttyAML0"

KERNEL_IMAGETYPE = "uImage"
UBOOT_LOADADDRESS = "0x1080000"
UBOOT_ENTRYPOINT = "0x01080000"

IMAGE_BOOT_FILES ?= "uImage"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4354", "",d)} \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4356", "",d)} \
"

IMAGE_FSTYPES += "tar.bz2 wic"
WKS_FILE ?= "sdimage-bootpart-meson.wks"
do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot"
