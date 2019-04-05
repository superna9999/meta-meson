DESCRIPTION = "Demo application to showcase 3D graphics using kms and surfaceless gbm"
HOMEPAGE = "https://cgit.freedesktop.org/mesa/kmscube/"
LICENSE = "MIT"
SECTION = "graphics"
DEPENDS = "libmali minigbm"
RDEPENDS_${PN} += "libmali libgbm"

LIC_FILES_CHKSUM = "file://kmscube.c;beginline=1;endline=23;md5=8b309d4ee67b7315ff7381270dd631fb"

SRCREV = "9dcce71e603616ee7a54707e932f962cdf8fb20a"
SRC_URI = "git://anongit.freedesktop.org/mesa/kmscube;branch=master;protocol=git"
SRC_URI += "file://0001-Adapt-kmscube-with-minigbm-dummy-ddk-config.patch"
UPSTREAM_CHECK_COMMITS = "1"

S = "${WORKDIR}/git"

inherit autotools pkgconfig distro_features_check
