# JDAJavaPlugin [![](https://jitpack.io/v/Akadeax/JDASpigotPlugin.svg)](https://jitpack.io/#Akadeax/JDASpigotPlugin)

A spigot plugin wrapper around [JDA](https://awesomeopensource.com/project/DV8FromTheWorld/JDA), allowing a server to run the defined plugin and a discord bot a the same time, allowing interaction between the two.

## How do I use it?
add this to your pom.xml:
```xml
...
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
...
<dependency>
    <groupId>com.github.Akadeax</groupId>
    <artifactId>JDASpigotPlugin</artifactId>
    <version>73f76f4556</version>
</dependency>
...
```
and just make your plugin extend `JDASpigotPlugin` instead of `JavaPlugin`. Done!

Ex.:

```java
public final class JDASpigotExample extends JDASpigotPlugin {

    @Override
    protected String getToken() {
        return "DISCORD BOT TOKEN";
    }

    @Override
    protected void enable(PluginManager pm) {
        ...
    }

    @Override
    public void onDisable() {
        ...
    }

    public JDA jda() {
        return getJda();
    }
}

```
