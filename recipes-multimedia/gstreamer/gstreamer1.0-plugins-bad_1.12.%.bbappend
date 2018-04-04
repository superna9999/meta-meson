FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-kmssink-hack-Skip-VSYNC-for-synchronous-set_plane.patch"

PACKAGECONFIG_append_meson-gx = " kms"
