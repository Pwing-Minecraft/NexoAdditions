package me.finder17.nexoadditions.elements.effects.aura;

import com.nexomc.nexo.mechanics.Mechanic;
import com.nexomc.nexo.mechanics.MechanicFactory;
import me.finder17.nexoadditions.elements.effects.aura.aura.Aura;
import me.finder17.nexoadditions.elements.effects.aura.aura.HelixAura;
import me.finder17.nexoadditions.elements.effects.aura.aura.RingAura;
import me.finder17.nexoadditions.elements.effects.aura.aura.SimpleAura;
import org.bukkit.Particle;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class AuraMechanic extends Mechanic {

    public final Set<Player> players;
    public final Particle particle;
    private final Aura aura;

    public AuraMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
        super(mechanicFactory, section);
        particle = Particle.valueOf(section.getString("particle"));
        switch (section.getString("type")) {
            case "simple" -> aura = new SimpleAura(this);
            case "ring" -> aura = new RingAura(this);
            case "helix" -> aura = new HelixAura(this);
            default -> aura = null;
        }
        players = new HashSet<>();
    }

    public void add(Player player) {
        players.add(player);
        if (players.size() == 1)
            aura.start();
    }

    public void remove(Player player) {
        players.remove(player);
        if (players.isEmpty())
            aura.stop();
    }

}