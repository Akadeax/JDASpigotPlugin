package me.akadeax.jdaspigotplugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public abstract class JDASpigotPlugin extends JavaPlugin implements EventListener {

    private JDA jda = null;

    protected JDA getJda() {
        return jda;
    }

    protected abstract String getToken();

    // Wrappers around JDA Functions
    public void registerDiscordEvents(Object... listener) {
        jda.addEventListener(listener);
    }
    public void unregisterDiscordEvents(Object... listener) {
        jda.removeEventListener(listener);
    }

    @Override
    public final void onEnable() {
        setupConfig(getConfig());

        String token = getToken();
        try {
            jda = JDABuilder.createDefault(token)
                    .setActivity(Activity.watching("You"))
                    .addEventListeners(this)
                    .build();
        } catch (LoginException e) {
            System.out.println("Could not log into Discord!");
        }
    }

    protected abstract void enable(PluginManager pm);

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof ReadyEvent) {
            enable(getServer().getPluginManager());
        }
    }

    public void setupConfig(FileConfiguration config) { }
}
