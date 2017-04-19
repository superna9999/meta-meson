# Upstream Linux Amlogic Meson Yocto/Openembedded Layer

Now Amlogic SoCs of the Meson family are supported upstream :
 - Meson8b : s805
 - Meson-GX : s905 (GXBB) s905x/S905d (GXL) s912 (GXM)

This Yocto/Openembedded will help building images for these SoCs using the lastest uptream linux branch.

## Build Setup

Create a home repository for the build :
```
$ mkdir amlogic-bsp
```

Checkout Yocto/Poky :
```
$ cd amlogic-bsp
amlogic-bsp$ git clone --depth 1 git://git.yoctoproject.org/poky -b jethro poky
```

Checkout meta-meson :
```
amlogic-bsp$ git clone https://github.com/superna9999/meta-meson.git meta-meson
```

Source Poky environment :
```
amlogic-bsp$ source poky/oe-init-build-env
```

Add meta-meson layer :
```
amlogic-bsp/build$ bitbake-layers add-layer $PWD/../meta-meson/
```

## Selecting Machine to build for

Available S805 machines are :
 - hardkernel-odroidc1
 - amlogic-s805 (all S805 machines)

Available S905 machines are :
 - amlogic-p200
 - amlogic-p201
 - hardkernel-odroidc2
 - tronsmart-vega-s95-pro
 - tronsmart-vega-s95-meta
 - tronsmart-vega-s95-telos
 - Nexbox A95
 - amlogic-s905 (all S905 machines)

Available S905D machines are :
 - amlogic-p230
 - amlogic-p231
 - amlogic-s905d (all S905D machines)

Available S905X machines are :
 - amlogic-p212
 - Nexbox A95 (S905X)
 - amlogic-s905x (all S905X machines)

Available S912 machines are :
 - amlogic-q200
 - amlogic-q201
 - Nexbox A1
 - amlogic-s912 (all S912 machines)

## Selecting Image type

Images types available (in addition of standard Poky/OE images) :
 - amlogic-image-headless-sd : to flash on an eMMC or SD-Card
 - amlogic-image-headless-initrd : to load as ramdisk
 - amlogic-image-sato : Graphical images with X11 and Sato environment to flash on an eMMC or SD-Card

## Building example

Building SD image for Hardkernel Odroid-C2 machine :
```
amlogic-bsp/build$ export MACHINE=hardkernel-odroidc2
amlogic-bsp/build$ bitbake amlogic-image-sd
```

Install native tools :
```
amlogic-bsp/build$ bitbake dosfstools-native mtools-native parted-native
```

Then generate the SDCard image :
```
wic create ../poky/scripts/lib/wic/canned-wks/sdimage-bootpart.wks -e amlogic-image-headless-sd
```

The wic tool should print :
```
Checking basic build environment...
Done.

Creating image(s)...

Warning: bootloader config not specified, using defaults
Info: The new image(s) can be found here:
  /var/tmp/wic/build/sdimage-bootpart-201704180905-mmcblk.direct

The following build artifacts were used to create the image(s):
  ROOTFS_DIR:                   /path/to/amlogic-bsp/build/tmp/work/hardkernel_odroidc2-poky-linux/amlogic-image-headless-sd/1.0-r0/rootfs
  BOOTIMG_DIR:                  
  KERNEL_DIR:                   /path/to/amlogic-bsp/build/tmp/deploy/images/hardkernel-odroidc2
  NATIVE_SYSROOT:               /path/to/amlogic-bsp/build/tmp/sysroots/x86_64-linux


The image(s) were created using OE kickstart file:
  ../poky/scripts/lib/wic/canned-wks/sdimage-bootpart.wks
```

So, you can directly copy the content of the sdimage-bootpart-201704180905-mmcblk.direct to the SDCard :
```
amlogic-bsp/build$ sudo dd if=/var/tmp/wic/build/sdimage-bootpart-201704180905-mmcblk.direct of=/dev/mmcblk0 bs=1M
```
