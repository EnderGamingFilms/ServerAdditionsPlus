package me.endergaming.plugins;

import me.endergaming.enderlibs.text.MessageUtils;
import me.endergaming.plugins.addons.konquest.KQManager;
import me.endergaming.plugins.addons.skills.SkillsManager;
import me.endergaming.plugins.commands.CommandRegistry;
import me.endergaming.plugins.backend.AddonManager;
import me.endergaming.plugins.addons.cmi.CMIManager;
import me.endergaming.plugins.addons.levelledmobs.LMManager;
import me.endergaming.plugins.addons.lunarclient.LCManager;
import me.endergaming.plugins.addons.moneyfrommobs.MFMManager;
import me.endergaming.plugins.addons.papi.PlaceholderManager;
import me.endergaming.plugins.controllers.ConfigController;
import me.endergaming.plugins.misc.Globals;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static me.endergaming.enderlibs.text.MessageUtils.LogLevel.WARNING;
import static me.endergaming.plugins.controllers.ConfigController.*;

public final class ServerAdditionsPlus extends JavaPlugin {
    private final ConfigController configController = new ConfigController();
    private final CommandRegistry commandRegistry = new CommandRegistry(this);

    public static final long FIVE_MINUTES_IN_TICKS = 6000;
    public static NamespacedKey KEY;

    @Override
    public void onEnable() {
        // Plugin startup logic
        KEY = new NamespacedKey(this, "solaris-additions");
        this.configController.init();
        // Register Commands
        this.commandRegistry.register();
        // Create & Register AddonManager
        this.registerManagers();
    }

    private void registerManagers() {
        if (LUNAR_CLIENT) {
            new LCManager(this, Globals.Plugins.LUNAR_CLIENT, Globals.Addons.CMIManager.name);
        }

        if (MONEY_FROM_MOBS) {
            new MFMManager(this, Globals.Plugins.MONEY_FROM_MOBS);
        }

        if (CMI) {
            new CMIManager(this, Globals.Plugins.CMI);
        }

        if (PLACEHOLDER_API) {
            new PlaceholderManager(this, Globals.Plugins.PLACEHOLDER_API);
        }

        if (SKILLS) {
            new SkillsManager(this, Globals.Plugins.AURELIUM_SKILLS, Globals.Addons.LMManager.name);
        }

        if (LEVELLED_MOBS) {
            new LMManager(this, Globals.Plugins.LEVELLED_MOBS);
        }

        if (KONQUEST) {
            new KQManager(this, Globals.Plugins.KONQUEST);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        AddonManager.unregisterAll();
    }

    /**
     * Used to send messages to console with "Debug" prefix.
     * <br /><br />
     * <b>Messages will only be shown when debug mode is enabled.</b>
     */
    public static void debug(String msg) {
        if (DEBUG) {
            MessageUtils.log(WARNING, msg, "DEBUG@ServerAdditionsPlus");
        }
    }

    public static boolean isEnabled(@NotNull final String plugin) {
        return Bukkit.getPluginManager().isPluginEnabled(plugin);
    }
}
