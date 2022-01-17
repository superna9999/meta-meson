FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://axg-sound-card.conf \
            file://gx-sound-card.conf \
"

do_install:append() {
    install -D -t ${D}/${datadir}/alsa/cards \
                  ${WORKDIR}/axg-sound-card.conf \
                  ${WORKDIR}/gx-sound-card.conf
}
