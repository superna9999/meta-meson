#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

DEPENDS += "rsync-native"

SRCREV_meson = "43a868577dfcd9be6930453dc5ec557ab2e9ad89"
LINUX_VERSION = "6.5.10"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-6.5.y;name=meson \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION:append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-src += "buildpaths"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

