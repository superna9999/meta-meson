#
# Linux Support for 32bit Amlogic Meson SoCs
#

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.13.y;name=meson"

# tag: v4.13
SRCREV_meson="569dbb88e80deb68974ef6fdd6a13edb9d686261"

KERNEL_VERSION_SANITY_SKIP="1"

LINUX_VERSION ?= "4.13"

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

require linux-yocto-meson.inc
