package me.finder17.nexoadditions.elements.effects.hat;

import com.nexomc.nexo.NexoPlugin;
import com.nexomc.nexo.mechanics.MechanicFactory;
import com.nexomc.nexo.mechanics.MechanicsManager;
import com.nexomc.nexo.utils.VersionUtil;
import com.nexomc.nexo.utils.logs.Logs;
import org.bukkit.configuration.ConfigurationSection;

@Deprecated(since = "1.21.2")
public class HatMechanicFactory extends MechanicFactory {

    private static HatMechanicFactory instance;

    public HatMechanicFactory(ConfigurationSection section) {
        super(section);
        MechanicsManager.registerListeners(NexoPlugin.get(), getMechanicID(), new HatMechanicListener(this));
        instance = this;
    }

    @Override
    public Mechanic parse(ConfigurationSection itemMechanicConfiguration) {
        Mechanic mechanic = new HatMechanic(this, itemMechanicConfiguration);

        if (VersionUtil.atOrAbove("1.21.2")) {
            Logs.logWarning(mechanic.getItemID() + " is using deprecated Hat-Mechanic...");
            Logs.logWarning("It is heavily advised to swap to the new `equippable`-component on 1.21.2+ servers...");
        }

        addToImplemented(mechanic);
        return mechanic;
    }

    public static HatMechanicFactory get() {
        return instance;
    }

}