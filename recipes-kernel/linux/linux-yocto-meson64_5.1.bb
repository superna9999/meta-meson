#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "dbecb194399bb7b12c080233dc77e39222bee76e"
LINUX_VERSION = "5.1-rc1"
	
# Linux stable tree
SRC_URI = "git://gitlab.com/superna9999/linux.git;protocol=https;branch=amlogic/v5.1/g12a-integ-5.1;name=meson \
           file://defconfig \
           file://0001-meson-g12a-disable-CVBS-connectors.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

