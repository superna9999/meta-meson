#
# Linux Support for Amlogic Meson SoCs
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Linux amlogic integ tree
SRC_URI = "git://github.com/superna9999/linux.git;protocol=http;nocheckout=1;branch=amlogic/v4.9/drm-usb-scpi-usb-gxl-gxm;name=meson"

LINUX_VERSION ?= "4.9"
LINUX_VERSION_EXTENSION_append = "-meson"

# tag: amlogic/v4.9/drm-usb-scpi-usb-gxl-gxm a6c2023f5458b34c1066ddb1c06fee66549cda1b
SRCREV_meson="a6c2023f5458b34c1066ddb1c06fee66549cda1b"

PV = "${LINUX_VERSION}+git${SRCPV}"
