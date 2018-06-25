LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-mkimage-native zip-native"

SRC_URI = "file://aml_autoscript.cmd"

inherit deploy

S = "${WORKDIR}"

do_compile() {
	mkimage -A arm64 -O linux -T script -C none -a 0 -e 0 -n "aml_autoscript" -d ${WORKDIR}/aml_autoscript.cmd ${B}/aml_autoscript
	zip ${B}/aml_autoscript.zip ${B}/aml_autoscript
}

do_deploy() {
	install ${B}/aml_autoscript ${DEPLOYDIR}/aml_autoscript
	install ${B}/aml_autoscript.zip ${DEPLOYDIR}/aml_autoscript.zip
}

addtask deploy before do_build after do_compile
