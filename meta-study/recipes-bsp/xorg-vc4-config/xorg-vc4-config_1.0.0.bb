SUMMARY = "Deploys x11 cofiguration"
AUTHOR = "Gheorghe Prelipcean"
LICENSE = "CLOSED"

SRC_URI:append = "file://99-vc4.conf"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/etc/X11/xorg.conf.d
	cp -r ${S}/99-vc4.conf ${D}/etc/X11/xorg.conf.d
}

FILES:${PN}:append = " /etc/X11/xorg.conf.d/99-vc4.conf "