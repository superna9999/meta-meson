FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:amlogic-s400 = "file://0001-s400-set-default-sink-source-to-alsa-default.patch"

