plugins {
    distribution
    alias(libs.plugins.protobuf)
}

dependencies {
    api(project(":application"))
    api(rootProject.libs.kotlinx.coroutines.core)

    api(rootProject.libs.grpc.stub)
    api(rootProject.libs.grpc.netty)
    api(rootProject.libs.grpc.protobuf)
    api(rootProject.libs.protobuf.java.util)
    api(rootProject.libs.protobuf.kotlin)
    api(rootProject.libs.grpc.kotlin.stub)
}

protobuf {
    protoc {
        artifact = libs.protoc.asProvider().get().toString()
    }
    plugins {
        create("grpc") {
            artifact = libs.protoc.gen.grpc.java.get().toString()
        }
        create("grpckt") {
            artifact = libs.protoc.gen.grpc.kotlin.get().toString() + ":jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
                create("grpckt")
            }
            it.builtins {
                create("kotlin")
            }
        }
    }
}
