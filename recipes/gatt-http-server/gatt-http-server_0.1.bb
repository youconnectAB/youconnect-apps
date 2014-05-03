PR = "r1"
LICENSE = "CLOSED"

DEPENDS = "json-c fastcgi libevent"
RDEPENDS = "lighttpd-module-fastcgi"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"
SRC_URI = "git://git@github.com/youconnectAB/gatt-http-server.git;protocol=ssh"

inherit autotools
