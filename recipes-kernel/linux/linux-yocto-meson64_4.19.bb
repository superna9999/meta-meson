#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "64022157ebdcd9dfa2c98d44ecf5523c4dc24b9d"
LINUX_VERSION = "4.19.80-android-amlogic-bmeson-4.19"
	
# Linux stable tree
SRC_URI = "git://gitlab.com/baylibre/amlogic/atv/linux.git;protocol=https;branch=android-amlogic-bmeson-4.19-vdec;name=meson \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

