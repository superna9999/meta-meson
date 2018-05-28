#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "29dcea88779c856c7dc92040a0c01233263101d4"
LINUX_VERSION = "4.17.0"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;name=meson \
           file://0001-WIP-Overlay.patch \
           file://0002-WIP-fixups.patch \
           file://0003-WiP-More-fixes.patch \
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
           file://0001-fix-audio-picked-from-LE-slack.patch \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc
