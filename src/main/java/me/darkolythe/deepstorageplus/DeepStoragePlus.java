package me.darkolythe.deepstorageplus;

import me.darkolythe.customrecipeapi.APIManager;
import me.darkolythe.customrecipeapi.CustomRecipeAPI;
import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeepStoragePlus extends JavaPlugin {

    private static DeepStoragePlus plugin;

    public static String prefix = ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "[" + ChatColor.BLUE.toString() + "DeepStorage" + ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "] ";
    public static String DSUname = ChatColor.BLUE.toString() + ChatColor.BOLD.toString() + "Deep Storage Unit";

    private InventoryListener inventorylistener;
    private ChestListener chestlistener;
    private RecipeManager recipemanager;
    public APIManager crapimanager;

    @Override
    public void onEnable() {
        plugin = this;

        inventorylistener = new InventoryListener(plugin);
        chestlistener = new ChestListener(plugin);
        recipemanager = new RecipeManager(plugin);
        crapimanager = CustomRecipeAPI.getManager();

        getServer().getPluginManager().registerEvents(inventorylistener, plugin);
        getServer().getPluginManager().registerEvents(chestlistener, plugin);

        getCommand("deepstorageplus").setExecutor(new CommandHandler());

        Metrics metrics = new Metrics(plugin);

        System.out.println(prefix + ChatColor.GREEN + "DeepStoragePlus enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DeepStoragePlus getInstance() {
        return plugin;
    }
}
