FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto-5.15:"

SRC_URI:append:meson-gx = " \
	file://0001-ASoC-meson-implement-driver-name.patch \
	file://0001-HACK-ALSA-Assign-internal-PCM-chmap-ELD-IEC958-kctls.patch \
"
