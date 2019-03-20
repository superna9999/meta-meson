DESCRIPTION = "A initrd Image for Amlogic Meson SoCs to test GBM Mali"

DEPENDS = "pyamlboot-script"

IMAGE_INSTALL = "\
    curl \
    wget \
    python \
    parted \
    packagegroup-core-boot \
    kernel-modules \
    kernel-module-mali-bifrost \
    gbm-es2-demo \
    libdrm-tests \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

IMAGE_FSTYPES += "cpio.xz.u-boot"

inherit core-image
