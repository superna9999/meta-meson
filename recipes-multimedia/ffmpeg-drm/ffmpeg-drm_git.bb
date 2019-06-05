SUMMARY = "A decode->display test tool leveraging FFmpeg and DRM via dmabuf"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/superna9999/ffmpeg-drm.git;protocol=https;branch=disable-all-other-planes-for-pr"

S = "${WORKDIR}/git"

SRCREV="f85998d0049b5ae9719e5a3a0a04bf52440d2065"
DEPENDS = "libdrm libav"

inherit meson

FILES_${PN} = "${bindir}/ffmpeg-drm"
