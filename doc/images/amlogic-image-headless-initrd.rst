============================================================
 Information about the *amlogic-image-headless-initrd image*
============================================================

The initial RAM disk image or short ``initrd`` comes handy during the bring-up of a new machine or when the flashed operating system shall be inspected.
The footprint of this headless image is relatively small.

To tinker with the ``initrd`` image a serial console attached to your board, for U-Boot access, is required.

The following commands may differ from the version of U-Boot installed on your device.

To use the ``amlogic-image-headless-initrd`` image, a little bit of preparation is needed. To boot the ramdisk image we do have to load the Linux Kernel, a device tree blob and the initrd image into RAM first.
There are multiple ways to do so. In this example we do use `tftp </doc/utils/tftp.rst>`_ to load the image over the network from a development host.::

    g12a_u212_v1# tftp ${loadaddr} uImage
    g12a_u212_v1# tftp ${dtb_mem_addr} meson-sm1-x96-max.dtb
    g12a_u212_v1# tftp ${initrd_high} amlogic-image-headless-initrd-amediatech-x96-max.cpio.xz.u-boot
    g12a_u212_v1# setenv bootargs "console=ttyAML0,115200 panic=3 root=/dev/ram0 rw"
    g12a_u212_v1# bootm ${loadaddr} ${initrd_high} ${dtb_mem_addr}
