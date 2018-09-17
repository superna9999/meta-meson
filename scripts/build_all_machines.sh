#!/bin/bash

set -ex

if [ -z "$1" ] ; then
	echo "Usage: $0 <path to meta-meson> [bitbake command]"
	exit 1
fi

BITBAKE_CMD="$2"
if [ -z "$BITBAKE_CMD" ] ; then
	BITBAKE_CMD="core-image-base"
fi

echo "Running bitbake $BITBAKE_CMD for all meta-meson machines."

for machine in $1/conf/machine/*.conf ; do
	name="$(basename $machine | cut -d. -f1)"
	MACHINE="$name" bitbake $BITBAKE_CMD
done
