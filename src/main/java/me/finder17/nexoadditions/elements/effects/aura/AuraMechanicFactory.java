package me.finder17.nexoadditions.elements.effects.aura;

import com.nexomc.nexo.NexoPlugin;
import com.nexomc.nexo.mechanics.Mechanic;
import com.nexomc.nexo.mechanics.MechanicFactory;
import com.nexomc.nexo.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;

public class AuraMechanicFactory extends MechanicFactory {

    public AuraMechanicFactory(ConfigurationSection section) {
        super(section);
        MechanicsManager.registerListeners(NexoPlugin.get(), getMechanicID(), new AuraMechanicListener(this));
    }

    @Override
    public Mechanic parse(ConfigurationSection itemMechanicConfiguration) {
        Mechanic mechanic = new AuraMechanic(this, itemMechanicConfiguration);
        addToImplemented(mechanic);
        return mechanic;
    }

}