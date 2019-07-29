SUMMARY = "Pre-Built Amlogic FIP Binaries distributed in U-Boot"
PROVIDES = "amlogic-fip"

LICENSE = "Proprietary"

COMPATIBLE_MACHINE_libretech-cc = "libretech-cc"
COMPATIBLE_MACHINE_libretech-ac = "libretech-ac"
COMPATIBLE_MACHINE_khadas-vim = "khadas-vim"
COMPATIBLE_MACHINE_amlogic-p212 = "amlogic-p212"
COMPATIBLE_MACHINE_friendlyelec-nanopik2 = "friendlyelec-nanopik2"
COMPATIBLE_MACHINE_amlogic-s400 = "amlogic-s400"

PV_libretech-cc = "libretech-cc_fip_20170606"
RELEASE_libretech-cc = "v2017.11-libretech-cc"
TARBALL_libretech-cc = "${PV}.tar.gz"
SHASUM_libretech-cc = "957c96037bcd792a4139cc33eded2f006d55a82c0c56ae69ef43bdcb76a255e2"
DEPLOY_CMD_libretech-cc = "do_deploy_gxl"
LIC_FILES_CHKSUM_libretech-cc = "file://fip/blx_fix.sh;md5=12ad2eef4a1dcc98f9eda15224b92836"

PV_libretech-ac = "libretech-cc_fip_20170606"
RELEASE_libretech-ac = "v2017.11-libretech-cc"
TARBALL_libretech-ac = "${PV}.tar.gz"
SHASUM_libretech-ac = "957c96037bcd792a4139cc33eded2f006d55a82c0c56ae69ef43bdcb76a255e2"
DEPLOY_CMD_libretech-ac = "do_deploy_gxl"
LIC_FILES_CHKSUM_libretech-ac = "file://fip/blx_fix.sh;md5=12ad2eef4a1dcc98f9eda15224b92836"

PV_amlogic-p212 = "p212_fip_20170606"
RELEASE_amlogic-p212 = "v2017.11-libretech-cc"
TARBALL_amlogic-p212 = "${PV}.tar.gz"
SHASUM_amlogic-p212 = "957c96037bcd792a4139cc33eded2f006d55a82c0c56ae69ef43bdcb76a255e2"
DEPLOY_CMD_amlogic-p212 = "do_deploy_gxl"
LIC_FILES_CHKSUM_amlogic-p212 = "file://fip/blx_fix.sh;md5=12ad2eef4a1dcc98f9eda15224b92836"

PV_khadas-vim = "khadas-vim_fip_20180207"
RELEASE_khadas-vim = "v2017.11-libretech-cc"
TARBALL_khadas-vim = "${PV}.tar.gz"
SHASUM_khadas-vim = "8dfdf0a267bbedde2229f22d41f0573f67a182a2bb4852db3baae884315f5acc"
DEPLOY_CMD_khadas-vim = "do_deploy_gxl"
LIC_FILES_CHKSUM_khadas-vim = "file://fip/blx_fix.sh;md5=12ad2eef4a1dcc98f9eda15224b92836"

PV_friendlyelec-nanopik2 = "nanopi-k2_fip_20170412"
RELEASE_friendlyelec-nanopik2 = "v2017.11-libretech-cc"
TARBALL_friendlyelec-nanopik2 = "${PV}.tar.gz"
SHASUM_friendlyelec-nanopik2 = "4b5778098ca2a4f7ade06db7752ec9f77775d67e438d6fba0c669a4959ff7200"
DEPLOY_CMD_friendlyelec-nanopik2 = "do_deploy_gxbb"
LIC_FILES_CHKSUM_friendlyelec-nanopik2 = "file://fip/blx_fix.sh;md5=f46c00cdc43c8ac6383cd6abdb773b0c"

PV_amlogic-s400 = "s400_fip_20181003"
RELEASE_amlogic-s400 = "v2017.11-libretech-cc"
TARBALL_amlogic-s400 = "${PV}.tar.gz"
SHASUM_amlogic-s400="3f4397cb3e807970ffe14db133af5357240539e93f681d44338b4fe637466c91"
DEPLOY_CMD_amlogic-s400="do_deploy_axg"
LIC_FILES_CHKSUM_amlogic-s400 = "file://fip/info.txt;md5=19a942801ba3839811357e7ff5b56379"

SRC_URI = "https://github.com/BayLibre/u-boot/releases/download/${RELEASE}/${TARBALL}"
SRC_URI[sha256sum] = "${SHASUM}"

S = "${WORKDIR}/"

inherit deploy

do_compile () {
	:
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy_gxbb () {
    mkdir -p ${DEPLOYDIR}/fip/
    install ${S}/fip/gxb/bl2.bin ${DEPLOYDIR}/fip/bl2.bin
    install ${S}/fip/gxb/acs.bin ${DEPLOYDIR}/fip/acs.bin
    install ${S}/fip/gxb/bl21.bin ${DEPLOYDIR}/fip/bl21.bin
    install ${S}/fip/gxb/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/fip/gxb/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/fip/gxb/bl31.img ${DEPLOYDIR}/fip/bl31.img
    install ${S}/fip/blx_fix.sh ${DEPLOYDIR}/fip/blx_fix.sh
    install ${S}/fip/acs_tool.pyc ${DEPLOYDIR}/fip/acs_tool.pyc
    install ${S}/fip/fip_create ${DEPLOYDIR}/fip/fip_create
    install ${S}/fip/gxb/aml_encrypt_gxb ${DEPLOYDIR}/fip/aml_encrypt_gxb
}

do_deploy_gxl () {
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

do_deploy_axg () {
    mkdir -p ${DEPLOYDIR}/fip/
    install ${S}/fip/bl2.bin ${DEPLOYDIR}/fip/bl2.bin
    install ${S}/fip/acs.bin ${DEPLOYDIR}/fip/acs.bin
    install ${S}/fip/bl21.bin ${DEPLOYDIR}/fip/bl21.bin
    install ${S}/fip/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/fip/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/fip/bl31.img ${DEPLOYDIR}/fip/bl31.img
    install ${S}/fip/blx_fix.sh ${DEPLOYDIR}/fip/blx_fix.sh
    install ${S}/fip/acs_tool.pyc ${DEPLOYDIR}/fip/acs_tool.pyc
    install ${S}/fip/aml_encrypt ${DEPLOYDIR}/fip/aml_encrypt
}

do_deploy() {
    ${DEPLOY_CMD}
}

addtask deploy before do_build after do_compile
