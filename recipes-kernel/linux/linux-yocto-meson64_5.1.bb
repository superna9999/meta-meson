#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "ce909bd3003714e54d652b6968a0f2cc63a7e82e"
LINUX_VERSION = "5.1-rc1"

# Linux stable tree
SRC_URI = "git://github.com/superna9999/linux.git;protocol=https;branch=amlogic/v5.1/g12a-integ-5.1-bcmdhd;name=meson \
           file://defconfig \
           file://0001-meson-g12a-disable-CVBS-connectors.patch \
           file://0001-arm64-dts-meson-g12a-update-cma-reserved-memory-to-5.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

