HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "f3dd87e0b98999a78e500e8c6d2b063ebadf535a"

SRC_URI = "git://git.denx.de/u-boot.git"

SRC_URI_append_friendlyelec-nanopik2 = " \
           file://0001-ARM-dts-sync-meson-gxbb-nanopi-k2-from-Linux-4.17.patch \
           file://0002-boards-amlogic-Add-FriendlyElec-NanoPi-K2-board-supp.patch \
"

SRC_URI_append_amlogic-p212 = " file://0003-amlogic-board-p212-Fix-Ethernet-PHY-init.patch "

S = "${WORKDIR}/git"
