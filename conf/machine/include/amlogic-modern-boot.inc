KERNEL_IMAGETYPE = "Image"

PREFERRED_PROVIDER_virtual/bootloader = "u-boot-meson-gx"
PREFERRED_PROVIDER_u-boot = "u-boot-meson-gx"
PREFERRED_VERSION_u-boot-meson-gx = "2021.07%"

UBOOT_EXTLINUX = "1"
UBOOT_EXTLINUX_CONSOLE = "console=ttyAML0"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
       kernel-image \
       kernel-devicetree \
       u-boot-meson-gx \
"

# Generate an SDCard Image
IMAGE_CLASSES += "image_types_meson"

WKS_FILE = "sdimage-meson.wks"
