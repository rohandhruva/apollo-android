import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("multiplatform")
  id("com.apollographql.apollo")
}

group = "com.apollographql.apollo.kmpsample"
version = 1.0

kotlin {
  jvm()

  val buildForDevice = project.findProperty("device") as? Boolean ?: false
  val iosTarget = if (buildForDevice) iosArm64("ios") else iosX64("ios")
  iosTarget.binaries {
    framework {
      // Disable bitcode embedding for the simulator build.
      if (!buildForDevice) {
        embedBitcode("disable")
      }

      freeCompilerArgs = freeCompilerArgs + "-Xobjc-generics"
    }
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation("com.apollographql.apollo:apollo-api")
        implementation("com.apollographql.apollo:apollo-runtime-kotlin")
        implementation(groovy.util.Eval.x(project, "x.dep.kotlin.coroutines"))
      }
    }
    val jvmMain by getting {
      dependencies {
      }
    }
    val iosMain by getting {
      dependencies {
      }
    }
    commonTest {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}

tasks.register("copyFramework", Sync::class) {
  val targetDir = File(buildDir, "xcode-frameworks")
  val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
  val framework = kotlin.targets
      .getByName<KotlinNativeTarget>("ios")
      .binaries.getFramework(mode)

  inputs.property("mode", mode)
  dependsOn(framework.linkTask)

  from({ framework.outputDirectory })
  into(targetDir)

  doLast {
    val gradlew = File(targetDir, "gradlew")
    gradlew.writeText("#!/bin/bash\n"
        + "export 'JAVA_HOME=${System.getProperty("java.home")}'\n"
        + "cd '${rootProject.rootDir}'\n"
        + "./gradlew \$@ --no-configure-on-demand\n")
    gradlew.setExecutable(true)
  }
}

apollo {
  service("github") {
    sourceFolder.set("com/apollographql/apollo/kmpsample")
    rootPackageName.set("com.apollographql.apollo.kmpsample")
  }
  service("rocketreserver") {
    sourceFolder.set("com/apollographql/apollo/rocketreserver")
    rootPackageName.set("com.apollographql.apollo.rocketreserver")
  }
}