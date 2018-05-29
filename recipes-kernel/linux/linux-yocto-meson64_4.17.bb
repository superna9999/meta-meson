#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson="786b71f5b754273ccef6d9462e52062b3e1f9877"
LINUX_VERSION ?= "4.17"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;name=meson \
           file://0001-WIP-Overlay.patch \
           file://0002-WIP-fixups.patch \
           file://0003-More-fixes.patch \
           file://0004-meson-overlay-deal-with-drm_atomic_helper_check_plan.patch \
           file://0005-libretech-cc-disable-CVBS-connector.patch \
           file://0006-ARM64-dts-meson-gxbb-add-sound-dai-cells-to-HDMI-nod.patch \
           file://0007-ASoC-hdmi-codec-fix-channel-allocation.patch \
           file://0008-drm-dw-hdmi-i2s-add-.get_eld-callback-for-ALSA-SoC.patch \
           file://0009-drm-dw-hdmi-i2s-add-multi-channel-lpcm-support.patch \
           file://0010-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
           file://0011-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0012-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0013-ASoC-meson-add-register-definitions.patch \
           file://0014-ASoC-meson-add-aiu-i2s-dma-support.patch \
           file://0015-ASoC-meson-add-initial-i2s-dai-support.patch \
           file://0016-snd-meson-activate-HDMI-audio-path.patch \
           file://0017-ARM64-defconfig-add-CONFIG_MESON_EFUSE.patch \
           file://0018-ARM64-defconfig-enable-CEC-support.patch \
           file://0019-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0020-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0021-ARM64-dts-meson-gxl-add-sound-dai-cells-to-HDMI-node.patch \
           file://0022-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0023-ath10k-add-inlined-wrappers-for-htt-tx-ops.patch \
           file://0024-ath10k-add-inlined-wrappers-for-htt-rx-ops.patch \
           file://0025-ath10k-add-struct-ath10k_bus_params.patch \
           file://0026-ath10k-high_latency-detection.patch \
           file://0027-ath10k-add-bus-type-check-in-ath10k_init_hw_params.patch \
           file://0028-ath10k-per-target-config-of-max_num_peers.patch \
           file://0029-ath10k-DMA-related-fixes-for-high-latency-devices.patch \
           file://0030-ath10k-various-fixes-for-high-latency-devices.patch \
           file://0031-ath10k-add-start_once-support.patch \
           file://0032-ath10k-add-HTT-TX-HL-ops.patch \
           file://0033-ath10k-add-HTT-RX-HL-ops.patch \
           file://0034-ath10k-htt-RX-ring-config-HL-support.patch \
           file://0035-ath10k-htt-High-latency-TX-support.patch \
           file://0036-ath10k-htt-High-latency-RX-support.patch \
           file://0037-ath10k-wmi-disable-softirq-s-while-calling-ieee80211.patch \
           file://0038-ath10k-remove-htt-pending-TX-count-for-high-latency.patch \
           file://0039-ath10k-add-QCA9377-usb-hw_param-item.patch \
           file://0040-ath10k-add-QCA9377-sdio-hw_param-item.patch \
           file://0041-ath10k_sdio-sdio-htt-data-transfer-fixes.patch \
           file://0042-ath10k_sdio-wb396-reference-card-fix.patch \
           file://0043-ath10k_sdio-DMA-bounce-buffers-for-read-write.patch \
           file://0044-ath10k_sdio-reduce-transmit-msdu-count.patch \
           file://0045-ath10k_sdio-use-clean-packet-headers.patch \
           file://0046-ath10k_sdio-high-latency-fixes-for-beacon-buffer.patch \
           file://0047-ath10k_sdio-fix-rssi-indication.patch \
           file://0048-ath10k_sdio-common-read-write.patch \
           file://0049-ath10k_sdio-virtual-scatter-gather-for-receive.patch \
           file://0050-ath10k_sdio-hif-start-once-addition.patch \
           file://0051-ath10k-sdio-fix-type-mismatch-in-func-prototype.patch \
           file://0052-ath10k-usb-add-sparklan-usb-support.patch \
           file://0053-ARM-dts-add-gpu-node-to-exynos4.patch \
           file://0054-dt-bindings-add-switch-delay-property-for-mali-utgar.patch \
           file://0055-arm64-dts-add-switch-delay-for-meson-mali.patch \
           file://0056-arm64-dts-add-switch-delay-for-meson-mali.patch \
           file://0057-drm-lima-add-lima-uapi-header.patch \
           file://0058-drm-lima-add-mali-4xx-GPU-hardware-regs.patch \
           file://0059-drm-lima-add-lima-core-driver.patch \
           file://0060-drm-lima-add-GPU-device-functions.patch \
           file://0061-drm-lima-add-PMU-related-functions.patch \
           file://0062-drm-lima-add-L2-cache-functions.patch \
           file://0063-drm-lima-add-GP-related-functions.patch \
           file://0064-drm-lima-add-PP-related-functions.patch \
           file://0065-drm-lima-add-MMU-related-functions.patch \
           file://0066-drm-lima-add-BCAST-related-function.patch \
           file://0067-drm-lima-add-DLBU-related-functions.patch \
           file://0068-drm-lima-add-GPU-virtual-memory-space-handing.patch \
           file://0069-drm-lima-add-TTM-subsystem-functions.patch \
           file://0070-drm-lima-add-buffer-object-functions.patch \
           file://0071-drm-lima-add-GEM-related-functions.patch \
           file://0072-drm-lima-add-GEM-Prime-related-functions.patch \
           file://0073-drm-lima-add-GPU-schedule-using-DRM_SCHED.patch \
           file://0074-drm-lima-add-context-related-functions.patch \
           file://0075-drm-lima-add-makefile-and-kconfig.patch \
           file://0076-drm-lima-use-SPDX-identifiers-and-change-copyright.patch \
           file://0077-drm-lima-lima_reg.h-use-BIT.patch \
           file://0078-drm-lima-add-IRQF_SHARED-for-GP-irq.patch \
           file://0079-drm-lima-Kconfig-only-depend-on-ARM-or-ARM64.patch \
           file://0080-drm-lima-add-comments-for-lima_reg.h.patch \
           file://0081-drm-lima-wait-bo-fence-before-bo-close.patch \
           file://0082-drm-lima-refine-lima_gem_sync_bo.patch \
           file://0083-drm-lima-vm-will-be-freed-when-lima_sched_free_job.patch \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc
