HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
PE = "1"

S = "${WORKDIR}/git"

require recipes-bsp/u-boot/u-boot.inc

LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

COMPATIBLE_MACHINE_friendlyelec-nanopik2 = "friendlyelec-nanopik2"

SRCREV = "4ef665ff6c6ff32a480478589ddf1df325c5f04d"

PV = "v2015.01+git${SRCPV}"
PR = "r0"

PROVIDES =+ "u-boot"

#https://launchpad.net/gcc-arm-embedded/4.9/4.9-2015-q3-update/+download/gcc-arm-none-eabi-4_9-2015q3-20150921-linux.tar.bz2;md5sum=8a4a74872830f80c788c944877d3ad8c
#http://releases.linaro.org/archive/14.09/components/toolchain/binaries/gcc-linaro-aarch64-linux-gnu-4.9-2014.09_linux.tar.bz2;md5sum=844189ae1604613d94a1f922bff1c11f

SRC_URI = "git://github.com/friendlyarm/u-boot.git;branch=nanopi-k2-v2015.01 \
	   https://github.com/friendlyarm/prebuilts/raw/master/gcc-x64/arm-cortexa9-linux-gnueabihf-4.9.3.tar.xz;md5sum=e7aaf6a49967a5a5a8e5f295d972de2e \
	   http://releases.linaro.org/components/toolchain/binaries/4.9-2017.01/aarch64-linux-gnu/gcc-linaro-4.9.4-2017.01-x86_64_aarch64-linux-gnu.tar.xz;md5sum=631c4c7b1fe9cb115cf51bd6a926acb7 \
           file://0001-Add-GCC7-supportation.patch \
           file://0002-fix-build-error-under-gcc6.patch \
           file://0003-fix-s3c-udc-otg-build.patch \
           file://0004-remove-warnings-errors.patch \
           file://0005-disable-pedantic-for-firmware-build.patch \
           "

EXTRA_OEMAKE = 'V=1'
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'

do_deploy_append () {
    install ${S}/fip/u-boot.bin ${DEPLOYDIR}/u-boot.bin
}

do_compile_prepend() {
	export PATH=${S}/../4.9.3/bin:$PATH
	export PATH=${S}/../gcc-linaro-4.9.4-2017.01-x86_64_aarch64-linux-gnu/bin:$PATH
	(cd ${S} ; ln -s ${B} build)
}
