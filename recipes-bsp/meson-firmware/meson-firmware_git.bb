SUMMARY = "Firmware for amlogic vdec"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit allarch

SRC_URI = "git://github.com/LibreELEC/meson-firmware.git;protocol=https"
SRCREV = "9cb39a43dcb2cc19253816b0fef8f3698e344f4f"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/
	cp -r ${S}/meson ${D}${nonarch_base_libdir}/firmware/
}

FILES_${PN} = "${nonarch_base_libdir}"
