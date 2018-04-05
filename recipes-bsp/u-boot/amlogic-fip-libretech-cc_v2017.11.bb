SUMMARY = "Amlogic FIP Binaries distributed in U-Boot"
PROVIDES = "amlogic-fip-native"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://fip/blx_fix.sh;md5=12ad2eef4a1dcc98f9eda15224b92836"

SRC_URI = "https://github.com/BayLibre/u-boot/releases/download/v2017.11-libretech-cc/libretech-cc_fip_20170606.tar.gz"
SRC_URI[md5sum] = "ac86b984a2eb027633b72cb4f7dcf5dd"
SRC_URI[sha256sum] = "957c96037bcd792a4139cc33eded2f006d55a82c0c56ae69ef43bdcb76a255e2"

S = "${WORKDIR}/"

inherit deploy native

COMPATIBLE_MACHINE_libretech-cc = "libretech-cc"

do_compile () {
	:
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy () {
    mkdir -p ${DEPLOYDIR}/fip/
    install ${S}/fip/gxl/bl2.bin ${DEPLOYDIR}/fip/bl2.bin
    install ${S}/fip/gxl/acs.bin ${DEPLOYDIR}/fip/acs.bin
    install ${S}/fip/gxl/bl21.bin ${DEPLOYDIR}/fip/bl21.bin
    install ${S}/fip/gxl/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/fip/gxl/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/fip/gxl/bl31.img ${DEPLOYDIR}/fip/bl31.img
    install ${S}/fip/blx_fix.sh ${DEPLOYDIR}/fip/blx_fix.sh
    install ${S}/fip/acs_tool.pyc ${DEPLOYDIR}/fip/acs_tool.pyc
    install ${S}/fip/gxl/aml_encrypt_gxl ${DEPLOYDIR}/fip/aml_encrypt_gxl
}

addtask deploy before do_build after do_compile
