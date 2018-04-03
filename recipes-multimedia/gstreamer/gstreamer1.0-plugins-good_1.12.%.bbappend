FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0001-v4l2videodec-add-some-useful-debug-messages.patch \
    file://0002-v4l2-increase-pre-allocated-encoded-buffer-size.patch \
    file://0003-v4l2pool-Fix-wrong-error-message.patch \
    file://0004-v4l2videodec-Remove-unused-forward-declaration.patch \
    file://0005-v4l2-Add-Video-Encoder-support.patch \
    file://0006-v4l2-Don-t-redefine-__bitwise-if-already-set.patch \
    file://0007-v4l2videoenc-Make-sure-min_buffers-is-valid.patch \
    file://0008-v4l2videoenc-do-not-activate-capture-pool-during-negotiation.patch \
"
