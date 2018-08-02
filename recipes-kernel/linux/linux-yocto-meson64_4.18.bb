#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "acb1872577b346bd15ab3a3f8dff780d6cca4b70"
LINUX_VERSION = "4.18-rc7"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;branch=master;name=meson \
           file://defconfig \
           file://0001-ARM64-dts-meson-gxbb-nanopi-k2-Add-HDMI-CEC-and-CVBS.patch \
           file://0002-drm-meson-Make-DMT-timings-parameters-and-pixel-cloc.patch \
           file://0003-ARM64-defconfig-enable-CEC-support.patch \
           file://0004-clk-meson-switch-gxbb-cts-amclk-div-to-the-generic-d.patch \
           file://0005-clk-meson-remove-unused-clk-audio-divider-driver.patch \
           file://0006-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0007-ASoC-meson-add-register-definitions.patch \
           file://0008-ASoC-meson-add-aiu-i2s-dma-support.patch \
           file://0009-ASoC-meson-add-initial-i2s-dai-support.patch \
           file://0010-ASoC-meson-add-aiu-spdif-dma-support.patch \
           file://0011-ASoC-meson-add-initial-spdif-dai-support.patch \
           file://0012-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0013-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0014-snd-meson-activate-HDMI-audio-path.patch \
           file://0015-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0016-ARM64-dts-meson-gx-add-sound-dai-cells-to-HDMI-node.patch \
           file://0017-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0018-drm-bridge-dw-hdmi-Use-AUTO-CTS-setup-mode-when-non-.patch \
           file://0019-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
           file://0020-media-platform-meson-ao-cec-make-busy-TX-warning-sil.patch \
           file://0021-soc-amlogic-add-meson-canvas-driver.patch \
           file://0022-dt-bindings-soc-amlogic-add-meson-canvas-documentati.patch \
           file://0023-ARM64-dts-meson-gx-add-dmcbus-and-canvas-nodes.patch \
           file://0024-drm-meson-convert-to-the-new-canvas-module.patch \
           file://0025-WIP-drm-meson-Support-Overlay-plane-for-video-render.patch \
           file://0026-media-meson-add-v4l2-m2m-video-decoder-driver.patch \
           file://0027-ARM64-dts-meson-gx-add-vdec-entry.patch \
           file://0001-libretech-cc-disable-CVBS-connector.patch \
           file://0001-ARM64-dts-meson-add-vdec-entries.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

