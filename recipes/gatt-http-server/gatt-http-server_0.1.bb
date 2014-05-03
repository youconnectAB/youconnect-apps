PR = "r1"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

DEPENDS = "json-c fastcgi libevent"
RDEPENDS = "lighttpd-module-fastcgi"

S = "${WORKDIR}"
SRCREV = "${AUTOREV}"
SRC_URI = "\
	file://Makefile.am \
	file://configure.ac \
	file://COPYING \
	file://src/Makefile.am \
	file://src/gatt_server.c \
	file://src/gatt_bridge.c \
	file://src/gatt_bridge.h \
	file://src/gatt_communicator.c \
	file://src/gatt_communicator.h \
	file://src/debug.h \
	file://src/debug.c \
	file://m4/ax_lib_event.m4 \
	file://m4/libtool.m4 \
	file://m4/lt~obsolete.m4 \
	file://m4/ltoptions.m4 \
	file://m4/ltsugar.m4 \
	file://m4/ltversion.m4 \
	file://90-gatt-http-server.conf \
	"

inherit autotools

do_install_append() {
        install -d ${D}${sysconfdir}/lighttpd/conf.d
        install -m 644 ${WORKDIR}/90-gatt-http-server.conf ${D}${sysconfdir}/lighttpd/conf.d
}
