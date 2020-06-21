FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://brcmfmac4354-sdio.txt \
	file://brcmfmac4356-sdio.txt \
"

do_install_append() {
        install -m 0644 ${WORKDIR}/brcmfmac435*-sdio.txt \
        ${D}${nonarch_base_libdir}/firmware/brcm
}

FILES_${PN}-bcm4354 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4354-sdio.txt \
"

FILES_${PN}-bcm4356 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4356-sdio.txt \
"
