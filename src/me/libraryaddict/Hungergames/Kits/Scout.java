package me.libraryaddict.Hungergames.Kits;

import me.libraryaddict.Hungergames.Hungergames;
import me.libraryaddict.Hungergames.Managers.KitManager;
import me.libraryaddict.Hungergames.Types.HungergamesApi;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class Scout implements Listener {

    private KitManager kits = HungergamesApi.getKitManager();
    private Hungergames hg = HungergamesApi.getHungergames();

    public Scout() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(hg, new Runnable() {
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers())
                    if (kits.hasAbility(p, "Scout"))
                        kits.addItem(p, new ItemStack(Material.POTION, 2, (short) 16418));
            }
        }, 10 * 60 * 20, 10 * 60 * 20);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getCause() == DamageCause.FALL && event.getEntity() instanceof Player
                && kits.hasAbility((Player) event.getEntity(), "Scout")
                && ((Player) event.getEntity()).hasPotionEffect(PotionEffectType.SPEED))
            event.setCancelled(true);
    }
}
