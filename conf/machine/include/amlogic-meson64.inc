# Amlogic Meson64 Configurations

require conf/machine/include/amlogic-meson.inc

KERNEL_IMAGETYPE ?= "Image"

MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto-meson64"

SOC_FAMILY = "amlogic:meson-gx"
require conf/machine/include/soc-family.inc

DEFAULTTUNE ?= "aarch64"
require conf/machine/include/arm/arch-armv8a.inc
