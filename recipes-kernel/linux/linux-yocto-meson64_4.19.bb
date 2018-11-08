#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "07a03b97b9ce2a6430344386eeab9b16283b893f"
LINUX_VERSION = "4.19.1"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-4.19.y;name=meson \
           file://defconfig \
             \
             file://lima/0001-ARM-dts-add-gpu-node-to-exynos4.patch \
             file://lima/0002-dt-bindings-add-switch-delay-property-for-mali-utgar.patch \
             file://lima/0003-arm64-dts-add-switch-delay-for-meson-mali.patch \
             file://lima/0004-arm64-dts-add-switch-delay-for-meson-mali.patch \
             file://lima/0005-drm-lima-add-lima-uapi-header.patch \
             file://lima/0006-drm-lima-add-mali-4xx-GPU-hardware-regs.patch \
             file://lima/0007-drm-lima-add-lima-core-driver.patch \
             file://lima/0008-drm-lima-add-GPU-device-functions.patch \
             file://lima/0009-drm-lima-add-PMU-related-functions.patch \
             file://lima/0010-drm-lima-add-L2-cache-functions.patch \
             file://lima/0011-drm-lima-add-GP-related-functions.patch \
             file://lima/0012-drm-lima-add-PP-related-functions.patch \
             file://lima/0013-drm-lima-add-MMU-related-functions.patch \
             file://lima/0014-drm-lima-add-BCAST-related-function.patch \
             file://lima/0015-drm-lima-add-DLBU-related-functions.patch \
             file://lima/0016-drm-lima-add-GPU-virtual-memory-space-handing.patch \
             file://lima/0017-drm-lima-add-TTM-subsystem-functions.patch \
             file://lima/0018-drm-lima-add-buffer-object-functions.patch \
             file://lima/0019-drm-lima-add-GEM-related-functions.patch \
             file://lima/0020-drm-lima-add-GEM-Prime-related-functions.patch \
             file://lima/0021-drm-lima-add-GPU-schedule-using-DRM_SCHED.patch \
             file://lima/0022-drm-lima-add-context-related-functions.patch \
             file://lima/0023-drm-lima-add-makefile-and-kconfig.patch \
             file://lima/0024-drm-lima-use-SPDX-identifiers-and-change-copyright.patch \
             file://lima/0025-drm-lima-lima_reg.h-use-BIT.patch \
             file://lima/0026-drm-lima-add-IRQF_SHARED-for-GP-irq.patch \
             file://lima/0027-drm-lima-Kconfig-only-depend-on-ARM-or-ARM64.patch \
             file://lima/0028-drm-lima-add-comments-for-lima_reg.h.patch \
             file://lima/0029-drm-lima-wait-bo-fence-before-bo-close.patch \
             file://lima/0030-drm-lima-refine-lima_gem_sync_bo.patch \
             file://lima/0031-drm-lima-vm-will-be-freed-when-lima_sched_free_job.patch \
             file://lima/0032-drm-lima-vm-alloc-buffer-with-multi-page-table.patch \
             file://lima/0033-drm-lima-clear-vm-page-table-when-alloc.patch \
             file://lima/0034-drm-lima-update-SPDX-header-to-match-kernel-rules.patch \
             file://lima/0035-drm-fourcc-add-ARM-tiled-format-modifier.patch \
             file://lima/0036-drm-lima-add-DRM_LIMA_GEM_MOD-ioctl.patch \
             file://lima/0037-drm-lima-remove-depend-on-ARM-arch.patch \
             file://lima/0038-drm-lima-port-to-4.18-kernel.patch \
             file://lima/0039-drm-lima-user-can-choose-not-to-use-dlbu-on-mali450.patch \
             file://lima/0040-drm-lima-Fix-Lima-to-work-with-drm-scheduler-changes.patch \
             file://lima/0041-drm-lima-Fix-lima-cache-creation.patch \
             file://lima/0001-lima-PR20.patch \
             \
             file://LE/0001-soc-amlogic-add-meson-canvas-driver.patch \
             file://LE/0002-ARM64-dts-meson-gx-add-dmcbus-and-canvas-nodes.patch \
             file://LE/0003-dt-bindings-display-amlogic-meson-vpu-Add-optional-c.patch \
             file://LE/0004-drm-meson-Use-optional-canvas-provider.patch \
             file://LE/0005-arm64-dts-meson-gx-Add-canvas-provider-node-to-the-v.patch \
             file://LE/0006-drm-meson-Support-Overlay-plane-for-video-rendering.patch \
             file://LE/0007-drm-meson-move-OSD-scaler-management-into-plane-atom.patch \
             file://LE/0008-drm-meson-Add-primary-plane-scaling.patch \
             file://LE/0009-drm-meson-Add-support-for-VIC-alternate-timings.patch \
             file://LE/0010-drm-meson-fix-max-height-width.patch \
             file://LE/0011-ARM64-defconfig-enable-CEC-support.patch \
             file://LE/0012-ASoC-meson-add-meson-audio-core-driver.patch \
             file://LE/0013-ASoC-meson-add-register-definitions.patch \
             file://LE/0014-ASoC-meson-add-aiu-i2s-dma-support.patch \
             file://LE/0015-ASoC-meson-add-initial-i2s-dai-support.patch \
             file://LE/0016-ASoC-meson-add-aiu-spdif-dma-support.patch \
             file://LE/0017-ASoC-meson-add-initial-spdif-dai-support.patch \
             file://LE/0018-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
             file://LE/0019-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
             file://LE/0020-snd-meson-activate-HDMI-audio-path.patch \
             file://LE/0021-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
             file://LE/0022-ARM64-dts-meson-gx-add-sound-dai-cells-to-HDMI-node.patch \
             file://LE/0023-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
             file://LE/0024-drm-bridge-dw-hdmi-Use-AUTO-CTS-setup-mode-when-non-.patch \
             file://LE/0025-dt-bindings-media-add-Amlogic-Video-Decoder-Bindings.patch \
             file://LE/0026-media-meson-add-v4l2-m2m-video-decoder-driver.patch \
             file://LE/0027-MAINTAINERS-Add-meson-video-decoder.patch \
             file://LE/0028-arm64-dts-meson-gx-add-vdec-entry.patch \
             file://LE/0029-ARM64-dts-meson-add-vdec-entries.patch \
             file://LE/0030-meson-vdec-introduce-controls-and-V4L2_CID_MIN_BUFFE.patch \
             file://LE/0031-media-videodev2-add-V4L2_FMT_FLAG_NO_SOURCE_CHANGE.patch \
             file://LE/0032-meson-vdec-allow-subscribing-to-V4L2_EVENT_SOURCE_CH.patch \
             file://LE/0033-media-meson-vdec-add-H.264-decoding-support.patch \
             file://LE/0034-media-meson-vdec-add-MPEG4-decoding-support.patch \
             file://LE/0035-media-meson-vdec-add-MJPEG-decoding-support.patch \
             file://LE/0036-media-videodev2.h-Add-Amlogic-compressed-format.patch \
             file://LE/0037-media-meson-vdec-add-support-for-V4L2_PIX_FMT_AM21C.patch \
             file://LE/0038-media-meson-vdec-add-HEVC-decoding-support.patch \
             file://LE/0039-meson-vdec-more-debug-information-on-src-change.patch \
             file://LE/0040-meson-vdec-hevc-fix-conformance-window.patch \
             file://LE/0041-meson-vdec-hevc-simplify-integer-ceiling.patch \
             file://LE/0042-meson-vdec-hevc-various-80-line-fixes.patch \
             file://LE/0043-meson-vdec-hevc-fix-wrong-sao_up-buf-size.patch \
             file://LE/0044-ASoC-hdmi-codec-fix-channel-allocation.patch \
             file://LE/0045-drm-dw-hdmi-i2s-add-.get_eld-callback-for-ALSA-SoC.patch \
             file://LE/0046-drm-dw-hdmi-i2s-add-multi-channel-lpcm-support.patch \
             file://LE/0047-drm-dw-hdmi-call-hdmi_set_cts_n-after-clock-is-enabl.patch \
             file://LE/0048-drm-dw-hdmi-extract-dw_hdmi_connector_update_edid.patch \
             file://LE/0049-drm-dw-hdmi-update-edid-on-hpd-event.patch \
             file://LE/0050-Bluetooth-Fix-spurious-error-message.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

