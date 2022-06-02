DESCRIPTION = "A initrd Image for Amlogic Meson SoCs to boot from network"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    kernel-modules \
    kernel-devicetree \
    linux-firmware \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

IMAGE_FSTYPES = "\
                 cpio.xz \
                 cpio.xz.u-boot \
                "

inherit core-image
