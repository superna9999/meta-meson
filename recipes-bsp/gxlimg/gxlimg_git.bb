HOMEPAGE = "https://github.com/repk/gxlimg"
SUMMARY = "Boot Image creation tool for amlogic s905x (GXL)"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=de09d893c458f4d78748b1c40e1b6916"

inherit meson pkgconfig

SRC_URI = "git://github.com/repk/gxlimg;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "15be56b1f1e2a319227d599a0b7afb0673e9cb9b"

DEPENDS = "openssl"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"
