FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

KBUILD_DEFCONFIG:raspberrypi5_study ?= "bcm2712_defconfig"

SRC_URI:append = " file://enable_spidev.cfg"
