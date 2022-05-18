do_install:append:meson-gx() {
	# Disable Composite-1 output on Amlogic boards
	# This should be removed when Linux 5.17 is used
	# since CVBS connecter will report Unknown state
	tee -a ${D}${sysconfdir}/xdg/weston/weston.ini <<EOT
# Disable Composite-1 output since it always
# reports Connected state and weston uses it
# by default and fails switching to it
[output]
name=Composite-1
mode=off
EOT

}
