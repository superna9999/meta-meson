KERNEL_IMAGETYPE ?= "uImage"

IMAGE_BOOT_FILES ?= "${KERNEL_IMAGETYPE} \
		     s905_autoscript aml_autoscript aml_autoscript.zip"

WKS_FILE ?= "sdimage-bootpart-meson.wks"

EXTRA_IMAGEDEPENDS += "s905-autoscript s905-autoscript-multiboot"
