SUMMARY = "Pre-Built Amlogic FIP Binaries distributed in U-Boot"
PROVIDES = "amlogic-fip"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://fip/blx_fix.sh;md5=12ad2eef4a1dcc98f9eda15224b92836"

COMPATIBLE_MACHINE_libretech-cc = "libretech-cc"
COMPATIBLE_MACHINE_khadas-vim = "khadas-vim"
COMPATIBLE_MACHINE_amlogic-p212 = "amlogic-p212"

PV_libretech-cc = "libretech-cc_fip_20170606"
RELEASE_libretech-cc = "v2017.11-libretech-cc"
TARBALL_libretech-cc = "${PV}.tar.gz"
SHASUM_libretech-cc = "957c96037bcd792a4139cc33eded2f006d55a82c0c56ae69ef43bdcb76a255e2"

PV_amlogic-p212 = "p212_fip_20170606"
RELEASE_amlogic-p212 = "v2017.11-libretech-cc"
TARBALL_amlogic-p212 = "${PV}.tar.gz"
SHASUM_amlogic-p212 = "957c96037bcd792a4139cc33eded2f006d55a82c0c56ae69ef43bdcb76a255e2"

PV_khadas-vim = "khadas-vim_fip_20180207"
RELEASE_khadas-vim = "v2017.11-libretech-cc"
TARBALL_khadas-vim = "${PV}.tar.gz"
SHASUM_khadas-vim = "8dfdf0a267bbedde2229f22d41f0573f67a182a2bb4852db3baae884315f5acc"

SRC_URI = "https://github.com/BayLibre/u-boot/releases/download/${RELEASE}/${TARBALL}"
SRC_URI[sha256sum] = "${SHASUM}"

S = "${WORKDIR}/"

inherit deploy

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
