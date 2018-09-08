#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "3a2c23838bc57431265ff0c3682e826f3315bfa8"
LINUX_VERSION = "4.18.6"
	
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
           file://0025-WIP-drm-meson-Support-Overlay-plane-for-video-render.patch \
           file://0026-media-meson-add-v4l2-m2m-video-decoder-driver.patch \
           file://0027-ARM64-dts-meson-gx-add-vdec-entry.patch \
           file://0001-libretech-cc-disable-CVBS-connector.patch \
           file://0001-ARM64-dts-meson-add-vdec-entries.patch \
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
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

