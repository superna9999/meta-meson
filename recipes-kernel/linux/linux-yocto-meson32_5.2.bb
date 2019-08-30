#
# Linux Support for 32bit Amlogic Meson SoCs
#

KERNEL_CLASSES = "kernel-uimage-meson"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-5.2.y;name=meson"

# tag: v4.20.3
SRCREV_meson = "c3915fe1bf1235dbf3b0bced734c960202915bd5"

KERNEL_VERSION_SANITY_SKIP="1"
	
# Linux stable tree
LINUX_VERSION = "5.2.11"

LINUX_VERSION_EXTENSION_append = "-meson32"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

require linux-yocto-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
