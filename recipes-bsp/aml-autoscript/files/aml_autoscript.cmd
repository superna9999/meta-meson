setenv kernel_loadaddr "0x11000000"
setenv initrd_loadaddr "0x13000000"
setenv dtb_mem_addr "0x1000000"
setenv bootargs "console=ttyAML0,115200n8 console=tty0 no_console_suspend consoleblank=0 root=/dev/mmcblk1p2"
if fatload mmc 0 ${kernel_loadaddr} uImage; then if fatload mmc 0 ${dtb_mem_addr} ##DTB## ; then booti ${kernel_loadaddr} - ${dtb_mem_addr} ; fi ; fi
if fatload mmc 1 ${kernel_loadaddr} uImage; then if fatload mmc 1 ${dtb_mem_addr} ##DTB## ; then booti ${kernel_loadaddr} - ${dtb_mem_addr} ; fi ; fi
