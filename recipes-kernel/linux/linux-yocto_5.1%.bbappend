FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

# This only applies for kernel < v5.16
python() {
    if d.getVar("PV") == '5.16' or d.getVar("PV") == '5.17' or d.getVar("PV") == '5.18' or d.getVar("PV") == '5.19':
        raise bb.parse.SkipBbappend("This bbappend only supports version < 5.16. Skipping bbappend")
}

SRC_URI:append:meson-gx = " file://0001-ASoC-meson-implement-driver-name.patch"
