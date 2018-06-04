DESCRIPTION = "A X11 SD/MMC Image for Amlogic Meson SoCs with embedded kernel on the filesystem"

IMAGE_FEATURES += "ssh-server-openssh package-management splash x11-base x11-sato hwcodecs"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    kernel-image \
    kernel-modules \
    kernel-devicetree \
    linux-firmware \
    opkg \
    opkg-collateral \
    packagegroup-core-x11-sato-games \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

# 4G Rootfs
IMAGE_ROOTFS_SIZE = "4194304"

inherit core-image
