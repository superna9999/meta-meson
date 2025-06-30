PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto"
KERNEL_CLASSES += "kernel-fit-extra-artifacts"

KERNEL_IMAGETYPE ?= "Image"
RRECOMMENDS:${KERNEL_PACKAGE_NAME}-base = ""
MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "linux-yocto-fitimage"
KERNEL_DEPLOY_DEPEND = "linux-yocto-fitimage:do_deploy"

IMAGE_BOOT_FILES = "fitImage"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
PREFERRED_PROVIDER_u-boot ?= "u-boot"
PREFERRED_PROVIDER_virtual/trusted-firmware-a ?= "amlogic-boot-fip"

EXTRA_IMAGEDEPENDS += "u-boot virtual/trusted-firmware-a"

# Generate an SDCard Image
IMAGE_CLASSES += "image_types_meson"
WKS_FILE = "sdimage-meson.wks"
