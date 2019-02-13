LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://boot.cmd"

inherit deploy

S = "${WORKDIR}"

do_configure() {
	:
}

do_compile() {
	mkimage -A arm -T script -C none -d ${B}/boot.cmd ${B}/boot.scr
}

do_deploy() {
	install ${B}/boot.scr ${DEPLOYDIR}/boot.scr
}

addtask deploy before do_build after do_compile
