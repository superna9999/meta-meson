# Amlogic Meson SoCs configurations

MACHINE_EXTRA_RRECOMMENDS ?= " kernel-modules"

MACHINE_FEATURES ?= "serial"

SERIAL_CONSOLE ?= "115200 ttyAML0"

UBOOT_LOADADDRESS ?= "0x1080000"
UBOOT_ENTRYPOINT ?= "0x01080000"

XSERVER ?= "\
	   xserver-xorg \
           xf86-video-modesetting \
"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4329", "",d)} \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4330", "",d)} \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4335", "",d)} \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43362", "",d)} \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43430", "",d)} \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43455", "",d)} \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4354", "",d)} \
       ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4356", "",d)} \
"

IMAGE_FSTYPES += "tar.bz2 wic"
do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot"
