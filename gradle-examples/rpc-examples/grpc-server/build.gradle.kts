import com.google.protobuf.gradle.id

plugins {
    application
    id("com.google.protobuf").version("0.9.3")
}

dependencies {
    implementation(libs.grpc.protobuf)
    implementation(libs.grpc.stub)
    implementation("com.google.protobuf:protobuf-java:3.23.2")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:3.23.2" }
    plugins {
        id("grpc") { artifact = "io.grpc:protoc-gen-grpc-java:1.56.0" }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc") { }
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
