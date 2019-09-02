# Amlogic S922X Configurations

require conf/machine/include/amlogic-meson64.inc

MACHINE_FEATURES = "serial usbhost sdio screen wifi"

SOC_FAMILY_append = ":meson-g12b"
