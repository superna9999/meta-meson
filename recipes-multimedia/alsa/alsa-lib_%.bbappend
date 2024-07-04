FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://axg-sound-card.conf \
            file://gx-sound-card.conf \
"

do_install:append() {
    install -D -t ${D}/${datadir}/alsa/cards \
                  ${UNPACKDIR}/axg-sound-card.conf \
                  ${UNPACKDIR}/gx-sound-card.conf
}
