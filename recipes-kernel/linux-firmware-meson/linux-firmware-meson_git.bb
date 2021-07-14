SUMMARY = "Linux kernel firmware files for meson from LibreELEC"
DESCRIPTION = "Deploy Linux kernel firmware files for Amlogic, aka meson, from LibreELEC"
HOMEPAGE = "https://github.com/LibreELEC/meson-firmware"
SECTION = "kernel"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/LibreELEC/meson-firmware.git"
SRCREV = "89f739f8914fa537657f7f41fa104a711fee43a8"

S = "${WORKDIR}/git"

inherit allarch

CLEANBROKEN = "1"

do_compile() {
    :
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/
    install -m 0644 LICENSE ${D}${nonarch_base_libdir}/firmware/LICENSE.meson
    cp -r meson/ ${D}${nonarch_base_libdir}/firmware/
}

PACKAGES =+ "${PN}-license"

FILES_${PN}-license = "${nonarch_base_libdir}/firmware/LICENSE.meson"
FILES_${PN} = "${nonarch_base_libdir}/firmware/*"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

COMPATIBLE_MACHINE = "(amlogic)"
