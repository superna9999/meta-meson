SUMMARY = "Pre-Built Amlogic FIP Binaries distributed in U-Boot"
PROVIDES = "virtual/trusted-firmware-a"

LICENSE = "Proprietary"

DEPENDS = "u-boot python3-native"

# TOFIX only build on x86_64 host

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = ""
COMPATIBLE_MACHINE_libretech-cc = "libretech-cc"
COMPATIBLE_MACHINE_libretech-ac = "libretech-ac"
COMPATIBLE_MACHINE_khadas-vim = "khadas-vim"
COMPATIBLE_MACHINE_khadas-vim2 = "khadas-vim2"
COMPATIBLE_MACHINE_khadas-vim3 = "khadas-vim3"
COMPATIBLE_MACHINE_khadas-vim3l = "khadas-vim3l"
COMPATIBLE_MACHINE_amlogic-p200 = "amlogic-p200"
COMPATIBLE_MACHINE_amlogic-p201 = "amlogic-p201"
COMPATIBLE_MACHINE_amlogic-p212 = "amlogic-p212"
COMPATIBLE_MACHINE_friendlyelec-nanopik2 = "friendlyelec-nanopik2"
COMPATIBLE_MACHINE_amlogic-s400 = "amlogic-s400"
COMPATIBLE_MACHINE_hardkernel-odroidc2 = "hardkernel-odroidc2"
COMPATIBLE_MACHINE_hardkernel-odroidc4 = "hardkernel-odroidc4"
COMPATIBLE_MACHINE_hardkernel-odroidhc4 = "hardkernel-odroidhc4"
COMPATIBLE_MACHINE_hardkernel-odroidn2 = "hardkernel-odroidn2"
COMPATIBLE_MACHINE_hardkernel-odroidn2plus = "hardkernel-odroidn2plus"
COMPATIBLE_MACHINE_seirobotics-sei510 = "seirobotics-sei510"
COMPATIBLE_MACHINE_seirobotics-sei610 = "seirobotics-sei610"

MODEL_libretech-cc = "lepotato"
MODEL_libretech-ac = "lafrite"
MODEL_khadas-vim = "khadas-vim"
MODEL_khadas-vim2 = "khadas-vim2"
MODEL_khadas-vim3 = "khadas-vim3"
MODEL_khadas-vim3l = "khadas-vim3l"
MODEL_amlogic-p200 = "p200"
MODEL_amlogic-p201 = "p201"
MODEL_amlogic-p212 = "p212"
MODEL_friendlyelec-nanopik2 = "nanopi-k2"
MODEL_amlogic-s400 = "s400"
MODEL_hardkernel-odroidc2 = "odroid-c2"
MODEL_hardkernel-odroidc4 = "odroid-c4"
MODEL_hardkernel-odroidhc4 = "odroid-hc4"
MODEL_hardkernel-odroidn2 = "odroid-n2"
MODEL_hardkernel-odroidn2plus = "odroid-n2-plus"
MODEL_seirobotics-sei510 = "sei510"
MODEL_seirobotics-sei610 = "sei610"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2dbd68496cc5ed3e68e855100cb86363"

SRC_URI = "git://github.com/LibreELEC/amlogic-boot-fip.git;protocol=https;branch=master"
SRCREV = "7ff0004e0e4d261ba81334a2f46302bd06704aca"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit deploy

do_compile () {
	mkdir -p ${B} ${B}/tmp
	(cd ${S} ; ./build-fip.sh ${MODEL} ${DEPLOY_DIR_IMAGE}/u-boot.bin ${B} ${B}/tmp)
}
do_compile[depends] += "u-boot:do_deploy"
do_compile[cleandirs] = "${B}"

do_deploy () {
    install ${B}/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
    install ${B}/u-boot.bin ${DEPLOYDIR}/u-boot.bin.mmc.bin
    install ${B}/u-boot.bin.usb.bl2 ${DEPLOYDIR}/u-boot.bin.usb.bl2
    install ${B}/u-boot.bin.usb.tpl ${DEPLOYDIR}/u-boot.bin.usb.tpl
}

addtask deploy after do_compile
