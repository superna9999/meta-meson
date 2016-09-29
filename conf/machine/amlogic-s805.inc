# Amlogic S805 Configurations

require conf/machine/amlogic-meson32.inc

MACHINE_FEATURES = "serial"

DEFAULTTUNE ?= "cortexa5hf"
require conf/machine/include/tune-cortexa5.inc
