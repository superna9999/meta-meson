LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://END_USER_LICENCE_AGREEMENT.txt;md5=3918cc9836ad038c5a090a0280233eea"

SRC_URI = "git://gitlab.com/superna9999/libmali.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "0d3b8f82e7652e934b734612f73134f5fe0158a3"

S = "${WORKDIR}/git"

inherit cmake

do_install_append() {
	# RPM fails dependencies with symlinks...
	(cd ${D}/${libdir} && \
	   rm libEGL.so && \
	   ln -f libmali-bifrost-g31-dvalin-r12p0-dummy.so libEGL.so)
	(cd ${D}/${libdir} && \
	   rm libGLESv2.so && \
	   ln -f libmali-bifrost-g31-dvalin-r12p0-dummy.so libGLESv2.so)
}

EXTRA_OECMAKE_meson-g12a = "-DMALI_VARIANT=g31 -DMALI_REVISION=dvalin-r12p0-dummy -DMALI_ARCH=aarch64-linux-gnu"
EXTRA_OECMAKE_meson-gxl = "-DMALI_VARIANT=450  -DMALI_ARCH=aarch64-linux-gnu"

INSANE_SKIP_${PN} += "dev-elf dev-so ldflags"

FILES_${PN}-dev = "/usr/include/ /usr/lib/pkgconfig/"
FILES_${PN} = "/usr/lib/"
