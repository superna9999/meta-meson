#
# Linux Support for Amlogic Meson SoCs
#

LINUX_VERSION_EXTENSION_append = "-meson"

PV = "${LINUX_VERSION}+git${SRCPV}"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

