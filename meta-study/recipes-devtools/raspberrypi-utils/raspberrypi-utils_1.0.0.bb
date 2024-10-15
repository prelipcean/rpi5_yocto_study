FILESEXTRAPATHS:prepend := "${THISDIR}/file2:"

SUMMARY = "Package that provides raspberrypi \
utils built with CMake"
AUTHOR = "Gheorghe Prelipcean"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/raspberrypi/utils.git;protocol=https;branch=master"
SRCREV = "371ae96ff6d8b869d4125137fdc73b86fe154245"
# If we want last commit always we can write as below
#SRCREV = "${AUTOREV}"

# Overwrrite original CMakeLists file
# SRC_URI += " file://git/CMakeLists.txt "



# Runtime dependency list, also version can be specified after name with (>= 1.2)
RDEPENDS:${PN}:append = " bash "

# Build time dependency, e.g. libraries (libopenssl), or tools used during compilation
DEPENDS:append = " "

S = "${WORKDIR}/git"

inherit cmake pkgconfig

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/pinctrl/pinctrl ${D}${bindir}/pinctrl
	install -m 0755 ${S}/raspinfo/raspinfo ${D}${bindir}/raspinfo
}
