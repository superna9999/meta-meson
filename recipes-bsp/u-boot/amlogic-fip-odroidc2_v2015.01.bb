SUMMARY = "Amlogic FIP Binaries distributed in U-Boot"
PROVIDES = "amlogic-fip"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://fip/bl2_fix.sh;md5=c7864e97af857505ef162eac95c799d0"

UBOOT_GIT_REV = "95264d19d04930f67f10f162df70de447659329"

SRC_URI = "https://github.com/hardkernel/u-boot/archive/${UBOOT_GIT_REV}.tar.gz"
SRC_URI[md5sum] = "76ea3b34010b56640e8f1deaf28b29c3"
SRC_URI[sha256sum] = "440cbb4f48251383b1eeef7306d891b502aaf48e2c923833992e1e901ea230bf"

S = "${WORKDIR}/u-boot-${UBOOT_GIT_REV}/"

inherit deploy

COMPATIBLE_MACHINE_hardkernel-odroidc2 = "hardkernel-odroidc2"

do_compile () {
	:
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy () {
    mkdir -p ${DEPLOYDIR}/fip/
    install ${S}/fip/gxb/bl301.bin ${DEPLOYDIR}/fip/bl301.bin
    install ${S}/fip/gxb/bl30.bin ${DEPLOYDIR}/fip/bl30.bin
    install ${S}/fip/gxb/bl2.package ${DEPLOYDIR}/fip/bl2.package
    install ${S}/fip/gxb/bl31.bin ${DEPLOYDIR}/fip/bl31.bin
    install ${S}/fip/gxb/aml_encrypt_gxb ${DEPLOYDIR}/fip/aml_encrypt_gxb
    install ${S}/fip/bl2_fix.sh ${DEPLOYDIR}/fip/bl2_fix.sh
    install ${S}/fip/acs_tool.pyc ${DEPLOYDIR}/fip/acs_tool.pyc
    install ${S}/fip/fip_create ${DEPLOYDIR}/fip/fip_create
    install ${S}/sd_fuse/bl1.bin.hardkernel ${DEPLOYDIR}/bl1.bin.hardkernel
}

addtask deploy before do_build after do_compile
