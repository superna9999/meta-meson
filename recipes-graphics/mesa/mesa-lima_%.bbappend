# Enable lima for meson
PACKAGECONFIG_append_meson-gx = " gallium"
PACKAGECONFIG_remove_meson-gx = " vulkan"
GALLIUMDRIVERS_meson-gx = "meson,lima,freedreno,etnaviv,swrast,imx,rockchip"
DRIDRIVERS_meson-gx = ""
