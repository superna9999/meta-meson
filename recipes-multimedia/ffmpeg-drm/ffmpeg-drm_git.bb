SUMMARY = "A decode->display test tool leveraging FFmpeg and DRM via dmabuf"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/Elyotna/ffmpeg-drm.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

SRCREV="ba4a0e8563e097eafc29dee4343286191e227419"
DEPENDS = "libdrm libav"

inherit meson

do_install_append() {
	mkdir -p ${D}/usr/share/ffmpeg-drm
	cp ${S}/h264.FVDO_Freeway_720p.264 ${D}/usr/share/ffmpeg-drm/
}

FILES_${PN} = "${bindir}/ffmpeg-drm /usr/share/ffmpeg-drm/h264.FVDO_Freeway_720p.264"
