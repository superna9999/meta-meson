PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto"
KERNEL_IMAGETYPE ?= "fitImage"
KERNEL_CLASSES ?= "kernel kernel-fitimage"

IMAGE_BOOT_FILES = "${KERNEL_IMAGETYPE}"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
PREFERRED_PROVIDER_u-boot ?= "u-boot"

EXTRA_IMAGEDEPENDS += "u-boot"

# Generate an SDCard Image
IMAGE_CLASSES += "image_types_meson"
WKS_FILE = "sdimage-meson.wks"
