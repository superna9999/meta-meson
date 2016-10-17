Upstream Linux Amlogic Meson Yocto/Openembedded Layer
#####################################################

Now Amlogic SoCs of the Meson family are supported upstream :
 - Meson8b : s805
 - Meson-GX : s905 (GXBB)

This Yocto/Openembedded will help building images for these SoCs using the lastest uptream linux branch.

Build Setup
###########

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

Selecting Machine to build for
################################

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
 - amlogic-s905 (all S905 machines)

Selecting Image type
####################

Images types available (in addition of standard Poky/OE images) :
 - amlogic-image-sd : to flash on an eMMC or SD-Card
 - amlogic-image-initrd : to load as ramdisk

Building example
################

Building SD image for all S905 machines :
```
amlogic-bsp/build$ export MACHINE=amlogic-s905
amlogic-bsp/build$ bitbake amlogic-image-sd
```

Flashable image will be in :
```
build/tmp/deploy/images/amlogic-s905
```
