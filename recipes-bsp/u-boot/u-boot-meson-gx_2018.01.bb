require u-boot-common_${PV}.inc
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "bc-native dtc-native python-native amlogic-fip"

PROVIDES = "u-boot"

deploy_gxbb () {
    FIPDIR="${DEPLOY_DIR_IMAGE}/fip/"
    DESTDIR="${B}/fip"

    mkdir -p ${DESTDIR}

    cp ${FIPDIR}/bl31.img ${DESTDIR}/bl31.img
    cp ${B}/u-boot.bin ${DESTDIR}/bl33.bin

    ${FIPDIR}/blx_fix.sh ${FIPDIR}/bl30.bin \
			 ${DESTDIR}/zero_tmp \
			 ${DESTDIR}/bl30_zero.bin \
			 ${FIPDIR}/bl301.bin \
			 ${DESTDIR}/bl301_zero.bin \
			 ${DESTDIR}/bl30_new.bin bl30

    ${FIPDIR}/fip_create --bl30 ${DESTDIR}/bl30_new.bin \
			 --bl31 ${FIPDIR}/bl31.img \
			 --bl33 ${DESTDIR}/bl33.bin \
			 ${DESTDIR}/fip.bin

    python ${FIPDIR}/acs_tool.pyc ${FIPDIR}/bl2.bin \
				  ${DESTDIR}/bl2_acs.bin \
				  ${FIPDIR}/acs.bin 0

    ${FIPDIR}/blx_fix.sh ${DESTDIR}/bl2_acs.bin \
			 ${DESTDIR}/zero_tmp \
			 ${DESTDIR}/bl2_zero.bin \
			 ${FIPDIR}/bl21.bin \
			 ${DESTDIR}/bl21_zero.bin \
			 ${DESTDIR}/bl2_new.bin bl2

    cat ${DESTDIR}/bl2_new.bin ${DESTDIR}/fip.bin > ${DESTDIR}/boot_new.bin

    ${FIPDIR}/aml_encrypt_gxb --bootsig --input ${DESTDIR}/boot_new.bin \
			      --output ${DESTDIR}/u-boot.bin

    # SDCard
    install ${DESTDIR}/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
    # eMMC
    install ${DESTDIR}/u-boot.bin ${DEPLOYDIR}/u-boot.bin
}

deploy_gxl () {
    FIPDIR="${DEPLOY_DIR_IMAGE}/fip/"
    DESTDIR="${B}/fip"
    
    mkdir -p ${DESTDIR}

    cp ${FIPDIR}/bl31.img ${DESTDIR}/bl31.img
    cp ${B}/u-boot.bin ${DESTDIR}/bl33.bin

    ${FIPDIR}/blx_fix.sh ${FIPDIR}/bl30.bin \
			 ${DESTDIR}/zero_tmp \
			 ${DESTDIR}/bl30_zero.bin \
			 ${FIPDIR}/bl301.bin \
			 ${DESTDIR}/bl301_zero.bin \
			 ${DESTDIR}/bl30_new.bin bl30
    python ${FIPDIR}/acs_tool.pyc ${FIPDIR}/bl2.bin \
				  ${DESTDIR}/bl2_acs.bin \
				  ${FIPDIR}/acs.bin 0
    ${FIPDIR}/blx_fix.sh ${DESTDIR}/bl2_acs.bin \
			 ${DESTDIR}/zero_tmp \
			 ${DESTDIR}/bl2_zero.bin \
			 ${FIPDIR}/bl21.bin \
			 ${DESTDIR}/bl21_zero.bin \
			 ${DESTDIR}/bl2_new.bin bl2

    ${FIPDIR}/aml_encrypt_gxl --bl3enc --input ${DESTDIR}/bl30_new.bin
    ${FIPDIR}/aml_encrypt_gxl --bl3enc --input ${DESTDIR}/bl31.img
    ${FIPDIR}/aml_encrypt_gxl --bl3enc --input ${DESTDIR}/bl33.bin
    ${FIPDIR}/aml_encrypt_gxl --bl2sig --input ${DESTDIR}/bl2_new.bin --output ${DESTDIR}/bl2.n.bin.sig
    ${FIPDIR}/aml_encrypt_gxl --bootmk --output ${DESTDIR}/u-boot.bin \
			      --bl2 ${DESTDIR}/bl2.n.bin.sig \
			      --bl30 ${DESTDIR}/bl30_new.bin.enc \
			      --bl31 ${DESTDIR}/bl31.img.enc \
			      --bl33 ${DESTDIR}/bl33.bin.enc

    # SDCard
    install ${DESTDIR}/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
    # eMMC
    install ${DESTDIR}/u-boot.bin ${DEPLOYDIR}/u-boot.bin
} 

deploy_odroidc2 () {
    FIPDIR="${DEPLOY_DIR_IMAGE}/fip/"
    DESTDIR="${B}/fip"
    
    mkdir -p ${DESTDIR}

    ${FIPDIR}/fip_create --bl30 ${FIPDIR}/bl30.bin \
			 --bl301 ${FIPDIR}/bl301.bin \
			 --bl31 ${FIPDIR}/bl31.bin \
			 --bl33 ${B}/u-boot.bin \
			 ${DESTDIR}/fip.bin
    ${FIPDIR}/fip_create --dump ${DESTDIR}/fip.bin
    cat ${FIPDIR}/bl2.package ${DESTDIR}/fip.bin > ${DESTDIR}/boot_new.bin

    ${FIPDIR}/aml_encrypt_gxb --bootsig \
			      --input ${DESTDIR}/boot_new.bin \
			      --output ${DESTDIR}/u-boot.img

    install ${DESTDIR}/u-boot.img ${DEPLOYDIR}/u-boot.img
} 

DEPLOY_COMMAND_meson-gxl = "deploy_gxl"
DEPLOY_COMMAND_meson-gxbb = "deploy_gxbb"
DEPLOY_COMMAND_hardkernel-odroidc2 = "deploy_odroidc2"

do_deploy_append_meson-gx () {
	${DEPLOY_COMMAND}
}
