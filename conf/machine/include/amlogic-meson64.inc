# Amlogic Meson64 Configurations

require conf/machine/include/amlogic-meson.inc

MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

SOC_FAMILY = "amlogic:meson-gx"
require conf/machine/include/soc-family.inc

MACHINEOVERRIDES =. "meson64all:"
