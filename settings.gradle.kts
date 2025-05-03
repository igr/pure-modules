plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "pm"

include("library:domain")
include("library:app:mem")

include("messenger:domain")
include("messenger:app:cli")
include("messenger:app:http")
include("messenger:service")

include("app:local")
include("boot:local")