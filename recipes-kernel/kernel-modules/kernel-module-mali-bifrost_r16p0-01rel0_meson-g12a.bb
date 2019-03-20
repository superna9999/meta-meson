SUMMARY = "Open Source Mali Bifrost GPU Kernel Drivers"
LICENSE = "GPLv2"

inherit module

PR = "r0"

LIC_FILES_CHKSUM = "file://README.md;md5=8c7db5651aa2b41e14c54df001586961"

SRC_URI = "git://github.com/superna9999/meson_g12a_mali_bifrost.git;protocol=git;branch=BX301A01B-SW-99002-r16p0-01rel0_meson-g12a"

SRCREV = "064b0df037b19d47064880fdceed046680b9a63b"

S = "${WORKDIR}/git"

MALI_CONFIG_NAME ?= "config"
MALI_CONFIG_NAME_meson-g12a = "config.meson-g12a"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake KDIR=${STAGING_KERNEL_DIR} \
		CONFIG_NAME=${MALI_CONFIG_NAME} \
		all
}

do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
#	oe_runmake KDIR=${STAGING_KERNEL_DIR} \
#		CONFIG_NAME=${MALI_CONFIG_NAME} \
#		INSTALL_MOD_PATH="${D}" \
#		modules_install
	oe_runmake -C ${STAGING_KERNEL_DIR} \
		M=$(pwd)/driver/product/kernel/drivers/gpu/arm/midgard \
		INSTALL_MOD_PATH="${D}" \
		modules_install
}
