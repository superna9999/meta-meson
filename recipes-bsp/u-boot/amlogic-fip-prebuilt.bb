SUMMARY = "Pre-Built Amlogic FIP Binaries distributed in U-Boot"
PROVIDES = "amlogic-fip"

LICENSE = "Proprietary"

COMPATIBLE_MACHINE:libretech-cc = "libretech-cc"
COMPATIBLE_MACHINE:libretech-ac = "libretech-ac"
COMPATIBLE_MACHINE:khadas-vim = "khadas-vim"
COMPATIBLE_MACHINE:khadas-vim2 = "khadas-vim2"
COMPATIBLE_MACHINE:khadas-vim3 = "khadas-vim3"
COMPATIBLE_MACHINE:khadas-vim3l = "khadas-vim3l"
COMPATIBLE_MACHINE:amlogic-p212 = "amlogic-p212"
COMPATIBLE_MACHINE:friendlyelec-nanopik2 = "friendlyelec-nanopik2"
COMPATIBLE_MACHINE:amlogic-s400 = "amlogic-s400"
COMPATIBLE_MACHINE:hardkernel-odroidc4 = "hardkernel-odroidc4"
COMPATIBLE_MACHINE:hardkernel-odroidhc4 = "hardkernel-odroidhc4"
COMPATIBLE_MACHINE:hardkernel-odroidn2 = "hardkernel-odroidn2"
COMPATIBLE_MACHINE:hardkernel-odroidn2plus = "hardkernel-odroidn2plus"

SUBDIR:libretech-cc = "lepotato"
SUBDIR:libretech-ac = "lafrite"
SUBDIR:khadas-vim = "khadas-vim"
SUBDIR:khadas-vim2 = "khadas-vim2"
SUBDIR:khadas-vim3 = "khadas-vim3"
SUBDIR:khadas-vim3l = "khadas-vim3l"
SUBDIR:amlogic-p212 = "p212"
SUBDIR:friendlyelec-nanopik2 = "nanopi-k2"
SUBDIR:amlogic-s400 = "s400"
SUBDIR:hardkernel-odroidc4 = "odroid-c4"
SUBDIR:hardkernel-odroidhc4 = "odroid-hc4"
SUBDIR:hardkernel-odroidn2 = "odroid-n2"
SUBDIR:hardkernel-odroidn2plus = "odroid-n2-plus"

DEPLOY_CMD:libretech-cc = "do_deploy_gxl"
DEPLOY_CMD:libretech-ac = "do_deploy_gxl"
DEPLOY_CMD:amlogic-p212 = "do_deploy_gxl"
DEPLOY_CMD:khadas-vim = "do_deploy_gxl"
DEPLOY_CMD:khadas-vim2 = "do_deploy_gxl"
DEPLOY_CMD:khadas-vim3 = "do_deploy_g12b"
DEPLOY_CMD:khadas-vim3l = "do_deploy_g12a"
DEPLOY_CMD:friendlyelec-nanopik2 = "do_deploy_gxbb"
DEPLOY_CMD:amlogic-s400="do_deploy_axg"
DEPLOY_CMD:hardkernel-odroidc4 = "do_deploy_g12a"
DEPLOY_CMD:hardkernel-odroidhc4 = "do_deploy_g12a"
DEPLOY_CMD:hardkernel-odroidn2 = "do_deploy_g12b"
DEPLOY_CMD:hardkernel-odroidn2plus = "do_deploy_g12b"

LIC_FILES_CHKSUM = "file://lepotato/blx_fix.sh;md5=12ad2eef4a1dcc98f9eda15224b92836"

SRC_URI = "git://github.com/LibreELEC/amlogic-boot-fip.git"
SRCREV = "3384f1bc82fc554ed1fa0716bd821e1a2a350db2"

S = "${WORKDIR}/git"

inherit deploy

