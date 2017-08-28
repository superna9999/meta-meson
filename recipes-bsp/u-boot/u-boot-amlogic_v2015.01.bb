HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
PE = "1"

S = "${WORKDIR}/git"

require recipes-bsp/u-boot/u-boot.inc

LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

COMPATIBLE_MACHINE_amlogic-p200 = "amlogic-p200"
COMPATIBLE_MACHINE_amlogic-p201 = "amlogic-p201"
COMPATIBLE_MACHINE_amlogic-p230 = "amlogic-p230"
COMPATIBLE_MACHINE_amlogic-p231 = "amlogic-p231"
COMPATIBLE_MACHINE_amlogic-p212 = "amlogic-p212"
COMPATIBLE_MACHINE_amlogic-q200 = "amlogic-q200"
COMPATIBLE_MACHINE_amlogic-q201 = "amlogic-q201"

SRCREV = "ffd40ecd0ea21fcb44462a0124eb843d34ef5c3e"
SRCBRANCH = "n-amlogic-openlinux-20170606"
SRCREPO = "git://github.com/BayLibre/u-boot.git"

PV = "v2015.01+git${SRCPV}"
PR = "r0"

PROVIDES =+ "u-boot"

SRC_URI = "${SRCREPO};branch=${SRCBRANCH} \
	   https://releases.linaro.org/archive/13.11/components/toolchain/binaries/gcc-linaro-aarch64-none-elf-4.8-2013.11_linux.tar.xz;md5sum=5fd777bee04a79435a0861efd473ec0e \
	   https://releases.linaro.org/archive/13.11/components/toolchain/binaries/gcc-linaro-arm-none-eabi-4.8-2013.11_linux.tar.xz;md5sum=b1cec0cd4ba10aa6865f54b738ba7796 \
	   file://0001-remove-hardcoded-toolchain-path.patch \
"

EXTRA_OEMAKE = 'V=1'
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'

do_deploy_append () {
    install ${S}/fip/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
}

do_compile_prepend() {
	export PATH=${S}/../gcc-linaro-aarch64-none-elf-4.8-2013.11_linux/bin:$PATH
	export PATH=${S}/../gcc-linaro-arm-none-eabi-4.8-2013.11_linux/bin:$PATH
	(cd ${S} ; ln -s ${B} build)
}
