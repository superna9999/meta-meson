FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI += "file://meson64-kmeta;type=kmeta;destsuffix=meson64-kmeta"

COMPATIBLE_MACHINE_khadas-vim3 = "khadas-vim3"
KMACHINE_khadas-vim3 = "meson-gx"

LINUX_VERSION_EXTENSION_append_meson-gx = "-meson64"

SERIAL_CONSOLES = "115200;ttyAML0"

# Add HDMI output support if display output is required
KERNEL_FEATURES_append = "${@bb.utils.contains_any('DISTRO_FEATURES', 'x11 wayland', \
    ' cfg/meson-hdmi.scc', '', d)}"
