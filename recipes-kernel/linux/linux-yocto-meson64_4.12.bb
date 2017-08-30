#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.12.y;name=meson"

SRC_URI += "file://defconfig \
        file://0001-Add-HDMI-support-for-Odroid-C2.patch \
        file://0002-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
        file://0003-drm-bridge-dw-hdmi-Use-AUTO-CTS-setup-mode-when-non-.patch \
        file://0004-dt-bindings-clock-gxbb-aoclk-Add-CEC-32k-clock.patch \
        file://0005-clk-meson-gxbb-aoclk-Add-CEC-32k-clock.patch \
        file://0006-ARM64-dts-meson-gx-Add-PWR-and-CRT-RTC-nodes-and-adr.patch \
        file://0007-ARM64-dts-meson-gx-Add-AO-CEC-nodes.patch \
        file://0008-drm-bridge-dw_hdmi-add-cec-notifier-support.patch \
        file://0009-platform-Add-Amlogic-Meson-AO-CEC-Controller-driver.patch \
        file://0010-ARM64-dts-meson-gxbb-Add-CEC-pins-nodes.patch \
        file://0011-ARM64-dts-meson-gxl-Add-CEC-pins-nodes.patch \
        file://0012-ARM64-dts-meson-gxl-Add-Ethernet-PHY-LEDS-pins-nodes.patch \
        file://0013-ARM64-dts-meson-gxbb-Add-SPI-pinctrl-nodes.patch \
        file://0014-ARM64-dts-meson-gxl-Add-SPI-pinctrl-nodes.patch \
        file://0015-pinctrl-meson-gxl-Fix-typo-in-AO-I2S-pins.patch \
        file://0016-pinctrl-meson-gxl-Fix-typo-in-AO-SPDIF-pins.patch \
        file://0017-pinctrl-meson-gxbb-Add-CEC-pins.patch \
        file://0018-pinctrl-meson-gxl-Add-CEC-pins.patch \
        file://0019-pinctrl-meson-gxl-Add-Ethernet-PHY-LEDS-pins.patch \
        file://0022-cec-add-cec_s_phys_addr_from_edid-helper-function.patch \
        file://0023-cec-add-cec_phys_addr_invalidate-helper-function.patch \
        file://0024-cec-add-cec_transmit_attempt_done-helper-function.patch \
        file://0025-cec-add-CEC_CAP_NEEDS_HPD.patch \
        file://0026-dt-bindings-clock-gxbb-expose-audin-clock-gate.patch \
        file://0027-ASoC-meson-add-meson-audio-core-driver.patch \
        file://0028-ASoC-meson-add-register-definitions.patch \
        file://0029-ASoC-meson-add-aiu-i2s-dma-support.patch \
        file://0030-ASoC-meson-add-initial-i2s-dai-support.patch \
        file://0031-ASoC-meson-add-aiu-spdif-dma-support.patch \
        file://0032-ASoC-meson-add-initial-spdif-dai-support.patch \
        file://0033-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
        file://0034-ARM64-defconfig-enable-CONFIG_SND_SOC_ES7134-as-modu.patch \
        file://0035-ARM64-defconfig-enable-CONFIG_SND_SOC_DIO2125-as-mod.patch \
        file://0036-ARM64-defconfig-enable-CONFIG_SND_SOC_SPDIF-as-modul.patch \
        file://0037-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
        file://0038-ARM64-dts-meson-gxbb-p20x-add-i2s-codec-node.patch \
        file://0039-ARM64-dts-meson-gxbb-p20x-add-analog-amplifier-node.patch \
        file://0040-ARM64-dts-meson-gxbb-p20x-add-spdif-codec-node.patch \
        file://0041-ARM64-dts-meson-gxbb-p20x-add-i2s-and-spdif-output-i.patch \
        file://0042-ARM64-dts-meson-gxl-p230-add-spdif-codec-node.patch \
        file://0043-ARM64-dts-meson-gxl-p230-add-spdif-output-interface.patch \
        file://0044-WIP-ARM64-dts-meson-gxbb-p20x-add-sound-card-support.patch \
        file://0045-WIP-ARM64-dts-meson-gxl-p230-add-sound-card-support.patch \
        file://0046-clk-take-the-prepare-lock-out-of-clk_core_set_parent.patch \
        file://0047-clk-add-clk_core_set_phase_nolock-function.patch \
        file://0048-clk-rework-calls-to-round-and-determine-rate-callbac.patch \
        file://0049-clk-use-round-rate-to-bail-out-early-in-set_rate.patch \
        file://0050-clk-add-support-for-clock-protection.patch \
        file://0051-clk-add-clk_set_rate_protect.patch \
        file://0052-clk-rollback-set_rate_range-changes-on-failure.patch \
        file://0053-clk-cosmetic-changes-to-clk_summary-debugfs-entry.patch \
        file://0054-clk-fix-incorrect-usage-of-ENOSYS.patch \
        file://0055-clk-fix-CLK_SET_RATE_GATE-with-clock-rate-protection.patch \
        file://0056-ASoC-meson-protect-dai-output-clock-rates.patch \
        file://0057-snd-meson-add-hdmi-control-bits.patch \
        file://0058-snd-meson-activate-HDMI-audio-path.patch \
        file://0059-ARM64-dts-meson-gx-Switch-p20x-and-p230-to-HDMI-outp.patch \
        file://0060-ARM64-dts-meson-gxbb-odroic2-Add-HDMI-audio-output-n.patch \
        file://0061-ARM64-dts-meson-add-sound-dai-cells-to-HDMI-node.patch \
        file://0062-clk-meson-gxbb-expose-spdif-clock-gates.patch \
        file://0063-clk-meson-gxbb-expose-i2s-master-clock.patch \
        file://0064-clk-meson-gxbb-expose-spdif-master-clock.patch \
        file://0065-Add-CEC-support-for-Odroid-C2.patch \
        file://0066-ARM64-dts-meson-gxbb-wetek-play2-Add-HDMI-and-CVBS-N.patch \
        file://0067-ARM64-dts-meson-gxl-s905d-p230-Add-HDMI-nodes.patch \
        file://0068-ARM64-dts-meson-gxl-s905x-khadas-vim-Add-HDMI-nodes.patch \
        file://0069-ARM64-dts-meson-gxl-s905x-p212-Add-HDMI-and-CVBS-nod.patch \
        file://0070-ARM64-dts-meson-gx-Add-CEC-support-for-Wetek-Play2-a.patch \
        file://0071-ARM64-dts-meson-gxbb-allow-child-devices-on-the-USB-.patch \
        file://0072-ARM64-dts-meson-gxbb-odroidc2-take-USB-hub-out-of-re.patch \
        file://0073-ARM64-dts-meson-gxl-add-USB-host-support.patch \
        file://0074-ARM64-dts-meson-gxm-add-GXM-specific-USB-host-config.patch \
        file://0075-usb-host-add-a-generic-platform-USB-roothub-driver.patch \
        file://0076-usb-host-xhci-plat-integrate-the-platform-roothub.patch \
        file://0077-ARM64-dts-meson-gx-Enable-USB-on-GXL-and-GXM-boards.patch \
        file://0078-ARM64-dts-meson-gxl-Enable-HDMI-audio-on-p212-based-.patch \
        file://0079-phy-meson-add-USB2-PHY-support-for-Meson-GXL-and-GXM.patch \
"

LINUX_VERSION ?= "4.12"

KERNEL_VERSION_SANITY_SKIP="1"

# tag: v4.12
SRCREV_meson="6f7da290413ba713f0cdd9ff1a2a9bb129ef4f6c"

KERNEL_CLASSES = "kernel-uimage-meson64"

LINUX_VERSION_EXTENSION_append = "-meson64"
KBUILD_DEFCONFIG = "defconfig"

require linux-yocto-meson.inc
