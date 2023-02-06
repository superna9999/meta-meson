#!/bin/bash

set -ex

if [ "$#" -lt 1 ] ; then
	echo "Usage: $0 <path to base build path>"
	exit 1
fi

cd $1
BASEDIR=$PWD

. ./oe-init-build-env $PWD/build
    
if [ -d $BASEDIR/meta/conf/templates/default ] ; then
	cp $BASEDIR/meta/conf/templates/default/local.conf.sample conf/local.conf
elif [ -d $BASEDIR/meta-poky/conf/templates/default ] ; then
	cp $BASEDIR/meta-poky/conf/templates/default/local.conf.sample conf/local.conf
elif [ -f $BASEDIR/meta/conf/local.conf.sample ] ; then
	cp $BASEDIR/meta/conf/local.conf.sample conf/local.conf
else
	echo "Unable to find a local.conf.sample"
	exit 1
fi
    
echo "BBLAYERS +=\"$1/meta-meson\"" >> conf/bblayers.conf
