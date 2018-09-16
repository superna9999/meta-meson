HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "f88b6facb87dc4a52f1630eb9d858c0f54c6628e"

SRC_URI = "git://git.denx.de/u-boot.git"

S = "${WORKDIR}/git"
