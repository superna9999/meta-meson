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

# TODO - the changes in linux-firmware_%.bbappend to new override syntax causes build failures when
# installing either linux-firmware-bcm43430 or linux-firware-bcm43430a0:
# - nothing provides linux-firmware-bcm43430a0 needed by packagegroup-core-boot-1.0-r17.radxa_zero
#
# Bascally including either of these in MACHINE_ESSENTIAL_EXTRA_RDEPENDS causes the above error
# MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43430", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43430a0", "",d)} \
# "
# For now I'm taking an aggressive approach and not installing anything other than what I need, selfishly.
#
# TODO - figure out where these belong, probably in the machine conf _or_ using the :<machine> override syntax
# as surely not all amlogic based systems need _all_ firmwares installed
# MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4329", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4330", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4335", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43362", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43430", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43430a0", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43455", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4354", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm4356", "",d)} \
#        ${@bb.utils.contains("MACHINE_FEATURES", "screen", "linux-firmware-amlogic-vdec", "",d)} \
# "

# An example using :<machine> override
# MACHINE_ESSENTIAL_EXTRA_RDEPENDS:radxa-zero += " \
#         ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43455", "",d)} \
#         ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "linux-firmware-bcm43456", "",d)} \
# "

IMAGE_FSTYPES += "tar.bz2 wic"
do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot"

WKS_FILE ?= "sdimage-bootpart-meson.wks"
