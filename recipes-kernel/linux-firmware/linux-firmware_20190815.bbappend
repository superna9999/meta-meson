PACKAGES =+ "${PN}-amlogic-vdec-license \
             ${PN}-amlogic-vdec \
             "

# For Amlogic VDEC
LICENSE_${PN}-amlogic-vdec         = "Firmware-amlogic_vdec"
LICENSE_${PN}-amlogic-vdec-license = "Firmware-amlogic_vdec"
FILES_${PN}-amlogic-vdec-license   = "${nonarch_base_libdir}/firmware/LICENSE.amlogic_vdec"
FILES_${PN}-amlogic-vdec           = "${nonarch_base_libdir}/firmware/meson/vdec/*"
RDEPENDS_${PN}-amlogic-vdec        = "${PN}-amlogic-vdec-license"
