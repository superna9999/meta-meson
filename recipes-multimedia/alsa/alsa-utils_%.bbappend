FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

OVERRIDES:append = "${@bb.utils.contains("PACKAGECONFIG", "udev", ":udev-enabled", "",d)}"

SRC_URI:append:meson-gx:udev-enabled = " file://soundconfig \
                                         file://90-alsa-restore.rules.in \
                                       "

RRECOMMENDS:alsa-utils-alsactl:append:meson-gx:udev-enabled = " alsa-utils-amixer"

# Udev rules are included in original alsa-utils-alsactl
FILES:alsa-utils-alsactl:append:meson-gx:udev-enabled = " /*/udev/soundconfig \
                                                          /*/*/udev/soundconfig \
                                                        "
do_install:append:meson-gx:udev-enabled() {
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

