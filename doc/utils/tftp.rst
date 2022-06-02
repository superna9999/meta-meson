=========================================
Trivial File Transfer Protocol short tftp
=========================================

The `Trivial File Transfer Protocol <https://en.wikipedia.org/wiki/Trivial_File_Transfer_Protocol/>`_ is commonly used in booting from network. There is ``tftp`` support available in U-Boot, but it needs to be configured by the vendor.
One of the biggest advantages of tftp over for example loading the image from an SD-Card or an attached USB thumb drive is the fact that we do not have to unplug, copy, unmount and re plug the memory device each time we are testing a new kernel, device tree or image. This may also be used in combination with NFS booting.

-------------------------------
Shipping tftp in a Container
-------------------------------

Due to the fact ``tftp`` is quite simple from an implementation point of view it is ideal for running in a container. This just needs two files and a working Docker runtime.

Dockerfile:

.. code-block:: dockerfile

    FROM alpine:latest
    RUN apk add --update --no-cache \
        tftp-hpa
    EXPOSE 69/udp
    ENTRYPOINT ["in.tftpd"]
    CMD ["-L", "--secure", "/var/tftpboot"]


docker-compose.yml:

.. code-block:: yaml

    version: '2'

    services:
      server:
        build: .
        ports:
          - "69:69/udp"
        volumes:
          - /var/docker-volumes/tftpboot:/var/tftpboot:ro
        restart: unless-stopped


This will expose the content of ``/var/docker-volumes/tftpboot`` via ``tftp``. In case you do prefer a different location adjust it accordingly.

To build and run the ``tftp`` service execute the following commands in the directory containing the ``Dockerfile`` and ``docker-compose.yml``::

    $ sudo mkdir -p /var/docker-volumes/tftpboot
    $ sudo chown -R $(id -u):$(id -g) -R /var/docker-volumes/tftpboot
    $ docker-compose up --build

After the initial set-up you can start the service by running this command in the directory containing the ``Dockerfile`` and ``docker-compose.yml``::

    $ docker-compose up

-----------------------------------------
Direct installation of tftp on the host
-----------------------------------------

Please check your Linux distribution for instructions how to install the ``tftp`` service.

--------------------------
Using tftp on the Target
--------------------------

As already mentioned ``tftp`` support needs to be enabled in U-Boot. Due to the fact ``tftp`` is network based it also requires wired Ethernet support for your board. This will not work over a wireless connection.
In U-Boot two variables need to be defined::

    g12a_u212_v1# setenv ipaddr 192.168.0.69
    g12a_u212_v1# setenv serverip 192.168.0.1

You may want to safe those settings to not having to enter them every time you use ``tftp``::

    g12a_u212_v1#saveenv
    Saving Environment to aml-storage...
    mmc env offset: 0x4d400000
    Writing to MMC(1)... done
    g12a_u212_v1#

To transfer any file from the hosts ``tftp`` directory use the U-Boot ``tftp`` command.::

    g12a_u212_v1#tftp ${dtb_mem_addr} meson-sm1-x96-max.dtb
    Speed: 1000, full duplex
    Using dwmac.ff3f0000 device
    TFTP from server 192.168.0.1; our IP address is 192.168.0.69
    Filename 'meson-sm1-x96-max.dtb'.
    Load address: 0x1000000
    Loading: ####
             8.9 MiB/s
    done
    Bytes transferred = 46443 (b56b hex)

