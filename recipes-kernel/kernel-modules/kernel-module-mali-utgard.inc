SUMMARY = "Open Source Mali Utgard GPU Kernel Drivers"
LICENSE = "GPLv2"

inherit module

PR = "r0"

MALI_DEFAULT_KCONFIG = "CONFIG_MALI400=m \
			CONFIG_MALI450=y \
			CONFIG_MALI470=y \
"

MALI_DEFAULT_FLAGS = "-DCONFIG_MALI400=1 \
		      -DCONFIG_MALI450=1 \
		      -DCONFIG_MALI470=1 \
"

MALI_KCONFIG ?= ""

MALI_FLAGS ?= ""

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C ${STAGING_KERNEL_DIR} \
		M=$(pwd)/driver/src/devicedrv/mali \
		O=${STAGING_KERNEL_BUILDDIR} \
		EXTRA_DEFINES="${MALI_DEFAULT_FLAGS} ${MALI_FLAGS}" \
		${MALI_DEFAULT_KCONFIG} \
		${MALI_KCONFIG}
}

do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C ${STAGING_KERNEL_DIR} \
		M=$(pwd)/driver/src/devicedrv/mali \
		INSTALL_MOD_PATH="${D}" \
		O=${STAGING_KERNEL_BUILDDIR} \
		EXTRA_DEFINES="${MALI_DEFAULT_FLAGS} ${MALI_FLAGS}" \
		${MALI_DEFAULT_KCONFIG} \
		${MALI_KCONFIG} \
		modules_install
}