do_compile () {
	:
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy_gxbb () {
    mkdir -p ${DEPLOYDIR}/fip
    install ${S}/${SUBDIR}/bl2.bin ${DEPLOYDIR}/fip/bl2.bin
    install ${S}/${SUBDIR}/acs.bin ${DEPLOYDIR}/fip/acs.bin
    install ${S}/${SUBDIR}/bl21.bin ${DEPLOYDIR}/fip/bl21.bin
    install ${S}/${SUBDIR}/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/${SUBDIR}/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/${SUBDIR}/bl31.img ${DEPLOYDIR}/fip/bl31.img
    install ${S}/${SUBDIR}/blx_fix.sh ${DEPLOYDIR}/fip/blx_fix.sh
    install ${S}/${SUBDIR}/acs_tool.py ${DEPLOYDIR}/fip/acs_tool.py
    install ${S}/${SUBDIR}/fip_create ${DEPLOYDIR}/fip/fip_create
    install ${S}/${SUBDIR}/aml_encrypt_gxb ${DEPLOYDIR}/fip/aml_encrypt_gxb
}

do_deploy_gxl () {
    mkdir -p ${DEPLOYDIR}/fip
    install ${S}/${SUBDIR}/bl2.bin ${DEPLOYDIR}/fip/bl2.bin
    install ${S}/${SUBDIR}/acs.bin ${DEPLOYDIR}/fip/acs.bin
    install ${S}/${SUBDIR}/bl21.bin ${DEPLOYDIR}/fip/bl21.bin
    install ${S}/${SUBDIR}/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/${SUBDIR}/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/${SUBDIR}/bl31.img ${DEPLOYDIR}/fip/bl31.img
    install ${S}/${SUBDIR}/blx_fix.sh ${DEPLOYDIR}/fip/blx_fix.sh
    install ${S}/${SUBDIR}/acs_tool.py ${DEPLOYDIR}/fip/acs_tool.py
    install ${S}/${SUBDIR}/aml_encrypt_gxl ${DEPLOYDIR}/fip/aml_encrypt_gxl
}

do_deploy_axg () {
    mkdir -p ${DEPLOYDIR}/fip
    install ${S}/${SUBDIR}/bl2.bin ${DEPLOYDIR}/fip/bl2.bin
    install ${S}/${SUBDIR}/acs.bin ${DEPLOYDIR}/fip/acs.bin
    install ${S}/${SUBDIR}/bl21.bin ${DEPLOYDIR}/fip/bl21.bin
    install ${S}/${SUBDIR}/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/${SUBDIR}/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/${SUBDIR}/bl31.img ${DEPLOYDIR}/fip/bl31.img
    install ${S}/${SUBDIR}/blx_fix.sh ${DEPLOYDIR}/fip/blx_fix.sh
    install ${S}/${SUBDIR}/acs_tool.py ${DEPLOYDIR}/fip/acs_tool.py
    install ${S}/${SUBDIR}/aml_encrypt ${DEPLOYDIR}/fip/aml_encrypt
}

do_deploy_g12a () {
    mkdir -p ${DEPLOYDIR}/fip
    install ${S}/${SUBDIR}/bl2.bin ${DEPLOYDIR}/fip/bl2.bin
    install ${S}/${SUBDIR}/acs.bin ${DEPLOYDIR}/fip/acs.bin
    install ${S}/${SUBDIR}/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/${SUBDIR}/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/${SUBDIR}/bl31.img ${DEPLOYDIR}/fip/bl31.img
    install ${S}/${SUBDIR}/ddr3_1d.fw ${DEPLOYDIR}/fip/ddr3_1d.fw
    install ${S}/${SUBDIR}/ddr4_1d.fw ${DEPLOYDIR}/fip/ddr4_1d.fw
    install ${S}/${SUBDIR}/ddr4_2d.fw ${DEPLOYDIR}/fip/ddr4_2d.fw
    install ${S}/${SUBDIR}/diag_lpddr4.fw ${DEPLOYDIR}/fip/diag_lpddr4.fw
    [ -e "${S}/${SUBDIR}/lpddr3_1d.fw" ] && install ${S}/${SUBDIR}/lpddr3_1d.fw ${DEPLOYDIR}/fip/lpddr3_1d.fw
    install ${S}/${SUBDIR}/lpddr4_1d.fw ${DEPLOYDIR}/fip/lpddr4_1d.fw
    install ${S}/${SUBDIR}/lpddr4_2d.fw ${DEPLOYDIR}/fip/lpddr4_2d.fw
    install ${S}/${SUBDIR}/piei.fw ${DEPLOYDIR}/fip/piei.fw
    install ${S}/${SUBDIR}/aml_ddr.fw ${DEPLOYDIR}/fip/aml_ddr.fw
    install ${S}/${SUBDIR}/blx_fix.sh ${DEPLOYDIR}/fip/blx_fix.sh
    install ${S}/${SUBDIR}/acs_tool.py ${DEPLOYDIR}/fip/acs_tool.py
    install ${S}/${SUBDIR}/aml_encrypt_g12a ${DEPLOYDIR}/fip/aml_encrypt_g12a
}

do_deploy_g12b () {
    mkdir -p ${DEPLOYDIR}/fip
    install ${S}/${SUBDIR}/bl2.bin ${DEPLOYDIR}/fip/bl2.bin
    install ${S}/${SUBDIR}/acs.bin ${DEPLOYDIR}/fip/acs.bin
    install ${S}/${SUBDIR}/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/${SUBDIR}/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/${SUBDIR}/bl31.img ${DEPLOYDIR}/fip/bl31.img
    install ${S}/${SUBDIR}/ddr3_1d.fw ${DEPLOYDIR}/fip/ddr3_1d.fw
    install ${S}/${SUBDIR}/ddr4_1d.fw ${DEPLOYDIR}/fip/ddr4_1d.fw
    install ${S}/${SUBDIR}/ddr4_2d.fw ${DEPLOYDIR}/fip/ddr4_2d.fw
    install ${S}/${SUBDIR}/diag_lpddr4.fw ${DEPLOYDIR}/fip/diag_lpddr4.fw
    [ -e "${S}/${SUBDIR}/lpddr3_1d.fw" ] && install ${S}/${SUBDIR}/lpddr3_1d.fw ${DEPLOYDIR}/fip/lpddr3_1d.fw
    install ${S}/${SUBDIR}/lpddr4_1d.fw ${DEPLOYDIR}/fip/lpddr4_1d.fw
    install ${S}/${SUBDIR}/lpddr4_2d.fw ${DEPLOYDIR}/fip/lpddr4_2d.fw
    install ${S}/${SUBDIR}/piei.fw ${DEPLOYDIR}/fip/piei.fw
    install ${S}/${SUBDIR}/aml_ddr.fw ${DEPLOYDIR}/fip/aml_ddr.fw
    install ${S}/${SUBDIR}/blx_fix.sh ${DEPLOYDIR}/fip/blx_fix.sh
    install ${S}/${SUBDIR}/acs_tool.py ${DEPLOYDIR}/fip/acs_tool.py
    install ${S}/${SUBDIR}/aml_encrypt_g12b ${DEPLOYDIR}/fip/aml_encrypt_g12b
}

do_deploy() {
    ${DEPLOY_CMD}
}

addtask deploy before do_build after do_compile
