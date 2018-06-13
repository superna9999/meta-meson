#
# Linux Support for Amlogic Meson SoCs
#

LINUX_VERSION_EXTENSION_append = "-meson"

PV = "${LINUX_VERSION}+git${SRCPV}"

inherit kernel
require linux.inc

PATCHTOOL = "git"
PATCH_COMMIT_FUNCTIONS = "1"

S = "${WORKDIR}/git"

