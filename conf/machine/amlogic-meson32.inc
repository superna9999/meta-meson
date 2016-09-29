# Amlogic Meson32 Configurations

require conf/machine/amlogic-meson.inc

KERNEL_IMAGETYPE ?= "zImage"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto-meson32"

SOC_FAMILY = "amlogic:meson8"
require conf/machine/include/soc-family.inc
