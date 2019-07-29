#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "e9a713f77bb26886d7207a8bb6dd2c9c7b8e287c"
LINUX_VERSION = "4.20.3"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-4.20.y;name=meson \
           file://defconfig \
           file://0001-ARM64-defconfig-enable-CEC-support.patch \
           file://0002-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0003-ASoC-meson-add-register-definitions.patch \
           file://0004-ASoC-meson-add-initial-aiu-i2s-support.patch \
           file://0005-ASoC-meson-add-initial-spdif-support.patch \
           file://0006-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0007-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0008-snd-meson-activate-HDMI-audio-path.patch \
           file://0009-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0010-ARM64-dts-meson-gx-add-sound-dai-cells-to-HDMI-node.patch \
           file://0011-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0012-drm-bridge-dw-hdmi-Use-AUTO-CTS-setup-mode-when-non-.patch \
           file://0013-drm-meson-Use-drm_fbdev_generic_setup.patch \
           file://0014-drm-meson-Use-optional-canvas-provider.patch \
           file://0015-arm64-dts-meson-gx-Add-canvas-provider-node-to-the-v.patch \
           file://0016-drm-meson-Support-Overlay-plane-for-video-rendering.patch \
           file://0017-drm-meson-move-OSD-scaler-management-into-plane-atom.patch \
           file://0018-drm-meson-Add-primary-plane-scaling.patch \
           file://0019-drm-meson-Add-HDMI-1.4-4k-modes.patch \
           file://0020-drm-meson-Add-support-for-VIC-alternate-timings.patch \
           file://0021-drm-meson-Fix-an-Alpha-Primary-Plane-bug-on-Meson-GX.patch \
           file://0022-drm-bridge-dw-hdmi-Add-SCDC-and-TMDS-Scrambling-supp.patch \
           file://0023-drm-meson-add-HDMI-div40-TMDS-mode.patch \
           file://0024-drm-meson-add-support-for-HDMI2.0-2160p-modes.patch \
           file://0025-drm-bridge-dw-hdmi-add-support-for-YUV420-output.patch \
           file://0026-drm-bridge-dw-hdmi-support-dynamically-get-input-out.patch \
           file://0027-drm-bridge-dw-hdmi-allow-ycbcr420-modes-for-0x200a.patch \
           file://0028-drm-meson-Add-YUV420-output-support.patch \
           file://0029-drm-meson-Output-in-YUV444-if-sink-supports-it.patch \
           file://0030-drm-meson-Fix-atomic-mode-switching-regression.patch \
           file://0031-arm64-dts-meson-Fix-IRQ-trigger-type-for-macirq.patch \
           file://0032-pinctrl-meson-gxl-remove-invalid-GPIOX-tsin_a-pins.patch \
           file://0033-arm64-dts-meson-gx-Add-hdmi_5v-regulator-as-hdmi-tx-.patch \
           file://0034-arm64-dts-meson-gxl-libretech-cc-fix-GPIO-lines-name.patch \
           file://0035-arm64-dts-meson-gxbb-nanopi-k2-fix-GPIO-lines-names.patch \
           file://0036-arm64-dts-meson-gxbb-odroidc2-fix-GPIO-lines-names.patch \
           file://0037-arm64-dts-meson-gxl-khadas-vim-fix-GPIO-lines-names.patch \
           file://0038-media-meson-add-v4l2-m2m-video-decoder-driver.patch \
           file://0039-MAINTAINERS-Add-meson-video-decoder.patch \
           file://0040-arm64-dts-meson-gx-add-vdec-entry.patch \
           file://0041-arm64-dts-meson-add-vdec-entries.patch \
           file://0042-meson-vdec-introduce-controls-and-V4L2_CID_MIN_BUFFE.patch \
           file://0043-media-videodev2-add-V4L2_FMT_FLAG_NO_SOURCE_CHANGE.patch \
           file://0044-meson-vdec-allow-subscribing-to-V4L2_EVENT_SOURCE_CH.patch \
           file://0045-media-meson-vdec-add-H.264-decoding-support.patch \
           file://0046-media-meson-vdec-add-MPEG4-decoding-support.patch \
           file://0047-media-meson-vdec-add-MJPEG-decoding-support.patch \
           file://0001-arm64-dts-meson-axg-fix-dtc-warning-about-unit-addre.patch \
	   file://0002-arm64-dts-meson-axg-s400-add-cts-rts-to-the-bluetoot.patch \
	   file://0003-arm64-dts-meson-axg-add-secure-monitor.patch \
	   file://0004-arm64-dts-meson-axg-fix-mailbox-address.patch \
	   file://0005-arm64-dts-meson-axg-correct-sram-shared-mem-unit-add.patch \
	   file://0006-arm64-dts-meson-axg-enable-SCPI.patch \
	   file://0007-arm64-dts-meson-s400-add-bcm-bluetooth-device.patch \
	   file://0008-ASoC-meson-axg-toddr-add-support-for-spdifin-backend.patch \
	   file://0009-ASoC-meson-add-axg-spdif-input-DT-binding-documentat.patch \
	   file://0010-ASoC-meson-add-axg-spdif-input.patch \
	   file://0011-mmc-meson-gx-make-sure-the-descriptor-is-stopped-on-.patch \
	   file://0012-mmc-meson-gx-remove-useless-lock.patch \
	   file://0013-mmc-meson-gx-align-default-phase-on-soc-vendor-tree.patch \
	   file://0014-mmc-meson-gx-add-signal-resampling.patch \
	   file://0015-arm64-dts-meson-s400-enable-sdr104-on-sdio.patch \
	   file://0016-arm64-dts-meson-s400-fix-emmc-maximum-rate.patch \
	   file://0017-ASoC-meson-fix-do_div-warning-in-spdifin.patch \
	   file://0018-arm64-defconfig-enable-modules-for-amlogic-s400-soun.patch \
           file://0001-arm64-dts-meson-add-libretech-aml-s805x-ac-board.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

