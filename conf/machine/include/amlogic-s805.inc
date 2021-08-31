# Amlogic S805 Configurations

require conf/machine/include/amlogic-meson32.inc

MACHINE_FEATURES = "serial"

DEFAULTTUNE ?= "cortexa5hf-neon"
require conf/machine/include/arm/armv7a/tune-cortexa5.inc
