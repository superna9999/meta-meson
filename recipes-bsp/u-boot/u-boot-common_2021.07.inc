HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "840658b093976390e9537724f802281c9c8439f5"

SRC_URI = "git://github.com/u-boot/u-boot.git"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
