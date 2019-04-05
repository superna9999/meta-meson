LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=72f855f00b364ec8bdc025e1a36b39c3"

SRC_URI = "git://chromium.googlesource.com/chromiumos/platform/minigbm.git;protocol=https;branch=master \
           file://0001-meson-add-support-for-AFBC-modifiers.patch \
           "

PV = "1.0+git${SRCPV}"
SRCREV = "cc35e699f36cce0f0b3a130b0d6ce4e2a393b373"

S = "${WORKDIR}/git"

inherit pkgconfig

DEPENDS = "libdrm"
PROVIDES = "virtual/libgbm"
PACKAGES += "libgbm libgbm-dev"

do_configure () {
	:
}

do_compile () {
	oe_runmake CFLAGS="-DDRV_MESON"
}

do_install () {
	oe_runmake install 'DESTDIR=${D}'
}

FILES_${PN} = ""
FILES_${PN}-dev = ""
FILES_${PN}-dbg = ""

FILES_libgbm = "${libdir}/libgbm.so.* ${libdir}/libminigbm.so.*"
FILES_libgbm-dev = "${libdir}/libgbm.* ${libdir}/pkgconfig/gbm.pc ${includedir}/gbm.h"
