SUMMARY = "A recipe to demonstrate how to integrate Qt6 applications \
using Yocto Project"
LICENSE = "CLOSED"

DEPENDS:append = " cmake qtbase qtdeclarative"
RDEPENDS:${PN}:append = " qtbase qtdeclarative"

#SRC_URI:append = " file://yoctoqt6demo"

S = "${WORKDIR}/yoctoqt6demo"

inherit pkgconfig qt6-cmake

EXTRA_OECMAKE:append = " \
   --debug-find-pkg=Qt6Quick \
"