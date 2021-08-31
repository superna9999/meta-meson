HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
PE = "1"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

SRCREV = "ffd40ecd0ea21fcb44462a0124eb843d34ef5c3e"
SRCBRANCH = "n-amlogic-openlinux-20170606"
SRCREPO = "git://github.com/BayLibre/u-boot.git"

PV = "v2015.01+git${SRCPV}"
PR = "r0"

SRC_URI = "${SRCREPO};branch=${SRCBRANCH} \
	   https://releases.linaro.org/archive/13.11/components/toolchain/binaries/gcc-linaro-aarch64-none-elf-4.8-2013.11_linux.tar.xz;md5sum=5fd777bee04a79435a0861efd473ec0e \
	   https://releases.linaro.org/archive/13.11/components/toolchain/binaries/gcc-linaro-arm-none-eabi-4.8-2013.11_linux.tar.xz;md5sum=b1cec0cd4ba10aa6865f54b738ba7796 \
	   file://0001-remove-hardcoded-toolchain-path.patch \
	   file://acs_tool.py \
"

EXTRA_OEMAKE = 'V=1'
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'

do_compile:prepend() {
	export PATH=${S}/../gcc-linaro-aarch64-none-elf-4.8-2013.11_linux/bin:$PATH
	export PATH=${S}/../gcc-linaro-arm-none-eabi-4.8-2013.11_linux/bin:$PATH
	(cd ${S} ; ln -s ${B} build)
	[ -e ${S}/fip/acs_tool.pyc ] && rm ${S}/fip/acs_tool.pyc
	cp ${WORKDIR}/acs_tool.py ${S}/fip/
	sed -i "s,python ,python3 ," ${S}/Makefile
	sed -i "s,acs_tool.pyc,acs_tool.py," ${S}/Makefile
}
