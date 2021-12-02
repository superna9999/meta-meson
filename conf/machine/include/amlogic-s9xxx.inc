# Amlogic S9xxx Configurations

require conf/machine/include/amlogic-meson64.inc

require conf/machine/include/arm/arch-armv8a.inc

EXTRA_IMAGEDEPENDS += " s905-autoscript s905-autoscript-multiboot"
IMAGE_BOOT_FILES += " s905_autoscript aml_autoscript aml_autoscript.zip"
