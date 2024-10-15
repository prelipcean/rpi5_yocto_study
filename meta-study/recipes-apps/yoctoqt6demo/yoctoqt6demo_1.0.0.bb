SUMMARY = "A recipe to demonstrate how to integrate Qt6 applications \
using Yocto Project"
LICENSE = "CLOSED"

DEPENDS:append = " cmake qtbase qtdeclarative qtshadertools qtshadertools-native qtdeclarative-native qtsvg"
RDEPENDS:${PN}:append = " qtbase qtdeclarative qtshadertools qtsvg"

SRC_URI:append = " file://yoctoqt6demo"

S = "${WORKDIR}/yoctoqt6demo"

EXTRA_OECMAKE:append = " \
  --debug-find-pkg=Qt6Quick \
  -DQT_DEBUG_FIND_PACKAGE=ON \
"

inherit pkgconfig qt6-cmake