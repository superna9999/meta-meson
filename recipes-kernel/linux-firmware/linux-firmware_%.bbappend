FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	git://github.com/LibreELEC/brcmfmac_sdio-firmware.git;protocol=https;branch=master;name=brcmfmac-sdio-firmware;destsuffix=brcmfmac_sdio-firmware \
	file://brcmfmac4354-sdio.txt \
"

# This package is not in upstream linux-firmware repo, so add it here
PACKAGES =+ " \
       ${PN}-bcm43456 \
       ${PN}-bcm4345c0-hcd \
       ${PN}-bcm4345c5-hcd \
"
# Update sha to point to version that has firmware for Radxa-Zero
SRCREV_brcmfmac-sdio-firmware = "3d63ae8b429103a6ef684f7237e048763318a2ba"

do_install:append() {
	for f in ${WORKDIR}/brcmfmac_sdio-firmware/*.txt ${WORKDIR}/brcmfmac_sdio-firmware/*.bin ${WORKDIR}/brcmfmac_sdio-firmware/*.hcd; do
	        install -m 0644 $f ${D}${nonarch_base_libdir}/firmware/brcm
	done
	install -m 0644 ${WORKDIR}/brcmfmac4354-sdio.txt ${D}${nonarch_base_libdir}/firmware/brcm
}

FILES:${PN}-bcm4329 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4329* \
"

FILES:${PN}-bcm4330 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4330* \
"

FILES:${PN}-bcm4335 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4335* \
"

FILES:${PN}-bcm43362 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43362* \
"

FILES:${PN}-bcm43430 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43430* \
"

FILES:${PN}-bcm43430a0 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43430a0* \
"

FILES:${PN}-bcm43455 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43455* \
"

FILES:${PN}-bcm4345c0-hcd += " \
	${nonarch_base_libdir}/firmware/brcm/BCM4345C0.hcd \
"

FILES:${PN}-bcm43456 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43456* \
"

FILES:${PN}-bcm4345c5-hcd += " \
	${nonarch_base_libdir}/firmware/brcm/BCM4345C5.hcd \
"

FILES:${PN}-bcm4354 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4354* \
"

FILES:${PN}-bcm4356 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4356* \
"

FILES:${PN}-bcm4359 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4359* \
"
