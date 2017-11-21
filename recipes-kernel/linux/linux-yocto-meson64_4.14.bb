#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.14.y;name=meson"

SRC_URI += "file://defconfig \
            file://meson64.scc \
"

LINUX_VERSION ?= "4.14"

KERNEL_VERSION_SANITY_SKIP="1"

# tag: v4.14
SRCREV_meson="bebc6082da0a9f5d47a1ea2edc099bf671058bd4"

KERNEL_CLASSES = "kernel-uimage-meson64"

LINUX_VERSION_EXTENSION_append = "-meson64"
KBUILD_DEFCONFIG = "defconfig"

require linux-yocto-meson.inc
