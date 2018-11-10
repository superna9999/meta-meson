#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "07a03b97b9ce2a6430344386eeab9b16283b893f"
LINUX_VERSION = "4.19.1"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-4.19.y;name=meson \
           file://defconfig \
           file://0001-ARM64-defconfig-enable-CEC-support.patch \
           file://0002-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0003-ASoC-meson-add-register-definitions.patch \
           file://0004-ASoC-meson-add-aiu-i2s-dma-support.patch \
           file://0005-ASoC-meson-add-initial-i2s-dai-support.patch \
           file://0006-ASoC-meson-add-aiu-spdif-dma-support.patch \
           file://0007-ASoC-meson-add-initial-spdif-dai-support.patch \
           file://0008-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0009-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0010-snd-meson-activate-HDMI-audio-path.patch \
           file://0011-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0012-ARM64-dts-meson-gx-add-sound-dai-cells-to-HDMI-node.patch \
           file://0013-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0014-drm-bridge-dw-hdmi-Use-AUTO-CTS-setup-mode-when-non-.patch \
           file://0015-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
           file://0016-dt-bindings-soc-amlogic-add-meson-canvas-documentati.patch \
           file://0017-soc-amlogic-add-meson-canvas-driver.patch \
           file://0018-ARM64-dts-meson-gx-add-dmcbus-and-canvas-nodes.patch \
           file://0019-dt-bindings-display-amlogic-meson-vpu-Add-optional-c.patch \
           file://0020-drm-meson-Use-optional-canvas-provider.patch \
           file://0021-arm64-dts-meson-gx-Add-canvas-provider-node-to-the-v.patch \
           file://0022-drm-meson-Support-Overlay-plane-for-video-rendering.patch \
           file://0023-drm-meson-move-OSD-scaler-management-into-plane-atom.patch \
           file://0024-drm-meson-Add-primary-plane-scaling.patch \
           file://0025-WIP-drm-meson-Add-HDMI-1.4-4k-modes.patch \
           file://0026-pinctrl-meson-gxl-remove-invalid-GPIOX-tsin_a-pins.patch \
           file://0027-arm64-dts-meson-gx-Add-hdmi_5v-regulator-as-hdmi-tx-.patch \
           file://0028-arm64-dts-meson-gxl-libretech-cc-fix-GPIO-lines-name.patch \
           file://0029-arm64-dts-meson-gxbb-nanopi-k2-fix-GPIO-lines-names.patch \
           file://0030-arm64-dts-meson-gxbb-odroidc2-fix-GPIO-lines-names.patch \
           file://0031-arm64-dts-meson-gxl-khadas-vim-fix-GPIO-lines-names.patch \
           file://0032-drm-meson-Add-support-for-VIC-alternate-timings.patch \
           file://0033-media-meson-add-v4l2-m2m-video-decoder-driver.patch \
           file://0034-MAINTAINERS-Add-meson-video-decoder.patch \
           file://0035-arm64-dts-meson-gx-add-vdec-entry.patch \
           file://0036-arm64-dts-meson-add-vdec-entries.patch \
           file://0037-meson-vdec-introduce-controls-and-V4L2_CID_MIN_BUFFE.patch \
           file://0038-media-videodev2-add-V4L2_FMT_FLAG_NO_SOURCE_CHANGE.patch \
           file://0039-meson-vdec-allow-subscribing-to-V4L2_EVENT_SOURCE_CH.patch \
           file://0040-media-meson-vdec-add-H.264-decoding-support.patch \
           file://0041-media-meson-vdec-add-MPEG4-decoding-support.patch \
           file://0042-media-meson-vdec-add-MJPEG-decoding-support.patch \
           file://0043-clk-meson-gxbb-set-fclk_div3-as-CLK_IS_CRITICAL.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

