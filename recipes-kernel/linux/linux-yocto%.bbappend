FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += "file://meson64-kmeta;type=kmeta;destsuffix=meson64-kmeta"

COMPATIBLE_MACHINE:append:meson-gx = "|khadas-vim3"
KMACHINE:meson-gx = "meson-gx"

LINUX_VERSION_EXTENSION:append:meson-gx = "-meson64"

SERIAL_CONSOLES = "115200;ttyAML0"

# Add HDMI output support if display output is required
KERNEL_FEATURES:append = "${@bb.utils.contains_any('DISTRO_FEATURES', 'x11 wayland', \
    ' cfg/meson-hdmi.scc', '', d)}"

KERNEL_FEATURES:append = "${@bb.utils.contains('DISTRO_FEATURES', 'pci', \
    ' cfg/meson-pci.scc', '', d)}"
