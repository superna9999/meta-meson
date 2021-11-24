PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto"
KERNEL_IMAGETYPE ?= "fitImage"
KERNEL_CLASSES ?= "kernel kernel-fitimage"

IMAGE_BOOT_FILES ?= "${KERNEL_IMAGETYPE}"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
PREFERRED_PROVIDER_u-boot ?= "u-boot"

UBOOT_EXTLINUX ?= "1"
UBOOT_EXTLINUX_CONSOLE ?= "console=ttyAML0"
# No need for dtb when using fitImage
UBOOT_EXTLINUX_FDT = ""
UBOOT_EXTLINUX_FDTDIR = ""
# SDCard by default
UBOOT_EXTLINUX_ROOT ?= "root=/dev/mmcblk0p1"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
       kernel-image \
       u-boot-extlinux \
"

# Generate an SDCard Image
IMAGE_CLASSES += "image_types_meson"
WKS_FILE = "sdimage-meson.wks"
