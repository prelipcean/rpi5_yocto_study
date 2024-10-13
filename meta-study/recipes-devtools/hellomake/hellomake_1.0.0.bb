DESCRIPTION = "Package that provides hello world \
examle written in C++ language and using GNU Make \
also git repository example"
AUTHOR = "Gheorghe Prelipcean"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/mozcelikors/makefile-example.git;protocol=https;branch=master"

SRCREV = "5fc593af10244751039f2a1163134b6b60a7df37"

# If we want last commit always we can write as below
#SRCREV = "${AUTOREV}"

# Runtime dependency list, also version can be specified after name with (>= 1.2)
RDEPENDS:${PN}:append = " bash "

# Build time dependency, e.g. libraries (libopenssl), or tools used during compilation
DEPENDS:append = " "

S = "${WORKDIR}/git"

do_compile() {
	export OECORE_TARGET_SYSROOT=${STAGING_DIR_TARGET}
	oe_runmake -C .
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/app ${D}${bindir}/app
	install -m 0755 ${S}/app ${D}${bindir}/app2
}

# Split build output into different packages
PACKAGES = "${PN} \
			${PN}-app \
			${PN}-app2 \
			${PN}-dbg \
"
FILES:${PN}:append = " ${bindir}/app "
FILES:${PN}-app:append = " ${bindir}/app "
FILES:${PN}-app2:append = " ${bindir}/app2 "
FILES:${PN}-dbg:append = " ${bindir}/.debug ${bindir}/.debug/app ${bindir}/.debug/app2 "