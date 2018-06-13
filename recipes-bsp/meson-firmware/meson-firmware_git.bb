SUMMARY = "Firmware for amlogic vdec"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/chewitt/meson-firmware.git;protocol=https"
SRCREV = "f89747975dfbfef61b18d7fd11d709c137fec51b"

S = "${WORKDIR}/git"

FILES_${PN} = "/lib/firmware/meson"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/
	cp -r ${S}/meson ${D}${nonarch_base_libdir}/firmware/
}
