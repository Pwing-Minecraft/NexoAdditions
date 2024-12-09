package me.finder17.nexoadditions.elements.effects.aura.aura;

import org.bukkit.entity.Player;
import me.finder17.nexoadditions.elements.effects.aura.AuraMechanic;

public class SimpleAura extends Aura {
    public SimpleAura(AuraMechanic mechanic) {
        super(mechanic);
    }

    @Override
    protected void spawnParticles(Player player) {
        player.getWorld().spawnParticle(mechanic.particle, player.getLocation().add(0, 1, 0), 2);
    }

    @Override
    protected long getDelay() {
        return 15L;
    }
}