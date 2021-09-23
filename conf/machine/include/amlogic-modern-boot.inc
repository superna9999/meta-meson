KERNEL_IMAGETYPE ?= "Image"

IMAGE_BOOT_FILES ?= "${KERNEL_IMAGETYPE}"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-meson-gx"
PREFERRED_PROVIDER_u-boot ?= "u-boot-meson-gx"
PREFERRED_VERSION_u-boot-meson-gx ?= "2021.07%"

UBOOT_EXTLINUX ?= "1"
UBOOT_EXTLINUX_CONSOLE ?= "console=ttyAML0"
# SDCard by default
UBOOT_EXTLINUX_ROOT ?= "root=/dev/mmcblk0p1"
UBOOT_EXTLINUX_FDT ?= "../${@os.path.basename("${KERNEL_DEVICETREE}")}"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
       kernel-image \
       kernel-devicetree \
       u-boot-meson-gx \
"

# Generate an SDCard Image
IMAGE_CLASSES += "image_types_meson"

WKS_FILE ?= "sdimage-meson.wks"
