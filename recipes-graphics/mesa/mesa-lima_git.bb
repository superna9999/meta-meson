require ${PN}.inc

PATCHTOOL = "git"
PATCH_COMMIT_FUNCTIONS = "1"

SRC_URI = "git://gitlab.freedesktop.org/mesa/mesa.git;protocol=https;branch=18.2 \
           file://0001-Makefile.vulkan.am-explictly-add-lib-expat-to-intel-.patch \
           file://0003-winsys-svga-drm-Include-sys-types.h.patch \
           file://0004-hardware-gloat.patch \
           file://0005-Properly-get-LLVM-version-when-using-LLVM-Git-releas.patch \
           \
           file://lima/0001-gallium-u_math-add-ushort_to_float-float_to_ushort.patch \
           file://lima/0002-nir-add-load-uniform-lower-to-scalar.patch \
           file://lima/0003-u_dynarray-add-util_dynarray_enlarge.patch \
           file://lima/0004-gallium-add-a-cap-to-force-compute-minmax-indices.patch \
           file://lima/0005-drm-uapi-forcc-add-ARM-tiled-modifier-format.patch \
           file://lima/0006-drm-uapi-add-lima_drm.h.patch \
           file://lima/0007-gallium-add-lima-driver.patch \
           file://lima/0008-gallium-add-sun4i-driver.patch \
           file://lima/0009-gallium-add-exynos-driver.patch \
           file://lima/0010-gallium-add-meson-driver.patch \
           file://lima/0011-gallium-add-rockchip-driver.patch \
           file://lima/0012-lima-use-WINSYS_HANDLE_-for-18.2-rebase.patch \
           file://lima/0013-lima-is_format_supported-changed-in-18.2.patch \
           file://lima/0014-egl-glx-query-dri-integer-to-expose-EGL-GLX_EXT_buff.patch \
           file://lima/0015-gallium-add-PIPE_CAP_BUFFER_AGE.patch \
           file://lima/0016-egl-fix-query-buffer-age-fail-when-EGL_KHR_partial_u.patch \
           file://lima/0017-egl-android-Delete-set_damage_region-from-egl-dri-vt.patch \
           file://lima/0018-dri_interface-add-an-interface-for-setting-damage-re.patch \
           file://lima/0019-egl-dri-Use-__DRI2_DAMAGE-extension-for-KHR_partial_.patch \
           file://lima/0020-st-dri2-use-dynamic-alloc-extensions.patch \
           file://lima/0021-gallium-add-PIPE_CAP_SET_DAMAGE.patch \
           file://lima/0022-st-dri2-add-optional-dri2DamageExtension.patch \
           file://lima/0023-lima-add-lima_set_damage_region.patch \
           file://lima/0024-lima-mali450-be-able-to-not-use-dlbu.patch \
           file://lima/0025-Revert-lima-initial-implementation-for-no-glClear-dr.patch \
           file://lima/0026-lima-fix-texture-wrap_t-parameter.patch \
           file://lima/0027-lima-seperate-lima_texture_desc_set_res.patch \
           file://lima/0028-lima-reload-FB-tile-buffer-when-glFlush-without-glCl.patch \
           file://lima/0029-lima-set-damage-with-tile-buffer-region.patch \
           file://lima/0030-lima-implement-EGL_KHR_partial_update.patch \
           file://lima/0031-lima-ir-print-name-of-unsupported-nir_op.patch \
           file://lima/0032-lima-clear-add-command-stream-directly.patch \
           file://lima/0033-lima-implement-partial-clear.patch \
           file://lima/0034-lima-ppir-fix-bitcopy-bug.patch \
           file://lima/0035-lima-use-PLBU_CMD-for-plbu-command-stream-constructi.patch \
           file://lima/0036-lima-use-VS_CMD-for-vs-command-stream-construction.patch \
           file://lima/0037-lima-move-update-submit-bo-to-the-begin-of-a-draw-cl.patch \
           file://lima/0038-lima-fix-mtx_lock-Assertion-mtx-NULL-failed.patch \
           file://lima/0039-lima-fix-LIMA_DUMP_COMMAND_STREAM-fail.patch \
           file://lima/0040-lima-fix-texture-layout-setting.patch \
           file://lima/0041-lima-gpir-Rename-gpir_lower_funcs.patch \
           file://lima/0042-lima-gpir-add-fnot-op-support.patch \
           file://lima/0043-lima-pp-Add-a-disassembler.patch \
           file://lima/0044-lima-gp-Add-a-disassembler.patch \
           file://lima/0045-lima-pp-Fix-some-whitespace-issues-in-disassembler.patch \
           file://lima/0046-lima-pp-Fix-disassembler-shift-issue.patch \
           file://lima/0047-lima-fix-multi-triangle-index-draw-hang.patch \
           file://lima/0001-lima-fix-tiling-untiling-partial-textures.patch \
           "

PV = "18.2.4+git${SRCPV}"
SRCREV = "624e384ea86afea737f9d3b952a9c3edbecd3950"

S = "${WORKDIR}/git"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}
