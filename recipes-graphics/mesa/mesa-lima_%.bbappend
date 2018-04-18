# Enable lima for meson
PACKAGECONFIG_append_meson-gx = " gallium gbm"
PACKAGECONFIG_remove_meson-gx = " vulkan"
GALLIUMDRIVERS_meson-gx = "meson,lima"
DRIDRIVERS_meson-gx = ""
