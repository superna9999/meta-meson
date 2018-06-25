# Amlogic S9xxx Configurations

require conf/machine/include/amlogic-meson64.inc

MACHINE_FEATURES = "serial usbhost sdio screen wifi"

EXTRA_IMAGEDEPENDS += " s905-autoscript s905-autoscript-multiboot"
IMAGE_BOOT_FILES += " s905_autoscript aml_autoscript aml_autoscript.zip"
