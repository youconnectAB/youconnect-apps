PR = "r1"
LICENSE = "CLOSED"

DEPENDS = "btd dbus-cplusplus-native dbus-cplusplus json-c fastcgi libevent"
RDEPENDS = "dbus-cplusplus btd lighttpd-module-fastcgi"

EXTRA_OECONF += "XMLDIR=${STAGING_DATADIR}/btd/"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"
SRC_URI = "\
	git:///opt/workdir/youconnect/gatt-http-server \
	file://80-gatt-server.conf \
	"

inherit autotools

do_install_append() {
        install -d ${D}${sysconfdir}/lighttpd/conf.d
        install -m 644 ${WORKDIR}/80-gatt-server.conf ${D}${sysconfdir}/lighttpd/conf.d
}
