SUMMARY = "A decode->display test tool leveraging FFmpeg and DRM via dmabuf"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/Elyotna/ffmpeg-drm.git;protocol=https"

S = "${WORKDIR}/git"

SRCREV="1e98f0d811400bea763d99c424e52e12c94b5900"
DEPENDS = "libdrm libav"

inherit meson

FILES_${PN} = "${bindir}/ffmpeg-drm"
