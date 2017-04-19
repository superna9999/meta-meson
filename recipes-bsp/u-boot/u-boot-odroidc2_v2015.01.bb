require recipes-bsp/u-boot/u-boot.inc

LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

COMPATIBLE_MACHINE = "hardkernel-odroidc2"

SRCREV = "205c7b3259559283161703a1a200b787c2c445a5"

PV = "v2015.01+git${SRCPV}"
PR = "r0"

PROVIDES =+ "u-boot"

SRC_URI = "git://github.com/hardkernel/u-boot.git;branch=odroidc2-v2015.01 \
	   file://0001-distclean.patch \
"

BL1_SUFFIX ?= "bin.hardkernel"
BL1_IMAGE ?= "bl1-${MACHINE}-${PV}-${PR}.${BL1_SUFFIX}"
BL1_BINARY ?= "bl1.${BL1_SUFFIX}"
BL1_SYMLINK ?= "bl1-${MACHINE}.${BL1_SUFFIX}"

do_deploy_append () {
    install ${S}/sd_fuse/${BL1_BINARY} ${DEPLOYDIR}/${BL1_IMAGE}
    install ${S}/sd_fuse/sd_fusing.sh ${DEPLOYDIR}/sd_fusing.sh
    cd ${DEPLOYDIR}
    rm -f ${BL1_BINARY} ${BL1_SYMLINK}
    ln -sf ${BL1_IMAGE} ${BL1_SYMLINK}
    ln -sf ${BL1_IMAGE} ${BL1_BINARY}
}
