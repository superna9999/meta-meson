FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://acs_tool.py \
	file://fit.cfg \
"

SRC_URI:sei510:append = " \
	file://no-android.cfg \
"

SRC_URI:sei610:append = " \
	file://no-android.cfg \
"
