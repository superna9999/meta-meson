#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "dfba61ec760efc578a3f3702e752b51ca1dfed52"
LINUX_VERSION = "4.18.8"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-4.18.y;name=meson \
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
           file://0026-media-meson-add-v4l2-m2m-video-decoder-driver.patch \
           file://0001-libretech-cc-disable-CVBS-connector.patch \
           file://0006-dt-bindings-media-add-Amlogic-Video-Decoder-Bindings.patch \
           file://0008-MAINTAINERS-Add-meson-video-decoder.patch \
           file://0009-arm64-dts-meson-gx-add-vdec-entry.patch \
           file://0010-arm64-dts-meson-add-vdec-entries.patch \
           file://0011-media-meson-vdec-add-H.264-decoding-support.patch \
           file://0012-media-meson-vdec-add-MPEG4-decoding-support.patch \
           file://0013-media-meson-vdec-add-MJPEG-decoding-support.patch \
           file://0014-media-videodev2.h-Add-Amlogic-compressed-format.patch \
           file://0015-media-meson-vdec-add-HEVC-decoding-support.patch \
           file://0016-decrease-queued-bufs-counter-after-dst_buf_done.patch \
           file://0017-Don-t-remove-first-timestamp-on-unknown-buf-idx.patch \
           file://0018-Fix-YUV420-output-disable-it-for-H.264.patch \
           file://0019-start_streaming-Go-to-bufs_done.patch \
           file://0020-hevc-cleanups.patch \
           file://0021-vdec-override-min_buffers_needed-in-queue_setup.patch \
           file://0022-hevc-slight-cleanups.patch \
           file://0023-Enhance-the-offset-timestamp-matching.patch \
           file://0024-EOS-trigger-it-even-if-there-is-one-src-packet-remai.patch \
           file://0025-Rework-EOS-sequence-codes.patch \
           file://0026-Fix-MPEG4-since-603914c8046.patch \
           file://0027-vdec-move-the-single-session-checks-to-queue_setup-r.patch \
           file://0028-hevc-fix-regression-introduced-in-51414d9.patch \
           file://0029-Revert-vdec-move-the-single-session-checks-to-queue_.patch \
           file://0030-drm-meson-Support-Overlay-plane-for-video-rendering.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

