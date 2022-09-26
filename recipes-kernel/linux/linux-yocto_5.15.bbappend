FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

SRC_URI:append:meson-gx = " file://0001-drm-bridge-display-connector-implement-bus-fmts-call.patch;minrev=v5.16.62%;maxrev=v5.16.67"
