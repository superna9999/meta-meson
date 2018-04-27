SUMMARY = "Amlogic FIP Binaries distributed in U-Boot"
PROVIDES = "amlogic-fip"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://fip/bl2_fix.sh;md5=c7864e97af857505ef162eac95c799d0"

SRC_URI = "https://github.com/hardkernel/u-boot/archive/odroidc2-v2015.01.tar.gz"
SRC_URI[md5sum] = "c61ff317c13d05b28d73dc6c309b46f1"
SRC_URI[sha256sum] = "db9048119246031dc54bab448c4b270d3633016d2b4da101e420fd3131b221d2"

S = "${WORKDIR}/u-boot-odroidc2-v2015.01/"

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
