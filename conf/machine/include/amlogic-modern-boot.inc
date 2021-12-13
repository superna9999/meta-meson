KERNEL_IMAGETYPE ?= "fitImage"
KERNEL_CLASSES ?= "kernel kernel-fitimage"

IMAGE_BOOT_FILES = "${KERNEL_IMAGETYPE}"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-meson-gx"
PREFERRED_PROVIDER_u-boot ?= "u-boot-meson-gx"
PREFERRED_PROVIDER_virtual/trusted-firmware-a ?= "amlogic-boot-fip"

EXTRA_IMAGEDEPENDS += "u-boot virtual/trusted-firmware-a"

# Generate an SDCard Image
IMAGE_CLASSES += "image_types_meson"

WKS_FILE = "sdimage-meson.wks"
