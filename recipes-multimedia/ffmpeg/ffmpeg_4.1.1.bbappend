FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG_append_meson-gx = " libdrm"

PACKAGECONFIG[libdrm] = "--enable-libdrm,--disable-libdrm,libdrm"

SRC_URI += "file://0001-v4l2m2m-add-DRM-prime-buffer-support.patch"

