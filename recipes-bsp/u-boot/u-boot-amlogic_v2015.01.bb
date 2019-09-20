require recipes-bsp/u-boot/u-boot.inc
require u-boot-amlogic-common_${PV}.inc

COMPATIBLE_MACHINE_amlogic-p200 = "amlogic-p200"
COMPATIBLE_MACHINE_amlogic-p201 = "amlogic-p201"
COMPATIBLE_MACHINE_amlogic-p230 = "amlogic-p230"
COMPATIBLE_MACHINE_amlogic-p231 = "amlogic-p231"
COMPATIBLE_MACHINE_amlogic-p212 = "amlogic-p212"
COMPATIBLE_MACHINE_amlogic-q200 = "amlogic-q200"
COMPATIBLE_MACHINE_amlogic-q201 = "amlogic-q201"

PROVIDES =+ "u-boot"

DEPENDS += "bc-native"

do_deploy_append () {
    install ${S}/fip/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
}
