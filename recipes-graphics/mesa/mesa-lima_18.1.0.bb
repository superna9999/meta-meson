require ${PN}.inc

PATCHTOOL = "git"
PATCH_COMMIT_FUNCTIONS = "1"

SRC_URI = "git://gitlab.freedesktop.org/lima/mesa.git;protocol=https;branch=lima-18.1 \
           file://0001-Makefile.vulkan.am-explictly-add-lib-expat-to-intel-.patch \
           file://0003-winsys-svga-drm-Include-sys-types.h.patch \
           file://0004-hardware-gloat.patch \
           file://0005-Properly-get-LLVM-version-when-using-LLVM-Git-releas.patch \
           "

PV = "18.1.0+git${SRCPV}"
SRCREV = "f3d3d76b452cd40cc418b10285e68552556a25c5"

S = "${WORKDIR}/git"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}
