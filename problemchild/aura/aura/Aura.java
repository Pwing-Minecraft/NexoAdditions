package me.finder17.nexoadditions.elements.effects.aura.aura;

import com.nexomc.nexo.NexoPlugin;
import com.nexomc.nexo.mechanics.MechanicsManager;
import me.finder17.nexoadditions.elements.effects.aura.AuraMechanic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public abstract class Aura {

    protected final AuraMechanic mechanic;
    private BukkitRunnable runnable;

    protected Aura(AuraMechanic mechanic) {
        this.mechanic = mechanic;
    }

    BukkitRunnable getRunnable() {
        return new BukkitRunnable() {
            @Override
            public void run() {
                mechanic.players.forEach(Aura.this::spawnParticles);
            }
        };
    }

    protected abstract void spawnParticles(Player player);

    protected abstract long getDelay();

    public void start() {
        runnable = getRunnable();
        BukkitTask task = runnable.runTaskTimerAsynchronously(NexoPlugin.get(), 0L, getDelay());
        MechanicsManager.registerTask(mechanic.getFactory().getMechanicID(), task);
    }

    public void stop() {
        runnable.cancel();
    }


}