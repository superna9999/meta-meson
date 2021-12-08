FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

SRC_URI_append = " file://securetty-aml"

do_configure_prepend () {
	cat ${WORKDIR}/securetty-aml >> ${WORKDIR}/securetty
}
