plugins {
    idea
}


allprojects {
    apply(plugin = "idea")

    group = "org.g"
    version = "1.0.0"

    repositories {
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        mavenCentral()
    }
}

subprojects {
}
