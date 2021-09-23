KERNEL_IMAGETYPE = "uImage"

IMAGE_BOOT_FILES ?= "uImage"

WKS_FILE ?= "sdimage-bootpart-meson.wks"

EXTRA_IMAGEDEPENDS += "s905-autoscript s905-autoscript-multiboot"
IMAGE_BOOT_FILES += " s905_autoscript aml_autoscript aml_autoscript.zip"
