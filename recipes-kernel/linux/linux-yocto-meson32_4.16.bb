#
# Linux Support for 32bit Amlogic Meson SoCs
#

KERNEL_CLASSES = "kernel-uimage-meson"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.16.y;name=meson"

# tag: v4.16.1
SRCREV_meson="11454943b264b548e714d8edf932ebf306e5f808"

KERNEL_VERSION_SANITY_SKIP="1"

LINUX_VERSION ?= "4.16.1"

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

require linux-yocto-meson.inc
