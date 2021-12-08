require u-boot-common_${PV}.inc
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "bison-native bc-native dtc-native"

PROVIDES = "u-boot virtual/bootloader"

SRC_URI_append = " \
	file://acs_tool.py \
	file://fit.cfg \
"

SRC_URI_append_sei510 = " \
	file://no-android.cfg \
"

SRC_URI_append_sei610 = " \
	file://no-android.cfg \
"
