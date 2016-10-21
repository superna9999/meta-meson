#
# Linux Support for 64bit Amlogic Meson SoCs
#

require linux-yocto-meson.inc

SRC_URI += "file://defconfig"

LINUX_VERSION_EXTENSION_append = "-meson64"
