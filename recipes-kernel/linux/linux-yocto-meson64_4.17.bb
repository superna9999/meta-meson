#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson="b04e217704b7f879c6b91222b066983a44a7a09f"
LINUX_VERSION ?= "4.17"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;name=meson \
           file://0001-WIP-Overlay.patch \
           file://0002-WIP-fixups.patch \
           file://0003-WiP-More-fixes.patch \
           file://0004-meson-overlay-deal-with-drm_atomic_helper_check_plan.patch \
           file://0001-ARM-DTS-libretech-cc-disable-CVBS-connector.patch \
           file://0002-ARM64-dts-meson-gxbb-add-sound-dai-cells-to-HDMI-nod.patch \
           file://0003-ASoC-hdmi-codec-fix-channel-allocation.patch \
           file://0004-drm-dw-hdmi-i2s-add-.get_eld-callback-for-ALSA-SoC.patch \
           file://0005-drm-dw-hdmi-i2s-add-multi-channel-lpcm-support.patch \
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
           file://0014-ath10k-add-inlined-wrappers-for-htt-tx-ops.patch \
           file://0015-ath10k-add-inlined-wrappers-for-htt-rx-ops.patch \
           file://0016-ath10k-add-struct-ath10k_bus_params.patch \
           file://0017-ath10k-high_latency-detection.patch \
           file://0018-ath10k-add-bus-type-check-in-ath10k_init_hw_params.patch \
           file://0019-ath10k-per-target-config-of-max_num_peers.patch \
           file://0020-ath10k-DMA-related-fixes-for-high-latency-devices.patch \
           file://0021-ath10k-various-fixes-for-high-latency-devices.patch \
           file://0022-ath10k-add-start_once-support.patch \
           file://0023-ath10k-add-HTT-TX-HL-ops.patch \
           file://0024-ath10k-add-HTT-RX-HL-ops.patch \
           file://0025-ath10k-htt-RX-ring-config-HL-support.patch \
           file://0026-ath10k-htt-High-latency-TX-support.patch \
           file://0027-ath10k-htt-High-latency-RX-support.patch \
           file://0028-ath10k-wmi-disable-softirq-s-while-calling-ieee80211.patch \
           file://0029-ath10k-remove-htt-pending-TX-count-for-high-latency.patch \
           file://0030-ath10k-add-QCA9377-usb-hw_param-item.patch \
           file://0031-ath10k-add-QCA9377-sdio-hw_param-item.patch \
           file://0032-ath10k_sdio-sdio-htt-data-transfer-fixes.patch \
           file://0033-ath10k_sdio-wb396-reference-card-fix.patch \
           file://0034-ath10k_sdio-DMA-bounce-buffers-for-read-write.patch \
           file://0035-ath10k_sdio-reduce-transmit-msdu-count.patch \
           file://0036-ath10k_sdio-use-clean-packet-headers.patch \
           file://0037-ath10k_sdio-high-latency-fixes-for-beacon-buffer.patch \
           file://0038-ath10k_sdio-fix-rssi-indication.patch \
           file://0039-ath10k_sdio-common-read-write.patch \
           file://0040-ath10k_sdio-virtual-scatter-gather-for-receive.patch \
           file://0041-ath10k_sdio-hif-start-once-addition.patch \
           file://0042-ath10k-sdio-fix-type-mismatch-in-func-prototype.patch \
           file://0043-ath10k-usb-add-sparklan-usb-support.patch \
           file://0044-dts-orangepi-enable-net-dev.patch \
           file://0045-drm-lima-init-commit-for-adding-lima-driver.patch \
           file://0046-drm-lima-add-basic-drm-driver.patch \
           file://0047-drm-lima-add-gpu-per-ip-init-fini-framework.patch \
           file://0048-drm-lima-pmu-power-up-all-ip.patch \
           file://0049-drm-lima-init-l2-cache.patch \
           file://0050-drm-lima-add-mmu-init.patch \
           file://0051-drm-lima-add-gem-object-creation.patch \
           file://0052-drm-lima-add-gem-mmap.patch \
           file://0053-drm-lima-add-gem-va-map-unamp.patch \
           file://0054-drm-lima-add-gem-submit.patch \
           file://0055-drm-lima-add-wait-fence-ioctl.patch \
           file://0056-drm-lima-really-start-gp-task.patch \
           file://0057-drm-lima-reference-count-the-vm-struct.patch \
           file://0058-drm-lima-zap-mmu-when-va-unmap.patch \
           file://0059-drm-lima-real-gp-task-finish-dma-fence-signal.patch \
           file://0060-drm-lima-add-l2-cache-flush-function.patch \
           file://0061-drm-lima-implement-pp-task-sumbit.patch \
           file://0062-drm-lima-move-all-PP-core-into-a-single-pipe.patch \
           file://0063-drm-lima-use-wait-queue-instead-of-dma_fence-for-bus.patch \
           file://0064-drm-lima-error-recovery-for-GP-PP-MMU.patch \
           file://0065-drm-lima-add-DRM_LIMA_GEM_WAIT-ioctl.patch \
           file://0066-drm-lima-move-vm-free-to-drm-postclose-callback.patch \
           file://0067-drm-lima-soft-reset-gp-pp-when-task-done.patch \
           file://0068-drm-lima-fix-GP-hang-after-running-for-a-while.patch \
           file://0069-drm-lima-fix-memory-leak-when-release-vm.patch \
           file://0070-drm-lima-use-pd-pt-dma-to-reference-count-page.patch \
           file://0071-drm-lima-mask-reference-count-when-free-page-table.patch \
           file://0072-drm-lima-also-allow-on-ARCH_ROCKCHIP.patch \
           file://0073-drm-lima-rework-init-to-also-work-with-kernels-4.12.patch \
           file://0074-drm-lima-request-pp-and-mmu-irqs-as-shared.patch \
           file://0075-drm-lima-fix-lima_device.c-compile-warning.patch \
           file://0076-drm-lima-rework-init-to-conform-to-the-mainline-Utga.patch \
           file://0077-drm-lima-updated-lima_gem_fault-to-new-format.patch \
           file://0078-drm-lima-fix-deprecated-drm_calloc_large-drm_free_la.patch \
           file://0079-drm-lima-add-gp-pp-version-print.patch \
           file://0080-drm-lima-fix-irq-handler-for-shadred-case.patch \
           file://0081-drm-lima-change-ppmmu-dts-name.patch \
           file://0082-lima-add-prime-import-support.patch \
           file://0083-drm-lima-set-bo-cpu_addr-for-imported-bo.patch \
           file://0084-lima-add-prime-export-support.patch \
           file://0085-drm-lima-fix-MMU-page-fault-when-onscreen-kmscube.patch \
           file://0086-drm-lima-remove-print-when-each-task-start.patch \
           file://0087-drm-lima-Set-gpu_type-from-devicetree-match-data.patch \
           file://0088-drm-lima-Add-Mali450-offset-constants.patch \
           file://0089-drm-lima-add-basic-support-for-Mali-450.patch \
           file://0090-lima-handle-Mali450-pmu-correctly.patch \
           file://0091-drm-lima-also-allow-on-ARCH_EXYNOS.patch \
           file://0092-drm-lima-make-reset-control-optional.patch \
           file://0093-ARM-dts-add-gpu-node-to-exynos4.patch \
           file://0094-drm-lima-add-support-for-external-regulator.patch \
           file://0095-drm-lima-also-allow-on-ARCH_MESON.patch \
           file://0096-drm-lima-update-Kconfig-comments-for-Mali-450-suppor.patch \
           file://0097-drm-lima-add-gem_prime_res_obj-callback.patch \
           file://0098-drm-lima-fix-still-active-bo-inside-vm.patch \
           file://0099-drm-lima-remove-interval-tree-kconfig-select.patch \
           file://0100-drm-lima-change-submit-ABI-for-better-compatibility.patch \
           file://0101-drm-lima-use-drm_sched-for-GPU-scheduling.patch \
           file://0102-drm-lima-adjust-sched-pipe-task-function-pointers.patch \
           file://0103-drm-lima-use-module-param-for-some-configurable-args.patch \
           file://0104-drm-lima-refine-error-handling.patch \
           file://0105-drm-lima-deffer-error-handling-into-work-queue.patch \
           file://0106-drm-lima-use-slab-allocator-for-task-and-fence.patch \
           file://0107-drm-lima-guilty-should-be-shared-by-all-context-of-a.patch \
           file://0108-drm-lima-put-frame-into-task-slab-alloc.patch \
           file://0109-drm-lima-add-lima-ctx-object-and-syscall.patch \
           file://0110-drm-lima-add-done-to-submit-ioctrl-output.patch \
           file://0111-drm-lima-support-non-contiguous-buffer.patch \
           file://0112-drm-lima-remove-contiguous-buffer-alloc.patch \
           file://0113-drm-lima-change-to-use-dma_alloc-free_wc.patch \
           file://0114-drm-lima-include-pagemap.h-for-implicit-declared-map.patch \
           file://0115-drm-lima-fix-arm64-arch-compile-warning.patch \
           file://0116-lima-use-rb_root_cached-instead-of-rb_root.patch \
           file://0117-dt-bindings-add-switch-delay-property-for-mali-utgar.patch \
           file://0118-drm-lima-add-switch-delay-config-for-PMU.patch \
           file://0119-arm64-dts-add-switch-delay-for-meson-mali.patch \
           file://0120-arm-dts-add-vender-string-to-exynos4-mali-gpu.patch \
           file://0121-drm-lima-fix-error-job-dma_fence_put-un-init-task-fe.patch \
           file://0122-drm-lima-add-init-dlbu-bcast-code.patch \
           file://0123-drm-lima-add-va-range-info-for-query-interface.patch \
           file://0124-drm-lima-use-dev_err-for-irq-error-message-print.patch \
           file://0125-drm-lima-fix-submit-wait-error-in-arm64.patch \
           file://0126-arm64-dts-add-switch-delay-for-meson-mali.patch \
           file://0127-drm-lima-don-t-use-GFP_KERNEL-under-spin-lock.patch \
           file://0128-drm-lima-refine-the-HW-init-and-structure.patch \
           file://0129-drm-lima-exclude-access-for-l2-cache.patch \
           file://0130-drm-lima-reserve-dlbu-page-for-mali450.patch \
           file://0131-drm-lima-use-DLBU-and-BCAST-for-mali450.patch \
           file://0132-drm-lima-use-ttm-for-mm.patch \
           file://0133-drm-lima-use-mutex-for-possible-sleep-case.patch \
           file://0134-drm-lima-remove-reg-definition-from-lima_drm.h.patch \
           file://0092-drm-lima-move-regs-into-a-file-for-different-license.patch \
           file://0093-Revert-drm-Nerf-the-preclose-callback-for-modern-dri.patch \
           file://0094-drm-lima-move-ctx-mgr-fini-to-preclose.patch \
           file://0095-drm-lima-add-submit-dependency.patch \
           file://0096-drm-lima-add-util-function-for-get-native-fence.patch \
           file://0097-drm-lima-handle-fence-seq-overflow-case.patch \
           file://0098-drm-lima-add-lima_gem_get_sync_fd.patch \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc
