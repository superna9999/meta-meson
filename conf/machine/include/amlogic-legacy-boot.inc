KERNEL_IMAGETYPE ?= "uImage"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-meson64"

KERNEL_CLASSES:meson-gx ?= "kernel-uimage-meson"

IMAGE_BOOT_FILES ?= "${KERNEL_IMAGETYPE} \
		     s905_autoscript aml_autoscript aml_autoscript.zip"

EXTRA_IMAGEDEPENDS += "s905-autoscript s905-autoscript-multiboot"
