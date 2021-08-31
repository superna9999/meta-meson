# Amlogic A113D Configurations

require conf/machine/include/amlogic-meson64.inc

MACHINE_FEATURES = "serial usbhost sdio wifi alsa"

SOC_FAMILY:append = ":meson-axg"
