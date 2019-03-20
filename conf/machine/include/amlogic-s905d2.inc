# Amlogic S905X Configurations

require conf/machine/include/amlogic-meson64.inc

MACHINE_FEATURES = "serial usbhost sdio screen wifi"
PREFERRED_PROVIDER_virtual/libgbm = "minigbm"

SOC_FAMILY_append = ":meson-g12a"
