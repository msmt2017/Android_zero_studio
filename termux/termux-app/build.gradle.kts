@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

val packageVariant = System.getenv("TERMUX_PACKAGE_VARIANT") ?: "apt-android-7"

android {
    namespace = "com.termux"
   // ndkVersion = BuildConfig.ndkVersion

    defaultConfig {
        buildConfigField("String", "TERMUX_PACKAGE_VARIANT", "\"$packageVariant\"")
        manifestPlaceholders += mapOf(
            "TERMUX_PACKAGE_NAME" to BuildConfig.packageName,
            "TERMUX_APP_NAME" to "AndroidIDE",
            "TERMUX_API_APP_NAME" to "Termux:API",
            "TERMUX_BOOT_APP_NAME" to "Termux:Boot",
            "TERMUX_FLOAT_APP_NAME" to "Termux:Float",
            "TERMUX_STYLING_APP_NAME" to "Termux:Styling",
            "TERMUX_TASKER_APP_NAME" to "Termux:Tasker",
            "TERMUX_WIDGET_APP_NAME" to "Termux:Widget"
        )

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs += listOf(
            "-Xjvm-default=all"
        )
    }
    
    packaging {
        resources {
            excludes += listOf(
                "META-INF/LICENSE",
                "META-INF/DEPENDENCIES"
            )
        }
    }

    lint {
        disable += "ProtectedPermissions"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("src/main/jniLibs")
        }
    }
}

dependencies {

implementation("com.lzy.net:okgo:3.0.4")
    implementation("com.github.iielse:switchbutton:1.0.4")
    implementation("com.github.getActivity:XXPermissions:11.5")
    implementation("me.laoyuyu.aria:core:3.8.16")
    annotationProcessor("me.laoyuyu.aria:compiler:3.8.16")
    debugImplementation("com.github.getActivity:Logcat:9.6")
    implementation("me.jahnen:libaums-httpserver:0.5.3")
    implementation("me.jahnen:libaums-storageprovider:0.5.1")
    implementation("uk.co.alt236:usbdeviceenumerator:2.0.0")
    implementation("com.lcw.library:imagepicker:2.2.7")
    implementation("com.geyifeng.immersionbar:immersionbar:3.2.2")
    implementation("com.hzy:un7zip:+")
  //  implementation("me.testica:codeeditor:1.0.2")
    implementation("commons-fileupload:commons-fileupload:1.3.1")
    compileOnly("javax.servlet:servlet-api:2.5") // 替换 provided 为 compileOnly
    implementation("com.mallotec.reb:plugin-locale:1.0.12")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("cn.hotapk:fastandrutils:0.8.0") {
        exclude(group = "com.android.support")
    }
    testImplementation("junit:junit:4.13.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.21")

implementation("androidx.appcompat:appcompat:1.6.1")

    // implementation("org.nanohttpd:nanohttpd:2.3.1") {
      //  exclude(group = "conflicting-group") // 替换实际冲突的group名
  //  }

    // 修正后的codeeditor依赖
    implementation("me.testica:codeeditor:1.0.2") {
        exclude(group = "com.android.support", module = "appcompat-v7")
    }

    // Aria 下载库
// Aria (correct version format)
    // implementation ("com.github.AriaLyy:Aria:v3.8.16")
    // kapt ("com.github.AriaLyy:AriaCompiler:v3.8.16")

    // XXPermissions (uppercase and version format)
   // implementation ("com.github.hjq:XXPermissions:v18.5")

    // SwitchView 开关控件
    implementation ("com.github.zcweng:switch-button:0.0.3@aar")

    // 其他可能的 UI 库（根据错误提示补充）
    implementation ("com.github.rtugeek:ColorSeekBar:1.7.7")
    
    implementation ("com.daimajia.numberprogressbar:library:1.4@aar")
    
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation(project(":termux:z_file"))
    implementation(project(":termux:xh_lib"))
implementation(project(":termux:FHttpServer"))

    testImplementation("org.robolectric:robolectric:4.11.1")

    implementation("com.scottyab:rootbeer-lib:0.1.0")
    implementation("me.jahnen:libaums:0.8.0")
    //webview框架
    implementation ("com.just.agentweb:agentweb:4.0.2")
    implementation ("com.just.agentweb:download:4.0.2")

    implementation(libs.androidx.annotation)
    implementation(libs.androidx.core)
    implementation(libs.androidx.drawer)
    implementation(libs.androidx.preference)
    implementation(libs.androidx.viewpager)
    implementation(libs.google.material)
    implementation(libs.google.guava)
    implementation(libs.common.markwon.core)
    implementation(libs.common.markwon.extStrikethrough)
    implementation(libs.common.markwon.linkify)
    implementation(libs.common.markwon.recycler)

    implementation(projects.common)
    implementation(projects.preferences)
    implementation(projects.resources)
    implementation(projects.termux.termuxView)
    implementation(projects.termux.termuxShared)

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    testImplementation(projects.testing.unit)
}

tasks.register("versionName") {
    doLast {
        print(project.rootProject.version)
    }
}

