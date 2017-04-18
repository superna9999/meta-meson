#
# Linux Support for 32bit Amlogic Meson SoCs
#

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.10.y;name=meson"

# tag: v4.10.10
SRCREV_meson="e6925852d5b862bac749fab9c8d26491cda99e4e"

LINUX_VERSION ?= "4.10.10"

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

require linux-yocto-meson.inc

