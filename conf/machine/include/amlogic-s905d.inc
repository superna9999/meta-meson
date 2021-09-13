# Amlogic S905D Configurations

require conf/machine/include/amlogic-meson64.inc

MACHINE_FEATURES = "serial usbhost sdio screen wifi alsa"

SOC_FAMILY_append = ":meson-gxl"
