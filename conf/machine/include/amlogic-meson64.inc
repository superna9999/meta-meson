# Amlogic Meson64 Configurations

require conf/machine/include/amlogic-meson.inc

MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-meson64"

SOC_FAMILY = "amlogic:meson-gx"
require conf/machine/include/soc-family.inc
