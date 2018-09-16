require kernel-module-mali-utgard.inc

LIC_FILES_CHKSUM = "file://driver/src/devicedrv/mali/readme.txt;md5=92d15b487d204ace57072c48697b4a89"

SRC_URI = "git://github.com/superna9999/meson_gx_mali_450.git;protocol=git;branch=DX910-SW-99002-r7p0-00rel1_meson_gx"

SRCREV = "8be0f308ce73e0f7666226503b12dbb508b3b880"

S = "${WORKDIR}/git"

MALI_KCONFIG = "MALI_PLATFORM_FILES=platform/meson/meson.c \
		CONFIG_MALI_DMA_BUF_MAP_ON_ATTACH=y \
		CONFIG_MALI_QUIET=y \
"

MALI_FLAGS = "-DMALI_FAKE_PLATFORM_DEVICE=1 \
	      -DCONFIG_MALI_DMA_BUF_MAP_ON_ATTACH \
	      -DCONFIG_MALI_QUIET \
"
