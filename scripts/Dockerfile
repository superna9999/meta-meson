FROM ubuntu:xenial-20190720
MAINTAINER Neil Armstrong <narmstrong@baylibre.com>
LABEL Description=" This image is for building meta-meson inside a container"

# Make sure apt is happy
ENV DEBIAN_FRONTEND=noninteractive

# Update packages
RUN dpkg --add-architecture i386
RUN apt-get update -qq

# Install OE dependencies
RUN apt-get install -qq gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm python2.7 python-minimal cpio python3
    
# Install git
RUN apt-get install -qq git

# Install lavacli
RUN apt-get install -qq python3-pip
RUN pip3 install lavacli

# Add missing libz for linaro gcc
RUN apt-get install -qq zlib1g:i386

# Setup system
RUN apt-get install -qq locales
RUN locale-gen en_US.UTF-8
RUN update-locale LC_ALL=en_US.UTF-8 LANG=en_US.UTF-8

# Use en_US.UTF-8 locale
ENV LANG=en_US.UTF-8

# Add and use the yocto user
RUN useradd -c 'yocto user' -m -d /home/yocto -s /bin/bash yocto
USER yocto
ENV HOME /home/yocto
