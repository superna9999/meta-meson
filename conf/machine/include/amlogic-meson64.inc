# Amlogic Meson64 Configurations

require conf/machine/include/amlogic-meson.inc

KERNEL_IMAGETYPE ?= "Image"

MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto-meson64"

SOC_FAMILY = "amlogic:meson-gx"
require conf/machine/include/soc-family.inc

DEFAULTTUNE ?= "aarch64"
require conf/machine/include/arm/arch-armv8.inc

EXTRA_IMAGEDEPENDS += " s905-autoscript"
EXTRA_IMAGEDEPENDS += " s905-autoscript-multiboot"
IMAGE_BOOT_FILES += " s905_autoscript"
IMAGE_BOOT_FILES += " aml_autoscript"
#IMAGE_BOOT_FILES += " aml_autoscript.zip"
