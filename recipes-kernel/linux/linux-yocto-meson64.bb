#
# Linux Support for 64bit Amlogic Meson SoCs
#

require linux-yocto-meson.inc

LINUX_VERSION_EXTENSION_append = "-meson64"
KBUILD_DEFCONFIG = "defconfig"
