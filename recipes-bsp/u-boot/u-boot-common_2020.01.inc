HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "0b0c6af38738f2c132cfd41a240889acaa031c8f"

SRC_URI = "git://github.com/u-boot/u-boot.git"

S = "${WORKDIR}/git"
