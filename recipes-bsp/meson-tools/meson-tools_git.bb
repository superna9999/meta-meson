HOMEPAGE = "https://github.com/afaerber/meson-tools"
SUMMARY = "Tools for Amlogic Meson ARM platforms"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/afaerber/meson-tools.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "0a02e2d34413f4bf9b15946352bc8c8ee13a5843"

DEPENDS = "openssl"

S = "${WORKDIR}/git"

MESON_TOOLS_PROGRAMS = "amlbootsig unamlbootsig amlbootsig-gxl amlbootenc-gxl amlbootimg-gxl amlinfo"

do_configure () {
	sed -i "s/^CFLAGS = /CFLAGS ?= /" ${S}/Makefile
	sed -i "s/^LDFLAGS = /LDFLAGS += /" ${S}/Makefile
}

do_compile () {
	oe_runmake ${MESON_TOOLS_PROGRAMS}
}

do_install () {
	mkdir -p ${D}${bindir}
	for program in ${MESON_TOOLS_PROGRAMS}; do
		install -m 755 ${S}/$program ${D}${bindir}/$program
	done
}

do_clean () {
	if [ -e ${S}/Makefile ] ; then
		cd ${S} && oe_runmake clean
	fi
}

BBCLASSEXTEND = "native"
