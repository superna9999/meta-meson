#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

DEPENDS += "rsync-native"

SRCREV_meson = "cff670b3eb68257029e2977a6bfeac7d9b829e9a"
LINUX_VERSION = "5.4.24"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-5.4.y;name=meson \
           file://defconfig \
           file://0001-FROMLIST-clk-meson-g12a-fix-gp0-and-hifi-ranges.patch \
           file://0002-FROMLIST-dt-bindings-thermal-Add-DT-bindings-documen.patch \
           file://0003-FROMLIST-thermal-amlogic-Add-thermal-driver-to-suppo.patch \
           file://0004-FROMLIST-arm64-dts-amlogic-g12-add-temperature-senso.patch \
           file://0005-FROMLIST-arm64-dts-meson-sei510-Add-minimal-thermal-.patch \
           file://0006-FROMLIST-arm64-dts-amlogic-odroid-n2-add-minimal-the.patch \
           file://0007-FROMLIST-MAINTAINERS-add-entry-for-Amlogic-Thermal-d.patch \
           file://0008-FROMLIST-reset-dt-bindings-meson-update-arb-bindings.patch \
           file://0009-FROMLIST-reset-meson-audio-arb-add-sm1-support.patch \
           file://0010-HACK-arm64-dts-g12a-set-cma-pool-to-896MB.patch \
           file://0011-arm64-dts-meson-gxm-nexbox-a1-disable-cvbs.patch \
           file://0001-UPSTREAM-tty-serial-meson_uart-Add-support-for-kerne.patch \
           file://0002-FROMGIT-drm-meson-dw_hdmi-add-resume-suspend-hooks.patch \
           file://0003-FROMGIT-drm-meson-add-resume-suspend-hooks.patch \
           file://0004-FROMGIT-dt-bindings-clk-axg-audio-add-sm1-bindings.patch \
           file://0005-FROMGIT-dt-bindings-clock-meson-add-sm1-resets-to-th.patch \
           file://0006-BACKPORT-clk-meson-axg-audio-remove-useless-defines.patch \
           file://0007-BACKPORT-clk-meson-axg-audio-prepare-sm1-addition.patch \
           file://0008-BACKPORT-clk-meson-axg-audio-provide-clk-top-signal-.patch \
           file://0009-BACKPORT-clk-meson-axg_audio-add-sm1-support.patch \
           file://0010-FROMGIT-arm64-dts-meson-g12-add-a-g12-layer.patch \
           file://0011-FROMGIT-arm64-dts-meson-g12-factor-the-power-domain.patch \
           file://0012-BACKPORT-arm64-dts-meson-g12-move-audio-bus-out-of-g.patch \
           file://0013-FROMLIST-arm64-dts-meson-g12a-add-audio-devices-rese.patch \
           file://0014-FROMLIST-arm64-dts-meson-sm1-add-audio-devices.patch \
           file://0015-FROMLIST-arm64-dts-meson-sei610-enable-audio.patch \
           file://0016-FROMGIT-arm64-dts-meson-g12a-sei510-add-keep-power-i.patch \
           file://0017-FROMGIT-arm64-dts-meson-sm1-sei610-add-keep-power-in.patch \
           file://0018-FROMLIST-arm64-dts-meson-g12a-specify-suspend-OPP.patch \
           file://0019-FROMLIST-arm64-dts-meson-sm1-specify-suspend-OPP.patch \
           file://0020-BACKPORT-arm64-dts-meson-g12-Add-minimal-thermal-zon.patch \
           file://0021-FROMGIT-arm64-dts-meson-g12a-add-cooling-properties.patch \
           file://0022-BACKPORT-arm64-dts-meson-g12b-add-cooling-properties.patch \
           file://0023-FROMGIT-arm64-dts-meson-sm1-set-gpio-interrupt-contr.patch \
           file://0024-FROMGIT-arm64-dts-meson-g12b-khadas-vim3-add-missing.patch \
           file://0025-FROMGIT-arm64-dts-meson-khadas-vim3-move-audio-nodes.patch \
           file://0026-BACKPORT-soc-amlogic-meson-gx-socinfo-Fix-S905D3-ID-.patch \
           file://0027-FROMLIST-bluetooth-hci_bcm-enable-IRQ-capability-fro.patch \
           file://0028-YUKAWA-arm64-dts-meson-khadas-vim3-add-gpio-bluetoot.patch \
           file://0029-YUKAWA-arm64-dts-meson-g12a-sei510-add-gpio-bluetoot.patch \
           file://0030-FROMGIT-media-meson-vdec-add-g12a-platform.patch \
           file://0031-FROMGIT-media-meson-vdec-add-sm1-platform.patch \
           file://0032-FROMLIST-arm64-dts-meson-g12-common-add-video-decode.patch \
           file://0033-FROMLIST-arm64-dts-meson-sm1-add-video-decoder-compa.patch \
           file://0034-UPSTREAM-media-v4l2-dv-timings.c-fix-format-string.patch \
           file://0035-UPSTREAM-media-v4l2-core-Implement-v4l2_ctrl_new_std.patch \
           file://0036-UPSTREAM-media-add-V4L2_CTRL_TYPE_AREA-control-type.patch \
           file://0037-UPSTREAM-media-add-V4L2_CID_UNIT_CELL_SIZE-control.patch \
           file://0038-UPSTREAM-media-v4l2-common-add-pixel-encoding-suppor.patch \
           file://0039-UPSTREAM-media-v4l2-common-add-RGB565-and-RGB55-to-v.patch \
           file://0040-UPSTREAM-media-vb2-add-V4L2_BUF_FLAG_M2M_HOLD_CAPTUR.patch \
           file://0041-UPSTREAM-media-v4l2-mem2mem-support-held-capture-buf.patch \
           file://0042-UPSTREAM-media-videodev2.h-add-V4L2_DEC_CMD_FLUSH.patch \
           file://0043-UPSTREAM-media-v4l2-mem2mem-add-stateless_-try_-deco.patch \
           file://0044-UPSTREAM-media-v4l2-mem2mem-add-new_frame-detection.patch \
           file://0045-UPSTREAM-media-v4l2-core-correctly-validate-video-an.patch \
           file://0046-UPSTREAM-media-v4l2-dev-simplify-the-SDR-checks.patch \
           file://0047-UPSTREAM-media-v4l2-dev-fix-is_tch-checks.patch \
           file://0048-UPSTREAM-media-v4l2-dev-disable-frequency-and-tuner-.patch \
           file://0049-BACKPORT-media-v4l2-core-Add-new-metadata-format.patch \
           file://0050-BACKPORT-media-v4l-Add-definitions-for-HEVC-stateles.patch \
           file://0051-UPSTREAM-media-v4l2-dv-timings-Use-DIV_ROUND_CLOSEST.patch \
           file://0052-UPSTREAM-media-v4l2_ctrl-Add-p_def-to-v4l2_ctrl_conf.patch \
           file://0053-UPSTREAM-media-v4l2_core-Add-p_area-to-struct-v4l2_e.patch \
           file://0054-UPSTREAM-media-v4l2-ctrl-Use-p_const-when-possible.patch \
           file://0055-UPSTREAM-media-v4l2-mem2mem-Fix-hold-buf-flag-checks.patch \
           file://0056-UPSTREAM-media-v4l2-Use-FIELD_SIZEOF-directly.patch \
           file://0057-UPSTREAM-media-v4l2_ctrl-Add-const-pointer-to-ctrl_p.patch \
           file://0058-FROMLIST-media-v4l2-mem2mem-handle-draining-stopped-.patch \
           file://0059-FROMLIST-media-meson-vdec-bring-up-to-compliance.patch \
           file://0060-FROMLIST-media-meson-vdec-add-H.264-decoding-support.patch \
           file://0061-FROMLIST-media-meson-vdec-align-stride-on-32-bytes.patch \
           file://0062-FROMLIST-media-meson-vdec-add-helpers-for-lossless-f.patch \
           file://0063-FROMLIST-media-meson-vdec-add-common-HEVC-decoder-su.patch \
           file://0064-FROMLIST-media-meson-vdec-add-VP9-input-support.patch \
           file://0065-FROMLIST-media-meson-vdec-add-VP9-decoder-support.patch \
           file://0066-FROMLIST-arm64-dts-meson-g12g12-add-syscon-phandle-i.patch \
           file://0067-FROMLIST-media-platform-meson-ao-cec-g12a-add-wakeup.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

