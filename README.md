# Upstream Linux Amlogic Meson Yocto/Openembedded Layer

Now Amlogic SoCs of the Meson family are supported upstream :
 - Meson8b : s805
 - Meson-GX : s905 (GXBB) s905x/S905d (GXL) s912 (GXM)
 - Meson AXG : a113d
 - Meson G12A : S905X2, S905D2, S905Y2
 - Meson G12B : S922X, A311D
 - Meson SM1 : S905X3, S905D3

This Yocto/Openembedded will help building images for these SoCs using the lastest uptream linux branch.

## Build Setup

Create a home repository for the build :
```
$ mkdir amlogic-bsp
```

Checkout Yocto/Poky :
```
$ cd amlogic-bsp
amlogic-bsp$ git clone --depth 1 git://git.yoctoproject.org/poky -b master poky
```

Checkout meta-meson :
```
amlogic-bsp$ git clone https://github.com/superna9999/meta-meson.git meta-meson -b master
```

Initialize environment :
```
amlogic-bsp$ TEMPLATECONF=../meta-meson/conf/templates/default
amlogic-bsp$ source poky/oe-init-build-env
amlogic-bsp/build$ cp ../poky/meta-poky/conf/local.conf.sample conf/local.conf
```

or :

```
amlogic-bsp$ source poky/oe-init-build-env
amlogic-bsp/build$ bitbake-layers add-layer $PWD/../meta-meson/
```

## Selecting Machine to build for

This layer aims to support all mainline supported boards, but some
of them have a vendor U-Boot loaded on the eMMC and can only be booted
by pressing the "update" button.

The libretech-cc, hardkernel-odroidc2, amlogic-p212 and khadas-vim are fully mainline sdcard
images, with mainline U-Boot and mainline Linux with a single ext4
partition. To boot this image the eMMC u-boot must be disabled by erasing
the first sectors of the eMMC or removing it for libretech-cc and hardkernel-odroidc2 boards.

Available S805 machines are :
 - hardkernel-odroidc1 : .wic image to be booted using vendor u-boot
 - amlogic-s805 (all S805 machines) : generic non-bootable .wic image to be customized

Available S905 machines are :
 - amlogic-p200 : complete .wic sdcard image with mainline U-boot
 - amlogic-p200-sdboot : .wic image to be booted using vendor u-boot
 - amlogic-p201 : complete .wic sdcard image with mainline U-boot
 - amlogic-p201-sdboot : .wic image to be booted using vendor u-boot
 - hardkernel-odroidc2 : complete .wic sdcard image with mainline U-boot
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
 - mecool-kii-pro : .wic image to be booted using vendor u-boot
 - amlogic-s905d (all S905D machines) : generic non-bootable .wic image to be customized

Available S905X machines are :
 - libretech-ac : complete bootable .wic sdcard image using already flashed u-boot on SPI
 - libretech-cc : complete bootable .wic sdcard image with mainline U-boot
 - libretech-cc-sdboot : .wic image to be booted using vendor u-boot
 - amlogic-p212 : complete bootable .wic sdcard image with mainline U-boot
 - amlogic-p212-sdboot : .wic image to be booted using vendor u-boot
 - nexbox-a95x-s905x : .wic image to be booted using vendor u-boot
 - khadas-vim : complete bootable .wic sdcard image with mainline U-boot
 - khadas-vim-sdboot : .wic image to be booted using vendor u-boot
 - hwacom-amazetv : .wic image to be booted using vendor u-boot
 - amlogic-p241: .wic image to be booted using vendor u-boot
 - amlogic-p281: .wic image to be booted using vendor u-boot
 - oranth-tx3-mini: .wic image to be booted using vendor u-boot
 - osmc-vero4k-plus .wic image to be booted using vendor u-boot
 - amlogic-s905x (all S905X machines) : generic non-bootable .wic image to be customized

Available S912 machines are :
 - amlogic-q200 : .wic image to be booted using vendor u-boot
 - amlogic-q201 : .wic image to be booted using vendor u-boot
 - nexbox-a1 : .wic image to be booted using vendor u-boot
 - khadas-vim2 : .wic image to be booted using vendor u-boot
 - mecool-kiii-pro : .wic image to be booted using vendor u-boot
 - minix-neo-u9h : .wic image to be booted using vendor u-boot
 - beelink-gt1-ultimate: complete bootable .wic sdcard image with mainline U-boot
 - amlogic-s912 (all S912 machines) : generic non-bootable .wic image to be customized

