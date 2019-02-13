DESCRIPTION = "A initrd Image for Amlogic Meson SoCs to bootstrap system from USB"

DEPENDS = "pyamlboot-script"

IMAGE_INSTALL = "\
    curl \
    wget \
    python \
    connman \
    parted \
    packagegroup-core-boot \
    kernel-modules \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

IMAGE_FSTYPES = "cpio.xz.u-boot"

inherit core-image
