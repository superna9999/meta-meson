#
# Linux Support for 32bit Amlogic Meson SoCs
#

KERNEL_CLASSES = "kernel-uimage-meson"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.20.y;name=meson"

# tag: v4.20.3
SRCREV_meson = "e9a713f77bb26886d7207a8bb6dd2c9c7b8e287c"

KERNEL_VERSION_SANITY_SKIP="1"
	
# Linux stable tree
LINUX_VERSION = "4.20.3"

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

require linux-yocto-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
