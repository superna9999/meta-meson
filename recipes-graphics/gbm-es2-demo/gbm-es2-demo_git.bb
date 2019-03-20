LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6399aca264cba2dc4c3a68d5904ffd33"

SRC_URI = "git://github.com/ds-hwang/gbm_es2_demo.git;protocol=https;branch=master \
           file://0001-Install-demo.patch \
           file://0002-egl_drm_glue-include-gbm.h-first.patch \
           "

PV = "1.0+git${SRCPV}"
SRCREV = "6696df125b2e81e701413de80f297aa13b23a471"

DEPENDS = "libmali minigbm"
RDEPENDS_${PN} += "libmali libgbm"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

INSANE_SKIP_${PN} += "file-rdeps"
