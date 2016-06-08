package ExamplePlugin;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.plugin.PluginBase;
import net.BukkitPE.utils.Config;
import net.BukkitPE.utils.TextFormat;
import net.BukkitPE.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * author: MagicDroidX
 * NukkitExamplePlugin Project
 */
public class MainClass extends PluginBase {

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "I'm loaded!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "YAY i'm enable");

        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));

        //Register the EventListener
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

        //PluginTask
        this.getServer().getScheduler().scheduleRepeatingTask(new BroadcastPluginTask(this), 200);

        //Save resources
        this.saveResource("Message.txt");

        //Config reading and writing
        Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),
                Config.YAML,
                //Default values (not necessary)
                new LinkedHashMap<String, Object>() {
                    {
                        put("this-is-a-key", "Hello! Config!");
                        put("another-key", true); //you can also put other standard objects!
                    }
                });
        //Now try to get the value, the default value will be given if the key isn't exist!
        this.getLogger().info(String.valueOf(config.get("this-is-a-key", "this-is-default-value")));
        //Don't forget to save it!
        config.save();
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "I'm disable :(");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName()) {
            case "example":
                try {
                    this.getLogger().info(Utils.readFile(new File(this.getDataFolder(), "Message.txt")) + " " + sender.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        return true;
    }

}
