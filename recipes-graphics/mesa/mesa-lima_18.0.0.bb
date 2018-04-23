require ${PN}.inc

SRC_URI = "git://github.com/yuq/mesa-lima.git;branch=lima-18.0 \
           file://0001-Makefile.vulkan.am-explictly-add-lib-expat-to-intel-.patch \
           file://0002-Simplify-wayland-scanner-lookup.patch \
           file://0003-winsys-svga-drm-Include-sys-types.h.patch \
           file://0004-hardware-gloat.patch \
           file://0005-Properly-get-LLVM-version-when-using-LLVM-Git-releas.patch \
           file://0006-endianness-check-is-OS-wide-and-not-specific-to-libc.patch \
           "

PV = "18.0.0+git${SRCPV}"
SRCREV = "2cfcf46af2d46983193c205aff987104f35f1de1"

S = "${WORKDIR}/git"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}
