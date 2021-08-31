LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

COMPATIBLE_MACHINE = "amlogic-s400"

SRC_URI = "file://board.conf \
"

do_install() {
	install -d ${D}${datadir}/alsa/alsa.conf.d
	install -m 0644 ${WORKDIR}/board.conf ${D}${datadir}/alsa/alsa.conf.d/board.conf
}

FILES:${PN} = "${sysconfdir} ${datadir}/alsa/alsa.conf.d"
