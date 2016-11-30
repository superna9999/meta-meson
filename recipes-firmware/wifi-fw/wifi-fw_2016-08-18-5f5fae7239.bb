LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://qcom9377/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://ath6kl/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://ath6kl/firmware/LICENSE.TXT;md5=bafc4300ca5bbd85b704c45969d15e03 \
                    file://ath6kl/dhdutil/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://bcm_4330/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://athr-hostap-wfd/COPYING;md5=ab87f20cd7e8c0d0a6539b34d3791d0e \
                    file://mrvl387/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://realtek/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://dhd/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://mt5931/WIFI/wpa_supplicant_8_lib/COPYING;md5=ab87f20cd7e8c0d0a6539b34d3791d0e \
                    file://mt5931/WIFI/wpa_supplicant_8_lib/MODULE_LICENSE_BSD_LIKE;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://multi_wifi/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://bcm_ampak/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://bcm_ampak/tools/bcmdl/libusb-compat2/COPYING;md5=fbc093901857fcd118f065f900982c24 \
                    file://bcm_ampak/tools/bcmdl/libusb-compat2/LICENSE;md5=f2ac5f3ac4835e8f91324a26a590a423 \
                    file://bcm_ampak/tools/bcmdl/libusb2/COPYING;md5=fbc093901857fcd118f065f900982c24 \
                    file://bcm_usi/wpa_supplicant_8_lib/MODULE_LICENSE_BSD;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI = "http://openlinux.amlogic.com:8000/download/ARM/wifi/wifi-fw-${PV}.tar.gz"
SRC_URI[md5sum] = "3fd7fbbc31b9c0c9e73554763f0cfd84"
SRC_URI[sha256sum] = "289d1125a9f5ad4376d676da2fac8d76e4d03089f9c1bd45cd7dacaced6453d8"

S = "${WORKDIR}/wifi-fw-${PV}"

do_compile() {
	:
}

do_install() {
	install -d  ${D}/lib/firmware/brcm
	install ${S}/bcm_ampak/config/4356/fw_bcm4356a2_ag.bin ${D}/lib/firmware/brcm/brcmfmac4356-sdio.bin
	install ${S}/bcm_ampak/config/4356/nvram_ap6356.txt ${D}/lib/firmware/brcm/brcmfmac4356-sdio.txt
	install ${S}/bcm_ampak/config/4354/nvram_ap6354.txt ${D}/lib/firmware/brcm/brcmfmac4354-sdio.txt
}

FILES_${PN} += "/lib/firmware/*"
