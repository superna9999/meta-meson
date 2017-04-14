#
# Linux Support for Amlogic Meson SoCs
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=linux-4.10.y;name=meson"

LINUX_VERSION ?= "4.10.10"
LINUX_VERSION_EXTENSION_append = "-meson"

# tag: v4.10.10
SRCREV_meson="e6925852d5b862bac749fab9c8d26491cda99e4e"

PV = "${LINUX_VERSION}+git${SRCPV}"
