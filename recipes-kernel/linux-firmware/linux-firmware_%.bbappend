FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	git://github.com/LibreELEC/brcmfmac_sdio-firmware.git;protocol=https;branch=master;name=brcmfmac-sdio-firmware;destsuffix=brcmfmac_sdio-firmware \
	file://brcmfmac4354-sdio.txt \
"

SRCREV_brcmfmac-sdio-firmware = "3ddc301c272f081aa5513c1934f6d530bf80de4a"

do_install:append() {
	for f in ${WORKDIR}/brcmfmac_sdio-firmware/*.txt ${WORKDIR}/brcmfmac_sdio-firmware/*.bin; do
	        install -m 0644 $f ${D}${nonarch_base_libdir}/firmware/brcm
	done
	install -m 0644 ${WORKDIR}/brcmfmac4354-sdio.txt ${D}${nonarch_base_libdir}/firmware/brcm
}

FILES_${PN}-bcm4329 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4329* \
"

FILES_${PN}-bcm4330 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4330* \
"

FILES_${PN}-bcm4335 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4335* \
"

FILES_${PN}-bcm43362 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43362* \
"

FILES_${PN}-bcm43430 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43430* \
"

FILES_${PN}-bcm43430a0 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43430a0* \
"

FILES_${PN}-bcm43455 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43455* \
"

FILES_${PN}-bcm43456 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43456* \
"

FILES_${PN}-bcm4354 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4354* \
"

FILES_${PN}-bcm4356 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4356* \
"

FILES_${PN}-bcm4359 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4359* \
"
