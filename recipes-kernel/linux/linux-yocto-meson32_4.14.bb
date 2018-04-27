#
# Linux Support for 32bit Amlogic Meson SoCs
#

KERNEL_CLASSES = "kernel-uimage-meson"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.14.y;name=meson"

# tag: v4.14
SRCREV_meson="bebc6082da0a9f5d47a1ea2edc099bf671058bd4"

KERNEL_VERSION_SANITY_SKIP="1"

LINUX_VERSION ?= "4.13"

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

require linux-yocto-meson.inc
