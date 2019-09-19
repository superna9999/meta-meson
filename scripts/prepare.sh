#!/bin/bash

set -ex

if [ "$#" -lt 1 ] ; then
	echo "Usage: $0 <path to base build path>"
	exit 1
fi

cd $1
BASEDIR=$PWD

. ./oe-init-build-env $PWD/build
    
cp $BASEDIR/meta/conf/local.conf.sample conf/local.conf
    
echo "BBLAYERS +=\"$1/meta-meson\"" >> conf/bblayers.conf
