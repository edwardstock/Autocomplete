import com.otaliastudios.tools.publisher.PublisherExtension.License
import com.otaliastudios.tools.publisher.PublisherExtension.Release

plugins {
    id("com.android.library")
    id("kotlin-android") // Just for publisher autodocs
    id("maven-publisher-bintray")
}

android {
    setCompileSdkVersion(property("compileSdkVersion") as Int)

    defaultConfig {
        setMinSdkVersion(property("minSdkVersion") as Int)
        setTargetSdkVersion(property("targetSdkVersion") as Int)
        versionName = "1.1.1"
    }

    buildTypes {
        get("release").consumerProguardFile("proguard-rules.pro")
    }
}

dependencies {
    api("androidx.recyclerview:recyclerview:1.1.0")
}

publisher {
    auth.user = "BINTRAY_USER"
    auth.key = "BINTRAY_KEY"
    auth.repo = "BINTRAY_REPO"
    project.artifact = "autocomplete"
    project.description = "Simple yet powerful autocomplete behavior for Android EditTexts, to avoid working with MultiAutoCompleteTextView APIs."
    project.group = "com.edwardstock"
    project.url = "https://github.com/edwardstock/Autocomplete"
    project.vcsUrl = "https://github.com/edwardstock/Autocomplete.git"
    project.addLicense(License.APACHE_2_0)
    release.setSources(Release.SOURCES_AUTO)
    release.setDocs(Release.DOCS_AUTO)
    release.version = "1.1.1"
}
