#
# Linux Support for 32bit Amlogic Meson SoCs
#

require linux-yocto-meson.inc

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"
