SUMMARY = "v4l2 and IR applications"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=48da9957849056017dc568bbc43d8975 \
                    file://COPYING.libv4l;md5=d749e86a105281d7a44c2328acebc4b0"
PROVIDES = "libv4l media-ctl"

DEPENDS = "jpeg \
           ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'virtual/libx11', '', d)}"
DEPENDS_append_libc-musl = " argp-standalone"
DEPENDS_append_class-target = " udev"
LDFLAGS_append = " -pthread"

inherit autotools gettext pkgconfig

PACKAGECONFIG ??= "media-ctl"
PACKAGECONFIG[media-ctl] = "--enable-v4l-utils,--disable-v4l-utils,,"

SRC_URI = "git://linuxtv.org/v4l-utils.git;protocol=git \
           "
SRCREV = "7ead0e1856b89f2e19369af452bb03fd0cd16793"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-qv4l2 --enable-shared --with-udevdir=${base_libdir}/udev"

VIRTUAL-RUNTIME_ir-keytable-keymaps ?= "rc-keymaps"

PACKAGES =+ "media-ctl ir-keytable rc-keymaps libv4l libv4l-dev"

RPROVIDES_${PN}-dbg += "libv4l-dbg"

FILES_media-ctl = "${bindir}/media-ctl ${libdir}/libmediactl.so.*"

FILES_ir-keytable = "${bindir}/ir-keytable ${base_libdir}/udev/rules.d/*-infrared.rules"
RDEPENDS_ir-keytable += "${VIRTUAL-RUNTIME_ir-keytable-keymaps}"

FILES_rc-keymaps = "${sysconfdir}/rc* ${base_libdir}/udev/rc*"

FILES_${PN} = "${bindir} ${sbindir}"

FILES_libv4l += "${libdir}/libv4l*${SOLIBS} ${libdir}/libv4l/*.so ${libdir}/libv4l/plugins/*.so \
                 ${libdir}/libdvbv5*${SOLIBS} \
                 ${libdir}/libv4l/*-decomp"

FILES_libv4l-dev += "${includedir} ${libdir}/pkgconfig \
                     ${libdir}/libv4l*${SOLIBSDEV} ${libdir}/*.la \
                     ${libdir}/v4l*${SOLIBSDEV} ${libdir}/libv4l/*.la ${libdir}/libv4l/plugins/*.la"

PARALLEL_MAKE_class-native = ""
BBCLASSEXTEND = "native"

do_configure() {
	(cd ${S} && ./bootstrap.sh)
	echo "#define SHA ${SRCREV}" > ${S}/utils/v4l2-compliance/version.h
	(cd ${B} && oe_runconf ${S})
}
