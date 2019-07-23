#!/bin/bash

set -ex

if [ -z "$1" ] ; then
	echo "Usage: $0 <path to base build path> [bitbake cmd]"
	exit 1
fi

BITBAKE_CMD="$2"
if [ -z "$BITBAKE_CMD" ] ; then
	BITBAKE_CMD="core-image-base"
fi

(
    cd $1

    PATH="/usr/sbin:/usr/bin:/sbin:/bin" source ./oe-init-build-env

    echo "BBLAYERS +=\"$1/meta-meson\"" >> conf/bblayers.conf
    echo "DISTRO_FEATURES_append = \" wayland opengl \"" >> conf/local.conf

    for machine in meta-meson/conf/machine/*.conf ; do
        echo "Running '$BITBAKE_CMD' for '$name'"
	    name="$(basename $machine | cut -d. -f1)"
	    MACHINE="$name" bitbake $BITBAKE_CMD
    done
)