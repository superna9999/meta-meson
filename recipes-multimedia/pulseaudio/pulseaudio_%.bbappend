FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_amlogic-s400 = "file://0001-s400-set-default-sink-source-to-alsa-default.patch"

