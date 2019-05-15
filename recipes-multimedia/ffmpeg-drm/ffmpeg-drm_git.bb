SUMMARY = "A decode->display test tool leveraging FFmpeg and DRM via dmabuf"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/Elyotna/ffmpeg-drm.git;protocol=https"

S = "${WORKDIR}/git"

SRCREV="6fcfdf5c20a586ec6e8b002bcc44034243c55abf"
DEPENDS = "libdrm libav"

inherit meson

FILES_${PN} = "${bindir}/ffmpeg-drm"
