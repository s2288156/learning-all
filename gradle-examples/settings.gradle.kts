rootProject.name = "gradle-examples"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("grpc-protobuf", "io.grpc:grpc-protobuf:1.56.0")
            library("grpc-stub", "io.grpc:grpc-stub:1.56.0")
        }
    }
}
include("rpc-examples")
include("rpc-examples:grpc-server")
findProject(":rpc-examples:grpc-server")?.name = "grpc-server"
