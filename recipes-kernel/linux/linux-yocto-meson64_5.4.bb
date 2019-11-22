#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

DEPENDS += "rsync-native"

SRCREV_meson = "a9e4990fa2c2b7defc47a0053371e5691d80fcdb"
LINUX_VERSION = "5.4-rc8+media+vdec"

# Linux stable tree
SRC_URI = "git://github.com/superna9999/linux.git;protocol=https;branch=amlogic/v5.6/vdec-g12a;name=meson \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

FILES_${KERNEL_PACKAGE_NAME}-base += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"
