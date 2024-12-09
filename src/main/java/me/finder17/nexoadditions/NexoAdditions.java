package me.finder17.nexoadditions;

import java.io.IOException;


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
        int pluginId = 21274; // todo replace this with new bstats id
        Metrics metrics = new Metrics(this, pluginId);
        instance = this;
        addon = Skript.registerAddon(this);
        addon.setLanguageFileDirectory("lang");
        try {
            addon.loadClasses("me.finder17.skriptnexo", "elements");
        } catch (IOException error) {
            error.printStackTrace();
            manager.disablePlugin(this);
            return;
        }
        long finish = System.currentTimeMillis() - start;
        getLogger().info("Succesfully loaded nexoadditons in " + finish + "ms!");

    }


}
