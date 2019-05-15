LICENSE += "\
    & Firmware-amlogic-vdec \
"

LIC_FILES_CHKSUM_remove = "file://WHENCE;md5=ef36d3383becd18f36ce32d84109386f"
LIC_FILES_CHKSUM += "file://WHENCE;md5=b6e44adf71bc37e5f26ebfe5a08b5490"

LIC_FILES_CHKSUM += "\
    file://LICENSE.amlogic_vdec;md5=dc44f59bf64a81643e500ad3f39a468a \
"

NO_GENERIC_LICENSE[Firmware-amlogic-vdec] = "LICENSE.amlogic_vdec"

SRCREV = "711d3297bac870af42088a467459a0634c1970ca"

PACKAGES =+ "${PN}-amlogic-vdec-license \
             ${PN}-amlogic-vdec \
             "

# For Amlogic VDEC
LICENSE_${PN}-amlogic-vdec         = "Firmware-amlogic-vdec"
LICENSE_${PN}-amlogic-vdec-license = "Firmware-amlogic-vdec"
FILES_${PN}-amlogic-vdec-license   = "${nonarch_base_libdir}/firmware/LICENSE.amlogic_vdec"
FILES_${PN}-amlogic-vdec           = "${nonarch_base_libdir}/firmware/meson/vdec/*"
RDEPENDS_${PN}-amlogic-vdec        = "${PN}-amlogic-vdec-license"
