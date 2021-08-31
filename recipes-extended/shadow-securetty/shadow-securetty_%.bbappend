FILESEXTRAPATHS:append := ":${THISDIR}/${PN}"

SRC_URI:append = " file://securetty-aml"

do_configure:prepend () {
	cat ${WORKDIR}/securetty-aml >> ${WORKDIR}/securetty
}
