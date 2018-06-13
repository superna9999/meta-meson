#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# tag: v4.14.30
SRCREV_meson="de8cdc5572311b0742eccf3c0cfd34af1e105904"
LINUX_VERSION ?= "4.14.30"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=https;branch=linux-4.14.y;name=meson \
           file://0001-ARM64-dts-meson-gxm-Add-support-for-Khadas-VIM2.patch \
           file://0002-ARM64-dts-meson-gxbb-allow-child-devices-on-the-USB-.patch \
           file://0003-ARM64-dts-meson-gxbb-odroidc2-take-USB-hub-out-of-re.patch \
           file://0004-phy-meson-add-USB3-PHY-support-for-Meson-GXL.patch \
           file://0005-usb-host-add-a-generic-platform-USB-roothub-driver.patch \
           file://0006-usb-host-xhci-plat-integrate-the-platform-roothub.patch \
           file://0007-ARM64-dts-meson-gxl-add-USB-host-support.patch \
           file://0008-ARM64-dts-meson-gxm-add-GXM-specific-USB-host-config.patch \
           file://0009-ARM64-dts-meson-gx-Enable-USB-on-GXL-and-GXM-boards.patch \
           file://0010-ARM64-defconfig-add-CONFIG_MESON_EFUSE.patch \
           file://0011-ARM64-defconfig-enable-CEC-support.patch \
           file://0012-ARM64-defconfig-enable-CONFIG_VIDEO_MESON_AO_CEC.patch \
           file://0013-ARM64-defconfig-enable-CONFIG_DRM_DW_HDMI_CEC.patch \
           file://0014-clk-meson-gxbb-Add-VPU-and-VAPB-clockids.patch \
           file://0015-clk-meson-gxbb-Add-VPU-and-VAPB-clocks-data.patch \
           file://0016-drm-meson-dw_hdmi-Add-support-for-an-optional-extern.patch \
           file://0017-drm-meson-Add-missing-VPU-init.patch \
           file://0018-reset-meson-add-level-reset-support-for-GX-SoC-famil.patch \
           file://0019-soc-amlogic-add-Meson-GX-VPU-Domains-driver.patch \
           file://0020-soc-amlogic-meson-gx-pwrc-vpu-fix-power-off-when-pow.patch \
           file://0021-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0022-ASoC-meson-add-register-definitions.patch \
           file://0023-ASoC-meson-add-aiu-i2s-dma-support.patch \
           file://0024-ASoC-meson-add-initial-i2s-dai-support.patch \
           file://0025-snd-meson-activate-HDMI-audio-path.patch \
           file://0026-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0027-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0028-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0029-ARM64-dts-meson-gxl-add-sound-dai-cells-to-HDMI-node.patch \
           file://0030-ARM64-dts-meson-gxl-Take-eMMC-data-strobe-out-of-eMM.patch \
           file://0031-ARM64-dts-meson-gx-add-VPU-power-domain.patch \
           file://0032-ARM64-dts-meson-gx-Add-HDMI_5V-regulator-on-selected.patch \
           file://0033-ARM64-dts-meson-gx-grow-reset-controller-memory-zone.patch \
           file://0034-ARM64-dts-odroid-c2-Add-HDMI-and-CEC-Nodes.patch \
           file://0035-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0036-net-phy-meson-gxl-detect-LPA-corruption.patch \
	   file://0037-drm-meson-fix-vsync-buffer-update.patch \
	   file://0038-ARM64-dts-meson-bump-mali450-clk-to-744MHz.patch \
	   file://0039-drm-meson-Add-support-for-DMT-modes-on-HDMI.patch \
           file://defconfig \
"

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc
