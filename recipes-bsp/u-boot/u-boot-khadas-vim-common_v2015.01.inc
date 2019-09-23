HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
PE = "1"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

SRCREV = "8bd0349fc5ad324b988caf681139ea5d8ff4bf69"

PV = "v2015.01+git${SRCPV}"
PR = "r0"

SRC_URI = "git://github.com/khadas/u-boot.git;branch=khadas-vims-nougat-multios \
           https://launchpad.net/gcc-arm-embedded/4.9/4.9-2015-q3-update/+download/gcc-arm-none-eabi-4_9-2015q3-20150921-linux.tar.bz2;md5sum=8a4a74872830f80c788c944877d3ad8c \
           http://releases.linaro.org/archive/14.09/components/toolchain/binaries/gcc-linaro-aarch64-linux-gnu-4.9-2014.09_linux.tar.bz2;md5sum=844189ae1604613d94a1f922bff1c11f \
           file://0002-fix-build-error-under-gcc6.patch \
           file://0003-fix-s3c-udc-otg-build.patch \
           file://0004-remove-warnings-errors.patch \
           "

EXTRA_OEMAKE = 'CROSS_COMPILE=aarch64-linux-gnu- V=1'
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'

do_compile_prepend() {
	export PATH=${S}/../gcc-arm-none-eabi-4_9-2015q3/bin:$PATH
	export PATH=${S}/../gcc-linaro-aarch64-linux-gnu-4.9-2014.09_linux/bin:$PATH
	(cd ${S} ; ln -s ${B} build)
}
