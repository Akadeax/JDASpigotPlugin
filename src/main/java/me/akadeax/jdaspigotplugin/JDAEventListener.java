package me.akadeax.jdaspigotplugin;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;

import javax.annotation.Nonnull;

public abstract class JDAEventListener<T extends GenericEvent> implements EventListener {

    Class<T> type;
    public JDAEventListener(Class<T> type) {
        this.type = type;
    }

    @Override
    public final void onEvent(@Nonnull GenericEvent event) {
        if(type.isInstance(event)) {
            on((T)event);
        }
    }

    public abstract void on(T event);

}
