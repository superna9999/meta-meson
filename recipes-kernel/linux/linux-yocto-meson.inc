#
# Linux Support for Amlogic Meson SoCs
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Linux amlogic integ tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/khilman/linux-amlogic.git;protocol=git;nocheckout=1;branch=v4.8/integ;name=meson64"

LINUX_VERSION ?= "4.8"
LINUX_VERSION_EXTENSION_append = "-meson"

# tag: v4.8-rc7-amlogic-integ 	26e4369910a04e9d63fb67e175b4876c0f972355
SRCREV_meson64="26e4369910a04e9d63fb67e175b4876c0f972355"

PV = "${LINUX_VERSION}+git${SRCPV}"
