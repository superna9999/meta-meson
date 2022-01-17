FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

OVERRIDES_append = "${@bb.utils.contains("PACKAGECONFIG", "udev", ":udev-enabled", "",d)}"

SRC_URI_append_meson-gx_udev-enabled = " file://soundconfig \
                                         file://90-alsa-restore.rules.in \
                                       "

RRECOMMENDS_alsa-utils-alsactl_append_meson-gx_udev-enabled = " alsa-utils-amixer"

# Udev rules are included in original alsa-utils-alsactl
FILES_alsa-utils-alsactl_append_meson-gx_udev-enabled = " /*/udev/soundconfig \
                                                          /*/*/udev/soundconfig \
                                                        "
do_install_append_meson-gx_udev-enabled() {
    # Default rules file needs to be removed
    rm -fr ${D}/*/udev/rules.d/90-alsa-restore.rules ${D}/*/*/udev/rules.d/90-alsa-restore.rules
    rm -d ${D}/lib/udev/rules.d && rm -d ${D}/lib/udev && rm -d ${D}/lib || :
    UDEV_DIR=`pkg-config --variable=udevdir udev`
    UDEV_RULES_DIR=${UDEV_DIR}/rules.d
    install -d ${D}${UDEV_RULES_DIR}
    install "${WORKDIR}/soundconfig" ${D}${UDEV_DIR}
    install -m 0644 ${WORKDIR}/90-alsa-restore.rules.in ${D}${UDEV_RULES_DIR}/90-alsa-restore.rules.in
    sed -i 's!@@UDEV_DIR@@!'${UDEV_DIR}'!g' ${D}${UDEV_RULES_DIR}/90-alsa-restore.rules.in
    mv ${D}${UDEV_RULES_DIR}/90-alsa-restore.rules.in ${D}${UDEV_RULES_DIR}/90-alsa-restore.rules
}

