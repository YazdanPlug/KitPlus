package iR.YazdanKHos.KP;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.*;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase implements Listener {

    @Override
    public void onEnable(){
            this.getLogger().info(TextFormat.DARK_GREEN+"The KitPlus plugin is enabled !");
            this.getLogger().info(TextFormat.YELLOW+"Created by"+TextFormat.RED+"<| YazdanKHos |>");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player) sender;
        FormWindowSimple KitPlus = new FormWindowSimple("-={KitPlus}=-", "Please select a Kit");
        KitPlus.addButton(new ElementButton("Netherite Kit"));
        KitPlus.addButton(new ElementButton("Diamond Kit"));
        KitPlus.addButton(new ElementButton("Iron Kit"));
        KitPlus.addButton(new ElementButton("Gold Kit"));
        KitPlus.addButton(new ElementButton("Chain Kit"));
        KitPlus.addButton(new ElementButton("Leather Kit"));
        switch (cmd.getName().toLowerCase()){
            case "kit":
                if(!(sender.isPlayer())){
                    sender.sendMessage(TextFormat.DARK_RED+"You can using this command in the game !");
                    return false;
                } else if (!(p.hasPermission("kitplus.command"))){
                    p.sendMessage(TextFormat.DARK_RED+"you dont have permission for usig this command !");
                    return false;
                } else {
                    p.showFormWindow(KitPlus);
                    break;
                }
        }
        return true;
    }
    @EventHandler
    public void onResponse(PlayerFormRespondedEvent e){
        Player p = e.getPlayer();
        FormWindowSimple fw = (FormWindowSimple) e.getWindow();
        if(fw.getTitle().equals("-={KitPlus}=-")){
            if(fw.getResponse().getClickedButton().getText().equals("Netherite Kit")){
                p.getInventory().addItem(Item.get(ItemID.NETHERITE_HELMET));
                p.getInventory().addItem(Item.get(ItemID.NETHERITE_CHESTPLATE));
                p.getInventory().addItem(Item.get(ItemID.NETHERITE_LEGGINGS));
                p.getInventory().addItem(Item.get(ItemID.NETHERITE_BOOTS));
                p.getInventory().addItem(Item.get(ItemID.NETHERITE_SWORD));
            } else if(fw.getResponse().getClickedButton().getText().equals("Diamond Kit")){
                p.getInventory().addItem(Item.get(ItemID.DIAMOND_HELMET));
                p.getInventory().addItem(Item.get(ItemID.DIAMOND_CHESTPLATE));
                p.getInventory().addItem(Item.get(ItemID.DIAMOND_LEGGINGS));
                p.getInventory().addItem(Item.get(ItemID.DIAMOND_BOOTS));
                p.getInventory().addItem(Item.get(ItemID.DIAMOND_SWORD));
            } else if (fw.getResponse().getClickedButton().getText().equals("Iron Kit")){
                p.getInventory().addItem(Item.get(ItemID.IRON_HELMET));
                p.getInventory().addItem(Item.get(ItemID.IRON_CHESTPLATE));
                p.getInventory().addItem(Item.get(ItemID.IRON_LEGGINGS));
                p.getInventory().addItem(Item.get(ItemID.IRON_BOOTS));
                p.getInventory().addItem(Item.get(ItemID.IRON_SWORD));
            } else if (fw.getResponse().getClickedButton().getText().equals("Gold Kit")){
                p.getInventory().addItem(Item.get(ItemID.GOLD_HELMET));
                p.getInventory().addItem(Item.get(ItemID.GOLD_CHESTPLATE));
                p.getInventory().addItem(Item.get(ItemID.GOLD_LEGGINGS));
                p.getInventory().addItem(Item.get(ItemID.GOLD_BOOTS));
                p.getInventory().addItem(Item.get(ItemID.GOLD_SWORD));
            } else if (fw.getResponse().getClickedButton().getText().equals("Chain Kit")){
                p.getInventory().addItem(Item.get(ItemID.CHAIN_HELMET));
                p.getInventory().addItem(Item.get(ItemID.CHAIN_CHESTPLATE));
                p.getInventory().addItem(Item.get(ItemID.CHAIN_LEGGINGS));
                p.getInventory().addItem(Item.get(ItemID.CHAIN_BOOTS));
                p.getInventory().addItem(Item.get(ItemID.STONE_SWORD));
            } else if (fw.getResponse().getClickedButton().getText().equals("Leather Kit")){
                p.getInventory().addItem(Item.get(ItemID.LEATHER_CAP));
                p.getInventory().addItem(Item.get(ItemID.LEATHER_TUNIC));
                p.getInventory().addItem(Item.get(ItemID.LEATHER_PANTS));
                p.getInventory().addItem(Item.get(ItemID.LEATHER_BOOTS));
                p.getInventory().addItem(Item.get(ItemID.WOODEN_SWORD));
            }
        }
    }
}
