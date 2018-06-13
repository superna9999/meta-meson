#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "d0c077266ecbe4ebbaac24c0fe5bd81c5304c5a2"
LINUX_VERSION = "4.17.1"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.17.y;name=meson \
           file://0001-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
           file://0002-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0003-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0004-ASoC-meson-add-register-definitions.patch \
           file://0005-ASoC-meson-add-aiu-i2s-dma-support.patch \
           file://0006-ASoC-meson-add-initial-i2s-dai-support.patch \
           file://0007-snd-meson-activate-HDMI-audio-path.patch \
           file://0008-ARM64-defconfig-add-CONFIG_MESON_EFUSE.patch \
           file://0009-ARM64-defconfig-enable-CEC-support.patch \
           file://0010-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0011-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0012-ARM64-dts-meson-gxl-add-sound-dai-cells-to-HDMI-node.patch \
           file://0013-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0014-clk-meson-audio-divider-fix-divider.patch \
           file://defconfig \
           file://0001-libretech-cc-disable-CVBS-connector.patch \
           file://0002-soc-meson-add-power-controller-for-vdec.patch \
           file://0003-media-meson-add-V4L2-M2M-video-decoder.patch \
           file://0004-ARM-dts-meson8b-add-video-decoder-pwrc-entry.patch \
           file://0005-Add-the-H.264-vdec-firmware.patch \
           file://0006-media-meson-vdec-Many-fixes-stability-updates.patch \
           file://0007-media-meson-vdec-Change-capture-pixfmt-to-V4L2_PIX_F.patch \
           file://0008-media-meson-vdec-Many-fixes-stability-updates-2.patch \
           file://0009-media-meson-vdec-Map-vb2-buffers-to-the-canvases-mor.patch \
           file://0010-media-meson-vdec-the-H.264-vdec-is-now-usable-on-s80.patch \
           file://0011-meson-gxl-add-vdec-support.patch \
           file://0012-meson-vdec-several-fixups-for-gstreamer-compat.patch \
           file://0013-meson-vdec-Rewrite-design.patch \
           file://0014-meson-vdec-Add-forgotten-H.264-ref-MV-alloc.patch \
           file://0015-meson-gxl-vdec-Bump-VDEC_1-clock-to-648MHz.patch \
           file://0016-meson-vdec-Actually-output-NV12M.patch \
           file://0017-meson-vdec-Fix-multiple-DMA-leaks.patch \
           file://0018-meson-vdec-Initial-HEVC-WIP.-Fully-broken.patch \
           file://0019-meson-vdec-add-MPEG-1-2-support.patch \
           file://0020-meson-vdec-h264-remove-post-canvas.patch \
           file://0021-meson-vdec-esparser-Fix-VIFIFO-end-bound.patch \
           file://0022-meson-vdec-h264-Fix-SEI-data-handling.patch \
           file://0023-dts-Actually-set-VDEC_1-clock-to-666MHz.patch \
           file://0024-mseon-vdec-Minor-improvements-to-HEVC.patch \
           file://0025-meson-vdec-Add-MPEG4-2-H.263-support.patch \
           file://0026-Remove-duplicate-HEVC-V4L2-pixfmt.patch \
           file://0027-meson-vdec-Rework-the-input-output-logic.patch \
           file://0028-meson-vdec-esparser-Don-t-stall-on-input.patch \
           file://0029-meson-vdec-Limit-input-buffers-to-17.patch \
           file://0030-meson-vdec-hevc-Fetch-and-process-RPM.patch \
           file://0031-meson-vdec-h264-Increase-the-minimum-amount-of-buffe.patch \
           file://0032-dts-meson-gxbb-add-vdec-entries.patch \
           file://0033-meson-vdec-fix-crash-on-module-remove.patch \
           file://0034-Fix-clocks-following-rebase.patch \
           file://0035-meson-vdec-hevc-push-current-progress.patch \
           file://0036-meson-vdec-hevc-Fix-a-really-really-dumb-mistake.patch \
           file://0037-meson-vdec-per-soc-compatible-list.patch \
           file://0038-meson-vdec-hevc-First-working-initial-support.patch \
           file://0039-meson-vdec-hevc-update-to-the-latest-firmware.patch \
           file://0040-meson-vdec-hevc-enable-mcrcc.patch \
           file://0041-meson-vdec-General-updates.patch \
           file://0042-meson-vdec-HEVC-General-updates.patch \
           file://0043-meson-vdec-Cleanup-buffers-when-start_streaming-fail.patch \
           file://0044-meson-vdec-hevc-Fix-crash-when-no-output-buffers-are.patch \
           file://0001-meson-vdec-MJPEG-EOS-signaling.patch \
           file://0002-meson-vdec-add-mjpeg-firmware-should-be-in-meson-gx-.patch \
           file://0003-meson-vdec-handle-DOS-clock-gate.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

require linux-meson.inc
