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
amlogic-bsp$ git clone --depth 1 git://git.yoctoproject.org/poky -b sumo poky
```

Checkout meta-meson :
```
amlogic-bsp$ git clone https://github.com/superna9999/meta-meson.git meta-meson -b sumo
```

Initialize environment :
```
amlogic-bsp$ TEMPLATECONF=../meta-meson/conf
amlogic-bsp$ source poky/oe-init-build-env
```

or :

```
amlogic-bsp$ source poky/oe-init-build-env
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
 - nexbox-a95x-s905
 - wetek-hub
 - wetek-play2
 - amlogic-s905 (all S905 machines)

Available S905D machines are :
 - amlogic-p230
 - amlogic-p231
 - amlogic-s905d (all S905D machines)

Available S905X machines are :
 - amlogic-p212
 - nexbox-a95x-s905x
 - khadas-vim
 - hwacom-amazetv
 - amlogic-s905x (all S905X machines)

Available S912 machines are :
 - amlogic-q200
 - amlogic-q201
 - nexbox-a1
 - amlogic-s912 (all S912 machines)

Available S9xxx machines are :
 - amlogic-s9xxx (all S905 and S905X and S912 machines)

## Selecting Image type

Images types available (in addition of standard Poky/OE images) :
 - amlogic-image-headless-sd : to flash on an eMMC or SD-Card
 - amlogic-image-headless-initrd : to load as ramdisk
 - amlogic-image-sato : Graphical images with X11 and Sato environment to flash on an eMMC or SD-Card

## Building example

Building SD image for all S905 and S905X and S912 machines :
```
amlogic-bsp/build$ export MACHINE=amlogic-s9xxx
amlogic-bsp/build$ bitbake amlogic-image-sato
```

A .wic image will be generated in the tmp/deploy/images/$MACHINE/ directory.

This Image contains a FAT32 BOOT partition will the kernel uImage and .dtb, compatible with Amlogic U-Boot already flashed on your device.

For the amlogic-p212, khadas-vim and libretech-cc, Mainline U-Boot is automatically installed in a single ext4 partition .sdcard image in the tmp/deploy/images/$MACHINE/ directory.

You will be able to dd the image onto the raw SDcard like :

```
sudo dd if=tmp/deploy/images/libretech-cc/core-image-sato-libretech-cc.sdcard of=/dev/mmcblk0
```
