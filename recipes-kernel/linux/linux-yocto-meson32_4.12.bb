#
# Linux Support for 32bit Amlogic Meson SoCs
#

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.12.y;name=meson"

# tag: v4.12
SRCREV_meson="6f7da290413ba713f0cdd9ff1a2a9bb129ef4f6c"

KERNEL_VERSION_SANITY_SKIP="1"

LINUX_VERSION ?= "4.12"

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

require linux-yocto-meson.inc
