#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "96db90800c06d3fe3fa08eb6222fe201286bb778"
LINUX_VERSION = "4.19.6"
	
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
           file://0017-soc-amlogic-add-meson-canvas-driver.patch \
           file://0018-ARM64-dts-meson-gx-add-dmcbus-and-canvas-nodes.patch \
           file://0020-drm-meson-Use-optional-canvas-provider.patch \
           file://0021-arm64-dts-meson-gx-Add-canvas-provider-node-to-the-v.patch \
           file://0022-drm-meson-Support-Overlay-plane-for-video-rendering.patch \
           file://0023-drm-meson-move-OSD-scaler-management-into-plane-atom.patch \
           file://0024-drm-meson-Add-primary-plane-scaling.patch \
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
           file://0008-drm-meson-Add-HDMI-1.4-4k-modes.patch \
           file://0009-drm-meson-Use-drm_fbdev_generic_setup.patch \
           file://0010-fixup-drm-meson-Use-optional-canvas-provider.patch \
           file://0012-drm-meson-add-support-for-1080p25-mode.patch \
           file://0014-drm-bridge-dw-hdmi-Add-SCDC-and-TMDS-Scrambling-supp.patch \
           file://0015-drm-meson-add-HDMI-div40-TMDS-mode.patch \
           file://0016-drm-meson-add-support-for-HDMI2.0-2160p-modes.patch \
           file://0017-drm-bridge-dw-hdmi-add-support-for-YUV420-output.patch \
           file://0018-drm-bridge-dw-hdmi-support-dynamically-get-input-out.patch \
           file://0019-drm-bridge-dw-hdmi-allow-ycbcr420-modes-for-0x200a.patch \
           file://0020-drm-meson-Add-YUV420-output-support.patch \
           file://0021-drm-meson-Output-in-YUV444-if-sink-supports-it.patch \
           file://0022-drm-meson-Fixes-for-drm_crtc_vblank_on-off-support.patch \
           file://0023-drm-meson-Fix-an-Alpha-Primary-Plane-bug-on-Meson-GX.patch \
           file://0001-arm64-dts-meson-Fix-IRQ-trigger-type-for-macirq.patch \
           file://0001-drm-meson-fix-max-mode_config-height-width.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

