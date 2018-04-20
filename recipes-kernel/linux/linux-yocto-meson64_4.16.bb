#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# tag: v4.16.1
SRCREV_meson="11454943b264b548e714d8edf932ebf306e5f808"
LINUX_VERSION ?= "4.16.1"
	
#file://0003-drm-bridge-synopsys-dw-hdmi-Enable-workaround-for-v1.patch

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=https;branch=linux-4.16.y;name=meson \
           file://0001-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
           file://0002-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0003-drm-meson-Add-support-for-DMT-modes-on-HDMI.patch \
           file://0004-drm-bridge-dw-hdmi-Fix-overflow-workaround-for-Amlog.patch \
           file://0005-media-rc-meson-ir-add-timeout-on-idle.patch \
           file://0006-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0007-ASoC-meson-add-register-definitions.patch \
           file://0008-ASoC-meson-add-aiu-i2s-dma-support.patch \
           file://0009-ASoC-meson-add-initial-i2s-dai-support.patch \
           file://0010-snd-meson-activate-HDMI-audio-path.patch \
           file://0011-usb-dwc3-of-simple-add-support-for-shared-and-pulsed.patch \
           file://0012-usb-dwc3-of-simple-add-support-for-the-Amlogic-Meson.patch \
           file://0013-usb-add-a-flag-to-skip-PHY-initialization-to-struct-.patch \
           file://0014-usb-core-add-a-wrapper-for-the-USB-PHYs-on-the-HCD.patch \
           file://0015-usb-core-hcd-integrate-the-PHY-wrapper-into-the-HCD-.patch \
           file://0016-usb-host-xhci-mtk-remove-custom-USB-PHY-handling.patch \
           file://0017-usb-host-ehci-platform-remove-custom-USB-PHY-handlin.patch \
           file://0018-usb-host-ohci-platform-remove-custom-USB-PHY-handlin.patch \
           file://0019-usb-core-hcd-remove-support-for-initializing-a-singl.patch \
           file://0020-phy-amlogic-phy-meson-gxl-usb2-support-the-clock-and.patch \
           file://0021-phy-amlogic-phy-meson-gxl-usb2-default-to-host-mode.patch \
           file://0022-phy-amlogic-phy-meson-gxl-usb2-don-t-log-an-error-on.patch \
           file://0023-phy-amlogic-phy-meson-gxl-usb2-rename-some-of-the-U2.patch \
           file://0024-phy-amlogic-add-USB3-PHY-support-for-Meson-GXL-and-G.patch \
           file://0025-ARM64-defconfig-add-CONFIG_MESON_EFUSE.patch \
           file://0026-ARM64-defconfig-enable-CEC-support.patch \
           file://0027-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0028-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0029-ARM64-dts-meson-gxl-add-sound-dai-cells-to-HDMI-node.patch \
           file://0030-ARM64-dts-meson-gx-Add-HDMI_5V-regulator-on-selected.patch \
           file://0031-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0032-ARM64-dts-meson-bump-mali450-clk-to-744MHz.patch \
           file://0033-ARM64-dts-meson-gxl-add-USB-host-support.patch \
           file://0034-ARM64-dts-meson-gxm-add-GXM-specific-USB-host-config.patch \
           file://0035-ARM64-dts-meson-gxl-s905x-p212-enable-the-USB-contro.patch \
           file://0036-ARM64-dts-meson-gx-p23x-q20x-enable-the-USB-controll.patch \
           file://0037-ARM64-dts-meson-gxl-s905x-libretech-cc-enable-the-US.patch \
           file://0038-ARM64-dts-meson-gxl-nexbox-a95x-enable-the-USB-contr.patch \
           file://0039-ARM64-dts-meson-gxm-khadas-vim2-enable-the-USB-contr.patch \
           file://defconfig \
           file://0001-clk-sunxi-ng-Mask-nkmp-factors-when-setting-register.patch \
           file://0002-clk-sunxi-ng-Use-u64-for-calculation-of-nkmp-rate.patch \
           file://0004-drm-bridge-synopsys-dw-hdmi-Export-some-PHY-related-.patch \
           file://0005-drm-bridge-synopsys-dw-hdmi-don-t-clobber-drvdata.patch \
           file://0006-dt-bindings-display-sun4i-drm-Add-A83T-HDMI-pipeline.patch \
           file://0007-drm-sun4i-Add-has_channel_0-TCON-quirk.patch \
           file://0008-drm-sun4i-Add-support-for-A83T-second-TCON.patch \
           file://0009-drm-sun4i-Add-support-for-A83T-second-DE2-mixer.patch \
           file://0010-drm-sun4i-Implement-A83T-HDMI-driver.patch \
           file://0011-ARM-dts-sun8i-a83t-Add-HDMI-display-pipeline.patch \
           file://0012-ARM-dts-sun8i-a83t-Enable-HDMI-on-BananaPi-M3.patch \
           file://0013-clk-sunxi-ng-Add-check-for-minimal-rate-to-NM-PLLs.patch \
           file://0014-clk-sunxi-ng-h3-h5-Add-minimal-rate-for-video-PLL.patch \
           file://0015-clk-sunxi-ng-h3-h5-Allow-some-clocks-to-set-parent-r.patch \
           file://0016-clk-sunxi-ng-h3-h5-export-CLK_PLL_VIDEO.patch \
           file://0017-dt-bindings-display-sun4i-drm-Add-compatibles-for-H3.patch \
           file://0018-drm-sun4i-Add-support-for-H3-display-engine.patch \
           file://0019-drm-sun4i-Add-support-for-H3-mixer-0.patch \
           file://0020-drm-sun4i-Fix-polarity-configuration-for-DW-HDMI-PHY.patch \
           file://0021-drm-sun4i-Add-support-for-variants-to-DW-HDMI-PHY.patch \
           file://0022-drm-sun4i-Move-and-expand-DW-HDMI-PHY-register-macro.patch \
           file://0023-drm-sun4i-Add-support-for-H3-HDMI-PHY-variant.patch \
           file://0024-drm-sun4i-Allow-building-on-arm64.patch \
           file://0025-ARM-dts-sunxi-h3-h5-Add-HDMI-pipeline.patch \
           file://0026-ARM-dts-sun8i-h3-Enable-HDMI-output-on-H3-boards.patch \
           file://0027-ARM64-dts-sun50i-h5-Enable-HDMI-output-on-H5-boards.patch \
           file://0028-dts-orangepi-enable-net-dev.patch \
           file://0029-drm-lima-init-commit-for-adding-lima-driver.patch \
           file://0030-drm-lima-add-basic-drm-driver.patch \
           file://0031-drm-lima-add-gpu-per-ip-init-fini-framework.patch \
           file://0032-drm-lima-pmu-power-up-all-ip.patch \
           file://0033-drm-lima-init-l2-cache.patch \
           file://0034-drm-lima-add-mmu-init.patch \
           file://0035-drm-lima-add-gem-object-creation.patch \
           file://0036-drm-lima-add-gem-mmap.patch \
           file://0037-drm-lima-add-gem-va-map-unamp.patch \
           file://0038-drm-lima-add-gem-submit.patch \
           file://0039-drm-lima-add-wait-fence-ioctl.patch \
           file://0040-drm-lima-really-start-gp-task.patch \
           file://0041-drm-lima-reference-count-the-vm-struct.patch \
           file://0042-drm-lima-zap-mmu-when-va-unmap.patch \
           file://0043-drm-lima-real-gp-task-finish-dma-fence-signal.patch \
           file://0044-arm-dts-sun8i-h3-add-GPU-mali400-node.patch \
           file://0045-drm-lima-add-l2-cache-flush-function.patch \
           file://0046-drm-lima-implement-pp-task-sumbit.patch \
           file://0047-drm-lima-move-all-PP-core-into-a-single-pipe.patch \
           file://0048-drm-lima-use-wait-queue-instead-of-dma_fence-for-bus.patch \
           file://0049-drm-lima-error-recovery-for-GP-PP-MMU.patch \
           file://0050-drm-lima-add-DRM_LIMA_GEM_WAIT-ioctl.patch \
           file://0051-drm-lima-move-vm-free-to-drm-postclose-callback.patch \
           file://0052-drm-lima-soft-reset-gp-pp-when-task-done.patch \
           file://0053-drm-lima-fix-GP-hang-after-running-for-a-while.patch \
           file://0054-drm-lima-fix-memory-leak-when-release-vm.patch \
           file://0055-drm-lima-use-pd-pt-dma-to-reference-count-page.patch \
           file://0056-drm-lima-mask-reference-count-when-free-page-table.patch \
           file://0057-drm-lima-also-allow-on-ARCH_ROCKCHIP.patch \
           file://0058-drm-lima-rework-init-to-also-work-with-kernels-4.12.patch \
           file://0059-drm-lima-request-pp-and-mmu-irqs-as-shared.patch \
           file://0060-drm-lima-fix-lima_device.c-compile-warning.patch \
           file://0061-drm-lima-rework-init-to-conform-to-the-mainline-Utga.patch \
           file://0062-arm-dts-sun8i-h3-modify-gpu-to-conform-to-mainline-U.patch \
           file://0063-drm-lima-updated-lima_gem_fault-to-new-format.patch \
           file://0064-drm-lima-fix-deprecated-drm_calloc_large-drm_free_la.patch \
           file://0065-drm-lima-add-gp-pp-version-print.patch \
           file://0066-drm-lima-fix-irq-handler-for-shadred-case.patch \
           file://0067-ARM-dts-sun7i-add-mali400-gpu-device-node.patch \
           file://0068-drm-lima-change-ppmmu-dts-name.patch \
           file://0069-lima-add-prime-import-support.patch \
           file://0070-drm-lima-set-bo-cpu_addr-for-imported-bo.patch \
           file://0071-lima-add-prime-export-support.patch \
           file://0072-drm-lima-fix-MMU-page-fault-when-onscreen-kmscube.patch \
           file://0073-drm-lima-remove-print-when-each-task-start.patch \
           file://0074-drm-lima-Set-gpu_type-from-devicetree-match-data.patch \
           file://0075-drm-lima-Add-Mali450-offset-constants.patch \
           file://0076-drm-lima-add-basic-support-for-Mali-450.patch \
           file://0077-lima-handle-Mali450-pmu-correctly.patch \
           file://0078-drm-lima-also-allow-on-ARCH_EXYNOS.patch \
           file://0079-drm-lima-make-reset-control-optional.patch \
           file://0080-ARM-dts-add-gpu-node-to-exynos4.patch \
           file://0081-drm-lima-add-support-for-external-regulator.patch \
           file://0082-drm-lima-also-allow-on-ARCH_MESON.patch \
           file://0083-drm-lima-update-Kconfig-comments-for-Mali-450-suppor.patch \
           file://0084-drm-lima-add-gem_prime_res_obj-callback.patch \
           file://0085-drm-lima-fix-still-active-bo-inside-vm.patch \
           file://0086-drm-lima-remove-interval-tree-kconfig-select.patch \
           file://0087-drm-lima-change-submit-ABI-for-better-compatibility.patch \
           file://0088-drm-lima-use-drm_sched-for-GPU-scheduling.patch \
           file://0089-drm-lima-adjust-sched-pipe-task-function-pointers.patch \
           file://0090-drm-lima-use-module-param-for-some-configurable-args.patch \
           file://0091-drm-lima-refine-error-handling.patch \
           file://0092-drm-lima-deffer-error-handling-into-work-queue.patch \
           file://0093-drm-lima-use-slab-allocator-for-task-and-fence.patch \
           file://0094-drm-lima-guilty-should-be-shared-by-all-context-of-a.patch \
           file://0095-drm-lima-put-frame-into-task-slab-alloc.patch \
           file://0096-drm-lima-add-lima-ctx-object-and-syscall.patch \
           file://0097-drm-lima-add-done-to-submit-ioctrl-output.patch \
           file://0098-drm-lima-support-non-contiguous-buffer.patch \
           file://0099-drm-lima-remove-contiguous-buffer-alloc.patch \
           file://0100-drm-lima-change-to-use-dma_alloc-free_wc.patch \
           file://0101-drm-lima-include-pagemap.h-for-implicit-declared-map.patch \
           file://0102-drm-lima-fix-arm64-arch-compile-warning.patch \
           file://0103-lima-use-rb_root_cached-instead-of-rb_root.patch \
           file://0104-arm-dts-sun8i-h3-set-GPU-clock-frequency.patch \
           file://0105-dt-bindings-add-switch-delay-property-for-mali-utgar.patch \
           file://0106-drm-lima-add-switch-delay-config-for-PMU.patch \
           file://0107-arm64-dts-add-switch-delay-for-meson-mali.patch \
           file://0108-arm-dts-add-vender-string-to-sun8i-h3-mali-gpu.patch \
           file://0109-arm-dts-add-vender-string-to-sun7i-a20-mali-gpu.patch \
           file://0110-arm-dts-add-vender-string-to-exynos4-mali-gpu.patch \
           file://0111-drm-lima-fix-error-job-dma_fence_put-un-init-task-fe.patch \
           file://0112-drm-lima-add-init-dlbu-bcast-code.patch \
           file://0113-drm-lima-add-va-range-info-for-query-interface.patch \
           file://0114-drm-lima-use-dev_err-for-irq-error-message-print.patch \
           file://0115-drm-lima-fix-submit-wait-error-in-arm64.patch \
           file://0001-Disable-CVBS-for-lima-testing.patch \
           file://0001-drm-bridge-synopsys-dw-hdmi-Enable-workaround-for-v1.patch \
           file://0115-arm64-dts-add-switch-delay-for-meson-mali.patch \
           file://0116-drm-lima-don-t-use-GFP_KERNEL-under-spin-lock.patch \
           file://0117-drm-lima-refine-the-HW-init-and-structure.patch \
           file://0118-drm-lima-exclude-access-for-l2-cache.patch \
           file://0119-drm-lima-reserve-dlbu-page-for-mali450.patch \
           file://0120-drm-lima-use-DLBU-and-BCAST-for-mali450.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson64"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc
