package me.endergaming.plugins.misc;

import java.util.Random;

public class Globals {
    public static final String CURRENCY_1 = "MC";
    public static final String PLUGIN_KEY = "sap";

    public static final String PREFIX = "&7[&a\uD83E\uDDEA&7] ";

    public static final Random RANDOM = new Random();

    public enum Plugins {
        CMI("CMI"),
        PLACEHOLDER_API("PlaceholderAPI"),
        MCMMO("mcMMO"),
        MONEY_FROM_MOBS("MoneyFromMobs"),
        LUNAR_CLIENT("LunarClient-API"),
        LEVELLED_MOBS("LevelledMobs"),

        AURELIUM_SKILLS("AureliumSkills"),
        KONQUEST("Konquest"),
        MMOCORE("MMOCore"),
        ;

        public final String name;

        Plugins(String value) {
            this.name = value;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public enum Addons {
        CMIManager("CMIManager"),
        PlaceholderManager("PlaceholderManager"),
        SkillsManager("SkillsManager"),
        MFMManager("MFMManager"),
        LCManager("LCManager"),
        KQManager("KQManager"),
        LMManager("LMManager"),
        MMOManager("MMOManager"),
        ;

        public final String name;

        Addons(String value) {
            this.name = value;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