Available A113d machine :
 - amlogic-s400 : complete bootable .wic eMMC image with mainline U-boot

Available S905X2 machines are :
 - amlogic-u200: .wic image to be booted using vendor u-boot
 - amediatech-x96-max: .wic image to be booted using vendor u-boot
 - seirobotics-sei510: complete bootable .wic sdcard image with mainline U-boot

Available S905Y2 machines are :
 - radxa-zero: complete bootable .wic sdcard image with mainline U-boot

Available S922X machines are :
 - hardkernel-odroidn2: complete bootable .wic sdcard image with mainline U-boot
 - hardkernel-odroidn2-sdboot: .wic image to be booted using vendor u-boot
 - hardkernel-odroidn2plus: complete bootable .wic sdcard image with mainline U-boot
 - hardkernel-odroidn2plus-sdboot: .wic image to be booted using vendor u-boot
 - hardkernel-odroid-n2l: complete bootable .wic sdcard image with mainline U-boot

Available A311D machines are :
 - khadas-vim3 : complete bootable .wic sdcard image with mainline U-boot
 - khadas-vim3-sdboot : .wic image to be booted using vendor u-boot
 - hardkernel-odroid-go-ultra: complete bootable .wic sdcard image with mainline U-boot
 - bananapi-bpi-m2s: complete bootable .wic sdcard image with mainline U-boot
 - bananapi-bpi-cm4io: complete bootable .wic sdcard image with mainline U-boot

Available S905X3/D3 machines are :
 - khadas-vim3l : complete bootable .wic sdcard image with mainline U-boot
 - khadas-vim3l-sdboot : .wic image to be booted using vendor u-boot
 - seirobotics-sei610: complete bootable .wic sdcard image with mainline U-boot
 - hardkernel-odroidc4: complete bootable .wic sdcard image with mainline U-boot
 - hardkernel-odroidc4-sdboot: .wic image to be booted using vendor u-boot
 - hardkernel-odroidhc4: complete bootable .wic sdcard image with mainline U-boot
 - hardkernel-odroidhc4-sdboot: .wic image to be booted using vendor u-boot
 - haochuangy-h96-max: .wic image to be booted using vendor u-boot
 - cyx-a95xf3-air: .wic image to be booted using vendor u-boot
 - cyx-a95xf3-air-gbit: .wic image to be booted using vendor u-boot
 - bananapi-bpi-m5: complete bootable .wic sdcard image with mainline U-boot
 - bananapi-bpi-m2-pro: complete bootable .wic sdcard image with mainline U-boot

Available S9xxx machines are :
 - amlogic-s9xxx (all S905 and S905X and S912 machines) : generic non-bootable .wic image to be customized

## Selecting Image type

Images types available (in addition of standard Poky/OE images) :
 - amlogic-image-headless-sd : to flash on an eMMC or SD-Card
 - [amlogic-image-headless-initrd](/doc/images/amlogic-image-headless-initrd.rst) : to be loaded as a ramdisk
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

For the amlogic-p212, khadas-vim and libretech-cc, Mainline U-Boot is automatically installed in a single ext4 partition .wic image in the tmp/deploy/images/$MACHINE/ directory.

Flash the .wic file with the Etcher tool from https://etcher.io/

Or for the connoisseurs :

You will be able to dd the image onto the raw SDcard like :

```
sudo dd if=tmp/deploy/images/libretech-cc/core-image-sato-libretech-cc.wic of=/dev/mmcblk0
```

## Build with kas

The `kas` tool is installed via Python pip. The recommended way is to use an virtual environment for this.

```
$ python3 -m venv venv
$ source venv/bin/activate
$ pip3 install wheel kas
```

To start a build we just need to run the command `kas build <configuration>.yml`

```
$ source venv/bin/activate
$ DL_DIR=/data/downloads SSTATE_DIR=/data/sstate-cache kas build kas/kas-poky-meson.yml
```

The environment variable `DL_DIR` will allow to use a common place for the downloads across different projects. The same applies to the `SSTATE_DIR` variable.

To build for a specific machine use the environment variable `KAS_MACHINE`.

Please check the [kas](https://kas.readthedocs.io/en/latest/) manual for more details.
