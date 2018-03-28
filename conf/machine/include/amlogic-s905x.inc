# Amlogic S905X Configurations

require conf/machine/include/amlogic-meson64.inc

MACHINE_FEATURES = "serial usbhost sdio screen wifi"

SOC_FAMILY_append = ":meson-gxl"

PREFERRED_PROVIDER_virtual/egl = "mesa-lima"
PREFERRED_PROVIDER_virtual/libgles1 = "mesa-lima"
PREFERRED_PROVIDER_virtual/libgles2 = "mesa-lima"
PREFERRED_PROVIDER_virtual/libopencl = "mesa-lima"
PREFERRED_PROVIDER_virtual/libgl = "mesa-lima"
PREFERRED_PROVIDER_virtual/mesa = "mesa-lima"
