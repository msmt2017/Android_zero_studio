@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
  includeBuild("build-logic")
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    
    maven {
        url = uri("https://maven.fabric.io/public")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/google")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/gradle-plugin")
    }
    maven {
        url = uri("https://dl.bintray.com/ppartisan/maven")
    }
    maven {
        url = uri("https://clojars.org/repo")
    }
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        url = uri("https://repository.jboss.org/nexus/content/repositories/releases")
        // JBoss 官方仓库，用于 Hibernate/Undertow 等框架[3,9](@ref)
    }
    maven {
        url = uri("https://repo.spring.io/milestone")
        // Spring 里程碑版本仓库（稳定版用 release 仓库）[3,6](@ref)
    }
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        // Sonatype 快照仓库，用于获取开发中的库（如某些开源项目）[5,7](@ref)
    }
    maven {
        url = uri("https://plugins.gradle.org/m2")
        // Gradle 官方插件仓库（补充 Gradle 生态工具链）[3](@ref)
    }
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
        // JetBrains Kotlin 扩展库仓库[10](@ref)
    }
    
  }
}

buildscript {
  repositories {
    mavenCentral()
    
    maven {
        url = uri("https://maven.fabric.io/public")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/google")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/gradle-plugin")
    }
    maven {
        url = uri("https://dl.bintray.com/ppartisan/maven")
    }
    maven {
        url = uri("https://clojars.org/repo")
    }
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        url = uri("https://repository.jboss.org/nexus/content/repositories/releases")
        // JBoss 官方仓库，用于 Hibernate/Undertow 等框架[3,9](@ref)
    }
    maven {
        url = uri("https://repo.spring.io/milestone")
        // Spring 里程碑版本仓库（稳定版用 release 仓库）[3,6](@ref)
    }
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        // Sonatype 快照仓库，用于获取开发中的库（如某些开源项目）[5,7](@ref)
    }
    maven {
        url = uri("https://plugins.gradle.org/m2")
        // Gradle 官方插件仓库（补充 Gradle 生态工具链）[3](@ref)
    }
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
        // JetBrains Kotlin 扩展库仓库[10](@ref)
    }
    
  }
  dependencies {
    classpath("com.mooltiverse.oss.nyx:gradle:2.5.1")
  }
}

FDroidConfig.load(rootDir)

if (FDroidConfig.hasRead && FDroidConfig.isFDroidBuild) {
  gradle.rootProject {
    // val regex = Regex("^v\\d+\\.?\\d+\\.?\\d+-\\w+")
val regex = Regex("^v\\d+(\\.\\d+)*") 
    val simpleVersion = regex.find(FDroidConfig.fDroidVersionName!!)?.value
      ?: throw IllegalArgumentException("Invalid version '${FDroidConfig.fDroidVersionName}. Version name must have semantic version format.'")

    project.setProperty("version", simpleVersion)
  }
} else {
  apply {
    plugin("com.mooltiverse.oss.nyx")
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://s01.oss.sonatype.org/content/groups/public") }
    maven { url = uri("https://jitpack.io") }
    
    maven {
        url = uri("https://maven.fabric.io/public")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/google")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/gradle-plugin")
    }
    maven {
        url = uri("https://dl.bintray.com/ppartisan/maven")
    }
    maven {
        url = uri("https://clojars.org/repo")
    }
    
    maven {
        url = uri("https://repository.jboss.org/nexus/content/repositories/releases")
        // JBoss 官方仓库，用于 Hibernate/Undertow 等框架[3,9](@ref)
    }
    maven {
        url = uri("https://repo.spring.io/milestone")
        // Spring 里程碑版本仓库（稳定版用 release 仓库）[3,6](@ref)
    }
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        // Sonatype 快照仓库，用于获取开发中的库（如某些开源项目）[5,7](@ref)
    }
    maven {
        url = uri("https://plugins.gradle.org/m2")
        // Gradle 官方插件仓库（补充 Gradle 生态工具链）[3](@ref)
    }
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
        // JetBrains Kotlin 扩展库仓库[10](@ref)
    }
    
  }
}

rootProject.name = "AndroidIDE"

include(

  ":termux:xh_lib",
  ":termux:z_file",
  ":termux:zxing",
  ":termux:qrcodecore",
    ":termux:FHttpServer",

  ":annotation-processors",
  ":annotation-processors-ksp",
  ":annotations",
  ":actions",
  ":app",
  ":build-info",
  ":common",
  ":editor",
  ":editor-api",
  ":editor-treesitter",
  ":eventbus",
  ":eventbus-android",
  ":eventbus-events",
  ":gradle-plugin",
  ":gradle-plugin-config",
  ":idestats",
  ":lexers",
  ":logger",
  ":logsender",
  ":logsender-sample",
  ":lookup",
  ":preferences",
  ":resources",
  ":shared",
  ":templates-api",
  ":templates-impl",
  ":treeview",
  ":uidesigner",
  ":xml-inflater",
  ":lsp:api",
  ":lsp:models",
  ":lsp:java",
  ":lsp:xml",
  ":subprojects:aaptcompiler",
  ":subprojects:appintro",
  ":subprojects:builder-model-impl",
  ":subprojects:flashbar",
  ":subprojects:framework-stubs",
  ":subprojects:fuzzysearch",
  ":subprojects:google-java-format",
  ":subprojects:java-compiler",
  ":subprojects:javac",
  ":subprojects:javac-services",
  ":subprojects:javapoet",
  ":subprojects:jaxp",
  ":subprojects:jdk-compiler",
  ":subprojects:jdk-jdeps",
  ":subprojects:jdt",
  ":subprojects:layoutlib-api",
  ":subprojects:projects",
  ":subprojects:tooling-api",
  ":subprojects:tooling-api-events",
  ":subprojects:tooling-api-impl",
  ":subprojects:tooling-api-model",
  ":subprojects:xml-dom",
  ":subprojects:xml-utils",
  ":termux:termux-app",
  ":termux:termux-emulator",
  ":termux:termux-shared",
  ":termux:termux-view",
  //  ":termux:termux-androidx",
  ":testing:android",
  ":testing:lsp",
  ":testing:tooling",
  ":testing:unit",
)

object FDroidConfig {

  var hasRead: Boolean = false
    private set

  var isFDroidBuild: Boolean = false
    private set

  var fDroidVersionName: String? = null
    private set

  var fDroidVersionCode: Int? = null
    private set

  const val PROP_FDROID_BUILD = "ide.build.fdroid"
  const val PROP_FDROID_BUILD_VERSION = "ide.build.fdroid.version"
  const val PROP_FDROID_BUILD_VERCODE = "ide.build.fdroid.vercode"

  fun load(rootDir: File) {
    val propsFile = File(rootDir, "fdroid.properties")
    if (!propsFile.exists() || !propsFile.isFile) {
      hasRead = true
      isFDroidBuild = false
      return
    }

    val properties = propsFile.let { props ->
      java.util.Properties().also {
        it.load(props.reader())
      }
    }

    hasRead = true
    isFDroidBuild = properties.getProperty(PROP_FDROID_BUILD, null).toBoolean()

    fDroidVersionName = properties.getProperty(PROP_FDROID_BUILD_VERSION, null)
    fDroidVersionCode =  properties.getProperty(PROP_FDROID_BUILD_VERCODE, null)?.toInt()
  }
}