#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.13.y;name=meson"

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
	    file://0010-dt-bindings-clock-gxbb-expose-audin-clock-gate.patch \
	    file://0011-ASoC-meson-add-meson-audio-core-driver.patch \
	    file://0012-ASoC-meson-add-register-definitions.patch \
	    file://0013-ASoC-meson-add-aiu-i2s-dma-support.patch \
	    file://0014-ASoC-meson-add-initial-i2s-dai-support.patch \
	    file://0015-ASoC-meson-add-aiu-spdif-dma-support.patch \
	    file://0016-ASoC-meson-add-initial-spdif-dai-support.patch \
	    file://0017-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
	    file://0018-ARM64-defconfig-enable-CONFIG_SND_SOC_ES7134-as-modu.patch \
	    file://0019-ARM64-defconfig-enable-CONFIG_SND_SOC_DIO2125-as-mod.patch \
	    file://0020-ARM64-defconfig-enable-CONFIG_SND_SOC_SPDIF-as-modul.patch \
	    file://0021-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
	    file://0022-ARM64-dts-meson-gxbb-p20x-add-i2s-codec-node.patch \
	    file://0023-ARM64-dts-meson-gxbb-p20x-add-analog-amplifier-node.patch \
	    file://0024-ARM64-dts-meson-gxbb-p20x-add-spdif-codec-node.patch \
	    file://0025-ARM64-dts-meson-gxbb-p20x-add-i2s-and-spdif-output-i.patch \
	    file://0026-ARM64-dts-meson-gxl-p230-add-spdif-codec-node.patch \
	    file://0027-ARM64-dts-meson-gxl-p230-add-spdif-output-interface.patch \
	    file://0028-WIP-ARM64-dts-meson-gxbb-p20x-add-sound-card-support.patch \
	    file://0029-WIP-ARM64-dts-meson-gxl-p230-add-sound-card-support.patch \
	    file://0030-clk-take-the-prepare-lock-out-of-clk_core_set_parent.patch \
	    file://0031-clk-add-clk_core_set_phase_nolock-function.patch \
	    file://0032-clk-rework-calls-to-round-and-determine-rate-callbac.patch \
	    file://0033-clk-use-round-rate-to-bail-out-early-in-set_rate.patch \
	    file://0034-clk-add-support-for-clock-protection.patch \
	    file://0035-clk-add-clk_set_rate_protect.patch \
	    file://0036-clk-rollback-set_rate_range-changes-on-failure.patch \
	    file://0037-clk-cosmetic-changes-to-clk_summary-debugfs-entry.patch \
	    file://0038-clk-fix-incorrect-usage-of-ENOSYS.patch \
	    file://0039-clk-fix-CLK_SET_RATE_GATE-with-clock-rate-protection.patch \
	    file://0040-ASoC-meson-protect-dai-output-clock-rates.patch \
	    file://0041-snd-meson-add-hdmi-control-bits.patch \
	    file://0042-snd-meson-activate-HDMI-audio-path.patch \
	    file://0043-ARM64-dts-meson-gx-Switch-p20x-and-p230-to-HDMI-outp.patch \
	    file://0044-ARM64-dts-meson-gxbb-odroic2-Add-HDMI-audio-output-n.patch \
	    file://0045-ARM64-dts-meson-add-sound-dai-cells-to-HDMI-node.patch \
	    file://0046-Add-CEC-support-for-Odroid-C2.patch \
	    file://0047-ARM64-dts-meson-gx-Add-CEC-support-for-Wetek-Play2-a.patch \
	    file://0048-ARM64-dts-meson-gxbb-allow-child-devices-on-the-USB-.patch \
	    file://0049-ARM64-dts-meson-gxbb-odroidc2-take-USB-hub-out-of-re.patch \
	    file://0050-ARM64-dts-meson-gxl-add-USB-host-support.patch \
	    file://0051-ARM64-dts-meson-gxm-add-GXM-specific-USB-host-config.patch \
	    file://0052-usb-host-add-a-generic-platform-USB-roothub-driver.patch \
	    file://0053-usb-host-xhci-plat-integrate-the-platform-roothub.patch \
	    file://0054-ARM64-dts-meson-gx-Enable-USB-on-GXL-and-GXM-boards.patch \
	    file://0055-ARM64-dts-meson-gxl-Enable-HDMI-audio-on-p212-based-.patch \
	    file://0056-ARM64-dts-meson-gx-Add-SoC-info-register.patch \
	    file://0057-ARM64-dts-meson-gxl-khadas-vim-Add-GPIO-lines-names.patch \
	    file://0058-ARM64-dts-meson-gxbb-nanopi-k2-Add-GPIO-lines-names.patch \
	    file://0059-ARM64-dts-meson-gx-use-stable-UART-bindings-with-cor.patch \
	    file://0060-ARM64-dts-meson-gxl-libretech-cc-Add-GPIO-lines-name.patch \
            file://0061-phy-meson-add-USB3-PHY-support-for-Meson-GXL.patch \
            file://0062-ARM64-dts-meson-gxl-Add-USB3-PHY-Node.patch \
            file://0063-ARM64-dts-meson-gxl-libretech-cc-enable-saradc.patch \
            file://0064-ARM64-dts-meson-gxl-libretech-cc-enable-internal-phy.patch \
            file://0065-ARM64-dts-meson-gxl-s905x-libretech-cc-Enable-USB.patch \
            file://0066-ARM64-dts-meson-activate-hdmi-audio-on-libretech.patch \
            file://0067-ARM64-dts-meson-gx-Add-AO-CEC-nodes-for-libretech-cc.patch \
"

LINUX_VERSION ?= "4.13"

KERNEL_VERSION_SANITY_SKIP="1"

# tag: v4.13
SRCREV_meson="569dbb88e80deb68974ef6fdd6a13edb9d686261"

KERNEL_CLASSES = "kernel-uimage-meson64"

LINUX_VERSION_EXTENSION_append = "-meson64"
KBUILD_DEFCONFIG = "defconfig"

require linux-yocto-meson.inc
