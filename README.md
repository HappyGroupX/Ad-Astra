# Ad Astra
## How to fix
See more information **-->** [**Here**](https://github.com/shedaniel/REIPluginCompatibilities-Issues/issues/23)
## How to use as lib
To add this library to your project, do the following:

Kotlin DSL:
```kotlin
repositories {
    maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
}

dependencies {
    "modImplementation"(group = "earth.terrarium.adastra", name = "adastra-$modLoader-$minecraftVersion", version = adAstraVersion)
}
```

Groovy DSL:
```groovy
repositories {
    maven {
        url "https://maven.teamresourceful.com/repository/maven-public/"
    }
}

dependencies {
    "modImplementation" group: "earth.terrarium.adastra", name: "adastra-$modLoader-$minecraftVersion", version: adAstraVersion
}
```
