require u-boot-amlogic.inc
require u-boot-khadas-vim-common_${PV}.inc

DEPENDS += "bc-native"

PROVIDES =+ "u-boot"

COMPATIBLE_MACHINE = "khadas-vim"

do_deploy:append () {
    install ${S}/fip/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
}

