plugins{
    id("commons.android-library")
    id("kotlin-parcelize")
    kotlin("plugin.serialization") version "1.5.0"
}

android {
    namespace = "com.fitness.data"
}

dependencies {
    addRoomLib()
    addNetworkDependencies()
    addFirebaseDependencies()
    AUTHENTICATION_MANAGER
    FRAMEWORK
}