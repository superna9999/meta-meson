#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.10.y;name=meson"

SRC_URI += "file://defconfig \
"

LINUX_VERSION ?= "4.10.10"

# tag: v4.10.10
SRCREV_meson="e6925852d5b862bac749fab9c8d26491cda99e4e"

KERNEL_CLASSES = "kernel-uimage-meson64"

LINUX_VERSION_EXTENSION_append = "-meson64"
KBUILD_DEFCONFIG = "defconfig"

require linux-yocto-meson.inc
