inherit kernel-uboot

python __anonymous () {
    kerneltype = d.getVar('KERNEL_IMAGETYPE', True)
    if kerneltype == 'uImage':
        depends = d.getVar("DEPENDS", True)
        depends = "%s u-boot-mkimage-native" % depends
        d.setVar("DEPENDS", depends)
        d.setVar("KERNEL_IMAGETYPE_FOR_MAKE", "Image")
}

do_uboot_mkimage() {
	if test "x${KERNEL_IMAGETYPE}" = "xuImage" ; then
		uboot-mkimage -A ${UBOOT_ARCH} -O linux -T kernel -C none -a ${UBOOT_LOADADDRESS} -e ${UBOOT_ENTRYPOINT} -n "${DISTRO_NAME}/${PV}/${MACHINE}" -d ${B}/arch/${ARCH}/boot/Image ${B}/arch/${ARCH}/boot/uImage
	fi
}

addtask uboot_mkimage before do_install after do_compile
