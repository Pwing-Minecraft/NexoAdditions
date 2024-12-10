package me.finder17.nexoadditions;

import java.io.IOException;
import com.nexomc.nexo.config.*

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import javax.annotation.Nullable;

public class NexoAdditions extends JavaPlugin {


    private static NexoAdditions instance;

    @Nullable
    public static NexoAdditions getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        long start = System.currentTimeMillis();
        final PluginManager manager = this.getServer().getPluginManager();

        final Plugin nexo = manager.getPlugin("Nexo");
        if (nexo == null || !nexo.isEnabled()) {
            getLogger().severe("Could not find Nexo! Disabling...");
            manager.disablePlugin(this);
            return;
        }

    }


}
