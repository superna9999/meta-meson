FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

SRC_URI:append:meson-gx = " file://0001-ASoC-meson-implement-driver-name.patch \
			    file://0002-FROMLIST-arm64-dts-amlogic-add-support-for-radxa-zero.patch"
