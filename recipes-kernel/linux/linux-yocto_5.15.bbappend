FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

SRC_URI:append:meson-gx = " file://0001-drm-bridge-display-connector-implement-bus-fmts-call.patch;minrev=v5.16.62%;maxrev=v5.16.67"

SRC_URI:append:meson-g12a = " file://0002-FROMLIST-arm64-dts-amlogic-add-support-for-radxa-zero.patch"
