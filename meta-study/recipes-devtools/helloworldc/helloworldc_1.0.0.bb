DESCRIPTION = "Package that provides hello world\
examle written in C language"
AUTHOR = "Gheorghe Prelipcean"
LICENSE = "CLOSED"

SRC_URI = "file://mysource"

S = "${WORKDIR}/mysource"
B = "${WORKDIR}/mybuild"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	${CC} ${S}/helloworld.c -o ${B}/helloworld
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/helloworld ${D}${bindir}/
}