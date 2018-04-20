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

This layer aimes to support all mainlime supported boards, but some
of them have a vendor U-Boot loaded on the eMMC and can only be booted
by pressing the "update" button.

The libretech-cc, hardkernel-odroidc2, amlogic-p212 and khadas-vim are fully mainline sdcard
images, with mainline U-Boot and mainline Linux with a single ext4
partition. To boot this image the eMMC u-boot must be disables by erasing
the first sectors of the eMMC or removing it for libretech-cc and hardkernel-odroidc2.

Available S805 machines are :
 - hardkernel-odroidc1 : .wic image to be booted using vendor u-boot
 - amlogic-s805 (all S805 machines) : generic non-bootable .wic image to be customized

Available S905 machines are :
 - amlogic-p200 : .wic image to be booted using vendor u-boot
 - amlogic-p201 : .wic image to be booted using vendor u-boot
 - hardkernel-odroidc2 : complete sdcard image with mainline U-boot
 - hardkernel-odroidc2-sdboot : .wic image to be booted using vendor u-boot
 - tronsmart-vega-s95-pro : .wic image to be booted using vendor u-boot
 - tronsmart-vega-s95-meta : .wic image to be booted using vendor u-boot
 - tronsmart-vega-s95-telos : .wic image to be booted using vendor u-boot
 - nexbox-a95x-s905 : .wic image to be booted using vendor u-boot
 - wetek-hub : .wic image to be booted using vendor u-boot
 - wetek-play2 : .wic image to be booted using vendor u-boot
 - amlogic-s905 (all S905 machines) : generic non-bootable .wic image to be customized

Available S905D machines are :
 - amlogic-p230 : .wic image to be booted using vendor u-boot
 - amlogic-p231 : .wic image to be booted using vendor u-boot
 - amlogic-s905d (all S905D machines) : generic non-bootable .wic image to be customized

Available S905X machines are :
 - libretech-cc : complete bootable sdcard image with mainline U-boot
 - libretech-cc-sdboot : .wic image to be booted using vendor u-boot
 - amlogic-p212 : complete bootable sdcard image with mainline U-boot
 - amlogic-p212-sdboot : .wic image to be booted using vendor u-boot
 - nexbox-a95x-s905x : .wic image to be booted using vendor u-boot
 - khadas-vim : complete bootable sdcard image with mainline U-boot
 - khadas-vim-sdboot : .wic image to be booted using vendor u-boot
 - hwacom-amazetv : .wic image to be booted using vendor u-boot
 - amlogic-s905x (all S905X machines) : generic non-bootable .wic image to be customized

Available S912 machines are :
 - amlogic-q200 : .wic image to be booted using vendor u-boot
 - amlogic-q201 : .wic image to be booted using vendor u-boot
 - nexbox-a1 : .wic image to be booted using vendor u-boot
 - khadas-vim2 : .wic image to be booted using vendor u-boot
 - amlogic-s912 (all S912 machines) : generic non-bootable .wic image to be customized

Available S9xxx machines are :
 - amlogic-s9xxx (all S905 and S905X and S912 machines) : generic non-bootable .wic image to be customized

## Selecting Image type

Images types available (in addition of standard Poky/OE images) :
 - amlogic-image-headless-sd : to flash on an eMMC or SD-Card
 - amlogic-image-headless-initrd : to load as ramdisk
 - amlogic-image-sato : Graphical images with X11 and Sato environment to flash on an eMMC or SD-Card

Standard types are :
- core-image-base : Basic console image with boot logo

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
