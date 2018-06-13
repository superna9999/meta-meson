#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "d0c077266ecbe4ebbaac24c0fe5bd81c5304c5a2"
LINUX_VERSION = "4.17.1"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.17.y;name=meson \
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
           file://0014-clk-meson-audio-divider-fix-divider.patch \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

require linux-meson.inc
