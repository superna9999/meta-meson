require u-boot-common_${PV}.inc
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "bison-native bc-native dtc-native python3-native amlogic-fip"

PROVIDES = "u-boot virtual/bootloader"

SRC_URI_append = " \
	file://acs_tool.py \
	file://fit.cfg \
"

deploy_axg () {
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
    python3 ${WORKDIR}/acs_tool.py ${FIPDIR}/bl2.bin \
				  ${DESTDIR}/bl2_acs.bin \
				  ${FIPDIR}/acs.bin 0
    ${FIPDIR}/blx_fix.sh ${DESTDIR}/bl2_acs.bin \
			 ${DESTDIR}/zero_tmp \
			 ${DESTDIR}/bl2_zero.bin \
			 ${FIPDIR}/bl21.bin \
			 ${DESTDIR}/bl21_zero.bin \
			 ${DESTDIR}/bl2_new.bin bl2

    ${FIPDIR}/aml_encrypt --bl3sig --input ${DESTDIR}/bl30_new.bin --output ${DESTDIR}/bl30_new.bin.enc --level 3 --type bl30
    ${FIPDIR}/aml_encrypt --bl3sig --input ${DESTDIR}/bl31.img --output ${DESTDIR}/bl31.img.enc --level 3 --type bl31
    ${FIPDIR}/aml_encrypt --bl3sig --input ${DESTDIR}/bl33.bin --output ${DESTDIR}/bl33.bin.enc --level 3 --type bl33 --compress lz4
    ${FIPDIR}/aml_encrypt --bl2sig --input ${DESTDIR}/bl2_new.bin --output ${DESTDIR}/bl2.n.bin.sig
    ${FIPDIR}/aml_encrypt --bootmk --output ${DESTDIR}/u-boot.bin \
			  --bl2 ${DESTDIR}/bl2.n.bin.sig \
			  --bl30 ${DESTDIR}/bl30_new.bin.enc \
			  --bl31 ${DESTDIR}/bl31.img.enc \
			  --bl33 ${DESTDIR}/bl33.bin.enc \
			  --level 3

    # SDCard
    install ${DESTDIR}/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
    # eMMC
    install ${DESTDIR}/u-boot.bin ${DEPLOYDIR}/u-boot.bin
    # USB
    install ${DESTDIR}/u-boot.bin.usb.bl2 ${DEPLOYDIR}/u-boot.bin.usb.bl2
    install ${DESTDIR}/u-boot.bin.usb.tpl ${DEPLOYDIR}/u-boot.bin.usb.tpl
}

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

    python3 ${WORKDIR}/acs_tool.py ${FIPDIR}/bl2.bin \
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
    # USB
    install ${DESTDIR}/u-boot.bin.usb.bl2 ${DEPLOYDIR}/u-boot.bin.usb.bl2
    install ${DESTDIR}/u-boot.bin.usb.tpl ${DEPLOYDIR}/u-boot.bin.usb.tpl
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
    python3 ${WORKDIR}/acs_tool.py ${FIPDIR}/bl2.bin \
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
    # USB
    install ${DESTDIR}/u-boot.bin.usb.bl2 ${DEPLOYDIR}/u-boot.bin.usb.bl2
    install ${DESTDIR}/u-boot.bin.usb.tpl ${DEPLOYDIR}/u-boot.bin.usb.tpl
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

deploy_g12a () {
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

    ${FIPDIR}/blx_fix.sh ${FIPDIR}/bl2.bin \
			 ${DESTDIR}/zero_tmp \
			 ${DESTDIR}/bl2_zero.bin \
			 ${FIPDIR}/acs.bin \
			 ${DESTDIR}/bl21_zero.bin \
			 ${DESTDIR}/bl2_new.bin bl2

    ${FIPDIR}/aml_encrypt_g12a --bl30sig \
		    --input ${DESTDIR}/bl30_new.bin \
		    --output ${DESTDIR}/bl30_new.bin.g12.enc \
		    --level v3
    ${FIPDIR}/aml_encrypt_g12a --bl3sig \
		    --input ${DESTDIR}/bl30_new.bin.g12.enc \
		    --output ${DESTDIR}/bl30_new.bin.enc \
		    --level v3 --type bl30
    ${FIPDIR}/aml_encrypt_g12a --bl3sig \
		    --input ${FIPDIR}/bl31.img \
		    --output ${DESTDIR}/bl31.img.enc \
		    --level v3 --type bl31
    ${FIPDIR}/aml_encrypt_g12a --bl3sig \
		    --input ${DESTDIR}/bl33.bin \
		    --compress lz4 \
		    --output ${DESTDIR}/bl33.bin.enc \
		    --level v3 --type bl33
    ${FIPDIR}/aml_encrypt_g12a --bl2sig \
		    --input ${DESTDIR}/bl2_new.bin \
		    --output ${DESTDIR}/bl2.n.bin.sig

    if [ -e ${FIPDIR}/lpddr3_1d.fw ]
    then
            ${FIPDIR}/aml_encrypt_g12a --bootmk \
                    --output ${DESTDIR}/u-boot.bin \
                    --bl2 ${DESTDIR}/bl2.n.bin.sig \
                    --bl30 ${DESTDIR}/bl30_new.bin.enc \
                    --bl31 ${DESTDIR}/bl31.img.enc \
                    --bl33 ${DESTDIR}/bl33.bin.enc \
                    --ddrfw1 ${FIPDIR}/ddr4_1d.fw \
                    --ddrfw2 ${FIPDIR}/ddr4_2d.fw \
                    --ddrfw3 ${FIPDIR}/ddr3_1d.fw \
                    --ddrfw4 ${FIPDIR}/piei.fw \
                    --ddrfw5 ${FIPDIR}/lpddr4_1d.fw \
                    --ddrfw6 ${FIPDIR}/lpddr4_2d.fw \
                    --ddrfw7 ${FIPDIR}/diag_lpddr4.fw \
                    --ddrfw8 ${FIPDIR}/aml_ddr.fw \
                    --ddrfw9 ${FIPDIR}/lpddr3_1d.fw \
                    --level v3
    else
            ${FIPDIR}/aml_encrypt_g12a --bootmk \
                    --output ${DESTDIR}/u-boot.bin \
                    --bl2 ${DESTDIR}/bl2.n.bin.sig \
                    --bl30 ${DESTDIR}/bl30_new.bin.enc \
                    --bl31 ${DESTDIR}/bl31.img.enc \
                    --bl33 ${DESTDIR}/bl33.bin.enc \
                    --ddrfw1 ${FIPDIR}/ddr4_1d.fw \
                    --ddrfw2 ${FIPDIR}/ddr4_2d.fw \
                    --ddrfw3 ${FIPDIR}/ddr3_1d.fw \
                    --ddrfw4 ${FIPDIR}/piei.fw \
                    --ddrfw5 ${FIPDIR}/lpddr4_1d.fw \
                    --ddrfw6 ${FIPDIR}/lpddr4_2d.fw \
                    --ddrfw7 ${FIPDIR}/diag_lpddr4.fw \
                    --ddrfw8 ${FIPDIR}/aml_ddr.fw \
                    --level v3
    fi

    # SDCard
    install ${DESTDIR}/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
    # eMMC
    install ${DESTDIR}/u-boot.bin ${DEPLOYDIR}/u-boot.bin
    # USB
    install ${DESTDIR}/u-boot.bin.usb.bl2 ${DEPLOYDIR}/u-boot.bin.usb.bl2
    install ${DESTDIR}/u-boot.bin.usb.tpl ${DEPLOYDIR}/u-boot.bin.usb.tpl
}

deploy_g12b () {
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

    ${FIPDIR}/blx_fix.sh ${FIPDIR}/bl2.bin \
			 ${DESTDIR}/zero_tmp \
			 ${DESTDIR}/bl2_zero.bin \
			 ${FIPDIR}/acs.bin \
			 ${DESTDIR}/bl21_zero.bin \
			 ${DESTDIR}/bl2_new.bin bl2

    ${FIPDIR}/aml_encrypt_g12b --bl30sig \
		    --input ${DESTDIR}/bl30_new.bin \
		    --output ${DESTDIR}/bl30_new.bin.g12.enc \
		    --level v3
    ${FIPDIR}/aml_encrypt_g12b --bl3sig \
		    --input ${DESTDIR}/bl30_new.bin.g12.enc \
		    --output ${DESTDIR}/bl30_new.bin.enc \
		    --level v3 --type bl30
    ${FIPDIR}/aml_encrypt_g12b --bl3sig \
		    --input ${FIPDIR}/bl31.img \
		    --output ${DESTDIR}/bl31.img.enc \
		    --level v3 --type bl31
    ${FIPDIR}/aml_encrypt_g12b --bl3sig \
		    --input ${DESTDIR}/bl33.bin \
		    --compress lz4 \
		    --output ${DESTDIR}/bl33.bin.enc \
		    --level v3 --type bl33
    ${FIPDIR}/aml_encrypt_g12b --bl2sig \
		    --input ${DESTDIR}/bl2_new.bin \
		    --output ${DESTDIR}/bl2.n.bin.sig

    if [ -e ${FIPDIR}/lpddr3_1d.fw ]
    then
            ${FIPDIR}/aml_encrypt_g12b --bootmk \
                    --output ${DESTDIR}/u-boot.bin \
                    --bl2 ${DESTDIR}/bl2.n.bin.sig \
                    --bl30 ${DESTDIR}/bl30_new.bin.enc \
                    --bl31 ${DESTDIR}/bl31.img.enc \
                    --bl33 ${DESTDIR}/bl33.bin.enc \
                    --ddrfw1 ${FIPDIR}/ddr4_1d.fw \
                    --ddrfw2 ${FIPDIR}/ddr4_2d.fw \
                    --ddrfw3 ${FIPDIR}/ddr3_1d.fw \
                    --ddrfw4 ${FIPDIR}/piei.fw \
                    --ddrfw5 ${FIPDIR}/lpddr4_1d.fw \
                    --ddrfw6 ${FIPDIR}/lpddr4_2d.fw \
                    --ddrfw7 ${FIPDIR}/diag_lpddr4.fw \
                    --ddrfw8 ${FIPDIR}/aml_ddr.fw \
                    --ddrfw9 ${FIPDIR}/lpddr3_1d.fw \
                    --level v3
    else
            ${FIPDIR}/aml_encrypt_g12b --bootmk \
                    --output ${DESTDIR}/u-boot.bin \
                    --bl2 ${DESTDIR}/bl2.n.bin.sig \
                    --bl30 ${DESTDIR}/bl30_new.bin.enc \
                    --bl31 ${DESTDIR}/bl31.img.enc \
                    --bl33 ${DESTDIR}/bl33.bin.enc \
                    --ddrfw1 ${FIPDIR}/ddr4_1d.fw \
                    --ddrfw2 ${FIPDIR}/ddr4_2d.fw \
                    --ddrfw3 ${FIPDIR}/ddr3_1d.fw \
                    --ddrfw4 ${FIPDIR}/piei.fw \
                    --ddrfw5 ${FIPDIR}/lpddr4_1d.fw \
                    --ddrfw6 ${FIPDIR}/lpddr4_2d.fw \
                    --ddrfw7 ${FIPDIR}/diag_lpddr4.fw \
                    --ddrfw8 ${FIPDIR}/aml_ddr.fw \
                    --level v3
    fi

    # SDCard
    install ${DESTDIR}/u-boot.bin.sd.bin ${DEPLOYDIR}/u-boot.bin.sd.bin
    # eMMC
    install ${DESTDIR}/u-boot.bin ${DEPLOYDIR}/u-boot.bin
    # USB
    install ${DESTDIR}/u-boot.bin.usb.bl2 ${DEPLOYDIR}/u-boot.bin.usb.bl2
    install ${DESTDIR}/u-boot.bin.usb.tpl ${DEPLOYDIR}/u-boot.bin.usb.tpl
}

DEPLOY_COMMAND_meson-axg = "deploy_axg"
DEPLOY_COMMAND_meson-g12a = "deploy_g12a"
DEPLOY_COMMAND_meson-sm1 = "deploy_g12a"
DEPLOY_COMMAND_meson-g12b = "deploy_g12b"
DEPLOY_COMMAND_meson-gxl = "deploy_gxl"
DEPLOY_COMMAND_meson-gxbb = "deploy_gxbb"
DEPLOY_COMMAND_hardkernel-odroidc2 = "deploy_odroidc2"

do_deploy_append_meson-gx () {
	${DEPLOY_COMMAND}
}
