#
# Linux Support for 32bit Amlogic Meson SoCs
#

# Linux stable tree
#SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.16.y;name=meson"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;nocheckout=1;branch=master;name=meson"

# tag: v4.16
SRCREV_meson="0adb32858b0bddf4ada5f364a84ed60b196dbcda"

KERNEL_VERSION_SANITY_SKIP="1"

LINUX_VERSION ?= "4.16"

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

require linux-yocto-meson.inc
