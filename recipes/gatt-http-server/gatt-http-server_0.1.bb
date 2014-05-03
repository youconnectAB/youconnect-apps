PR = "r1"
LICENSE = "CLOSED"

DEPENDS = "json-c fastcgi libevent"
RDEPENDS = "lighttpd-module-fastcgi"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"
SRC_URI = "\
	git://git@github.com/youconnectAB/gatt-http-server.git;protocol=ssh \
	file://80-gatt-server.conf \
	"

inherit autotools

do_install_append() {
        install -d ${D}${sysconfdir}/lighttpd/conf.d
        install -m 644 ${WORKDIR}/80-gatt-server.conf ${D}${sysconfdir}/lighttpd/conf.d
}
