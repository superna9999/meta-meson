#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.10.y;name=meson"

SRC_URI += "file://defconfig \
            file://0001-ARM64-dts-meson-gxbb-Add-gpio-ranges.patch \
            file://0002-pinctrl-meson-use-gpio-ranges-from-DT.patch \
            file://0003-ARM64-dts-meson-gxbb-Add-USB-Hub-GPIO-hog.patch \
            file://0004-drm-fb-helper-Add-multi-buffer-support-for-cma-fbdev.patch \
            file://0005-drm-fb-helper-implement-ioctl-FBIO_WAITFORVSYNC.patch \
            file://0006-Disable-DRM-fbdev-FBIO_WAITFORVSYNC-to-achieve-full-.patch \
            file://0007-clk-meson-gxbb-Add-MALI-clocks-and-fix-GP0-pll-suppo.patch \
            file://0008-ARM64-dts-meson-gxbb-Add-Mali-node.patch \
            file://0009-ARM64-dts-meson-gxbb-Add-support-for-WeTek-Hub-and-P.patch \
            file://0010-drm-bridge-Link-encoder-and-bridge-in-core-code.patch \
            file://0011-drm-bridge-dw-hdmi-Merge-__hdmi_phy_i2c_write-and-hd.patch \
            file://0012-drm-bridge-dw-hdmi-Remove-unneeded-arguments-to-bind.patch \
            file://0013-drm-bridge-dw-hdmi-Remove-unused-function-parameter.patch \
            file://0014-drm-bridge-dw-hdmi-Embed-drm_bridge-in-struct-dw_hdm.patch \
            file://0015-drm-bridge-dw-hdmi-Remove-encoder-field-from-struct-.patch \
            file://0016-drm-bridge-dw-hdmi-Don-t-forward-HPD-events-to-DRM-c.patch \
            file://0017-drm-bridge-dw-hdmi-Move-IRQ-and-IO-resource-allocati.patch \
            file://0018-drm-bridge-dw-hdmi-Reorder-functions-to-prepare-for-.patch \
            file://0019-drm-bridge-dw-hdmi-Create-connector-in-the-bridge-at.patch \
            file://0020-drm-bridge-dw-hdmi-Implement-DRM-bridge-registration.patch \
            file://0021-drm-bridge-dw-hdmi-Remove-PHY-configuration-resoluti.patch \
            file://0022-drm-bridge-dw-hdmi-Rename-CONF0-SPARECTRL-bit-to-SVS.patch \
            file://0023-drm-bridge-dw-hdmi-Reject-invalid-product-IDs.patch \
            file://0024-drm-bridge-dw-hdmi-Detect-AHB-audio-DMA-using-correc.patch \
            file://0025-drm-bridge-dw-hdmi-Handle-overflow-workaround-based-.patch \
            file://0026-drm-bridge-dw-hdmi-Detect-PHY-type-at-runtime.patch \
            file://0027-drm-bridge-dw-hdmi-Define-and-use-macros-for-PHY-reg.patch \
            file://0028-drm-bridge-dw-hdmi-Fix-the-name-of-the-PHY-reset-mac.patch \
            file://0029-drm-bridge-dw-hdmi-Assert-SVSRET-before-resetting-th.patch \
            file://0030-drm-bridge-dw-hdmi-fix-building-without-CONFIG_OF.patch \
            file://0031-drm-bridge-dw-hdmi-Remove-unused-functions.patch \
            file://0032-drm-bridge-dw-hdmi-Move-CSC-configuration-out-of-PHY.patch \
            file://0033-drm-bridge-dw-hdmi-Enable-CSC-even-for-DVI.patch \
            file://0034-drm-bridge-dw-hdmi-Fix-the-PHY-power-down-sequence.patch \
            file://0035-drm-bridge-dw-hdmi-Fix-the-PHY-power-up-sequence.patch \
            file://0036-drm-bridge-dw-hdmi-Create-PHY-operations.patch \
            file://0037-drm-bridge-dw-hdmi-Add-support-for-custom-PHY-config.patch \
            file://0038-drm-bridge-dw-hdmi-Remove-device-type-from-platform-.patch \
            file://0039-drm-bridge-dw-hdmi-Switch-to-regmap-for-register-acc.patch \
            file://0040-drm-bridge-dw-hdmi-Move-the-driver-to-a-separate-dir.patch \
            file://0041-drm-bridge-dw_hdmi-support-i2c-extended-read-mode.patch \
            file://0042-drm-bridge-dw-hdmi-add-HDMI-vendor-specific-infofram.patch \
            file://0043-drm-bridge-dw-hdmi-Extract-PHY-interrupt-setup-to-a-.patch \
            file://0044-drm-bridge-dw-hdmi-Switch-to-V4L-bus-format-and-enco.patch \
            file://0045-drm-bridge-dw-hdmi-Move-HPD-handling-to-PHY-operatio.patch \
            file://0046-drm-meson-rename-module-name-to-meson-drm.patch \
            file://0047-drm-meson-rename-driver-name-to-meson-drm.patch \
            file://0048-drm-meson-Use-crtc_state-for-hdisplay-and-fix-atomic.patch \
            file://0049-drm-meson-Add-missing-HDMI-register.patch \
            file://0050-drm-meson-Add-support-for-components.patch \
            file://0051-drm-meson-venc_cvbs-no-more-return-ENODEV-if-CVBS-is.patch \
            file://0052-drm-meson-add-support-for-HDMI-clock-support.patch \
            file://0053-drm-meson-Add-support-for-HDMI-venc-modes-and-settin.patch \
            file://0054-drm-meson-Add-support-for-HDMI-encoder-and-DW-HDMI-b.patch \
            file://0055-drm-meson-Convert-existing-documentation-to-actual-k.patch \
            file://0056-media-uapi-Add-RGB-and-YUV-bus-formats-for-Synopsys-.patch \
            file://0057-Add-HDMI-support-for-Odroid-C2.patch \
            file://0058-pinctrl-meson-Add-HDMI-HPD-DDC-pins-functions.patch \
            file://0059-ARM64-dts-meson-gx-Add-HDMI-HPD-DDC-pinctrl-nodes.patch \
            file://0060-clk-meson-gxbb-Export-HDMI-clocks.patch \
            file://0061-ARM64-dts-meson-gx-Add-shared-CMA-dma-memory-pool.patch \
            file://0062-ARM64-dts-meson-gx-Add-support-for-HDMI-output.patch \
            file://0063-clk-gxbb-put-dividers-and-muxes-in-tables.patch \
            file://0064-clk-meson-fix-SET_PARAM-macro.patch \
            file://0065-clk-meson-mpll-add-rw-operation.patch \
            file://0066-clk-meson-gxbb-mpll-use-rw-operation.patch \
            file://0067-clk-gxbb-add-mpll0-enable-support.patch \
            file://0068-clk-meson8b-add-mplls-clocks.patch \
            file://0069-clk-meson-mpll-correct-N2-maximum-value.patch \
            file://0070-clk-meson-add-audio-clock-divider-support.patch \
            file://0071-clk-gxbb-add-cts_amclk.patch \
            file://0072-pinctrl-meson-add-i2s-output-pins.patch \
            file://0073-ARM64-meson-gxbb-add-i2s-output-pins.patch \
            file://0074-snd-meson-add-aiu-register-definitions.patch \
            file://0075-snd-meson-add-audin-register-definitions.patch \
            file://0076-snd-soc-meson-support-for-aiu-i2s-dma.patch \
            file://0077-snd-soc-meson-support-for-aiu-i2s-dai.patch \
            file://0078-snd-soc-codec-add-es7134lv-dac-support.patch \
            file://0079-dt-bindings-clk-gxbb-expose-MPLL0-and-MPLL1-clocks.patch \
            file://0080-dt-bindings-clock-gxbb-expose-i2s-master-clock.patch \
            file://0081-dt-bindings-expose-i2s-dma-and-dai-clock-gates.patch \
            file://0082-ARM64-dts-meson-initial-aiu-support-for-gxbb.patch \
            file://0083-ARM64-dts-meson-gxbb-p200-initial-sound-card-support.patch \
            file://0084-snd-meson-add-hdmi-control-bits.patch \
            file://0085-snd-meson-quick-and-dirty-hdmi-activation.patch \
            file://0086-snd-meson-quick-and-dirty-activation-of-dw-hdmi-code.patch \
            file://0087-ARM64-dts-meson-add-sound-dai-cells.patch \
            file://0088-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
            file://0089-ARM64-config-add-meson-aiu-to-defconfig.patch \
            file://0090-ARM64-dts-meson-move-sound-card-from-p200-to-gxbb.patch \
            file://0091-clk-meson-merge-fixup.patch \
            file://0092-drm-bridge-dw-hdmi-Use-AUTO-CTS-setup-mode-when-non-.patch \
            file://0093-snd-soc-meson-aiu-i2s-Keep-div_lrclk-to-64-only.patch \
"

LINUX_VERSION ?= "4.10.10"

# tag: v4.10.10
SRCREV_meson="e6925852d5b862bac749fab9c8d26491cda99e4e"

KERNEL_CLASSES = "kernel-uimage-meson64"

LINUX_VERSION_EXTENSION_append = "-meson64"
KBUILD_DEFCONFIG = "defconfig"

require linux-yocto-meson.inc
