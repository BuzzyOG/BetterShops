package me.moomaxie.BetterShops.Listeners;

import me.moomaxie.BetterShops.Configurations.GUIMessages.History;
import me.moomaxie.BetterShops.Configurations.GUIMessages.MainGUI;
import me.moomaxie.BetterShops.Shops.Shop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ***********************************************************************
 * Copyright me.moomaxie (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of me.moomaxie. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class OpenShopOptions implements Listener {


    public static void openShopOwnerOptionsInventory(Inventory inv, Player p, Shop shop, int page) {

        boolean same = true;
        if (inv == null) {
            same = false;
            inv = Bukkit.createInventory(p, 54, "§7[Shop] §a" + shop.getName());
        } else {
            inv.clear();
        }

        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7);
        ItemMeta m = item.getItemMeta();
        m.setDisplayName(" ");
        item.setItemMeta(m);

        for (int i = 0; i < 18; i++) {
            inv.setItem(i, item);
        }

        ItemStack options = new ItemStack(Material.ENDER_CHEST);
        ItemMeta optionsMeta = options.getItemMeta();
        if (shop.isOpen()) {
            optionsMeta.setDisplayName(MainGUI.getString("ShopInfoDisplayNameOpen"));
        } else {
            optionsMeta.setDisplayName(MainGUI.getString("ShopInfoDisplayNameClosed"));
        }
        optionsMeta.setLore(Arrays.asList("§a" + shop.getName(), "§7" + shop.getDescription(), " ", MainGUI.getString("BuyingShop"), " ", MainGUI.getString("Owner") + " §a" + shop.getOwner().getName(),
                MainGUI.getString("Keepers") + " §7" + shop.getManagers().size(), " ", MainGUI.getString("OpenShopSettings"), MainGUI.getString("ToggleOpenAndClosed"), MainGUI.getString("ManageItems"),
                MainGUI.getString("AddItemToShop"), " ", MainGUI.getString("ArrangementMode")));
        options.setItemMeta(optionsMeta);

        ItemStack keepers = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta keepersMeta = (SkullMeta) keepers.getItemMeta();
        keepersMeta.setDisplayName(MainGUI.getString("ShopKeepersDisplayName"));
        keepersMeta.setLore(Arrays.asList(MainGUI.getString("ShopKeeperLore")));
        keepersMeta.setOwner(shop.getOwner().getName());
        keepers.setItemMeta(keepersMeta);

        ItemStack info = new ItemStack(Material.SIGN);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(MainGUI.getString("Buying"));
        infoMeta.setLore(Arrays.asList(MainGUI.getString("ToggleShop")));
        info.setItemMeta(infoMeta);

        ItemStack history = new ItemStack(Material.EMERALD);
        ItemMeta historyMeta = history.getItemMeta();
        historyMeta.setDisplayName(History.getString("History"));
        historyMeta.setLore(Arrays.asList(History.getString("OpenHistory")));
        history.setItemMeta(historyMeta);

        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta arrowMeta = arrow.getItemMeta();
        arrowMeta.setDisplayName(MainGUI.getString("NextPage"));
        arrow.setItemMeta(arrowMeta);

        ItemStack barrow = new ItemStack(Material.ARROW);
        ItemMeta barrowMeta = barrow.getItemMeta();
        barrowMeta.setDisplayName(MainGUI.getString("PreviousPage"));
        barrow.setItemMeta(barrowMeta);

        ItemStack pg1 = new ItemStack(Material.INK_SACK, 1, (byte) 10);
        ItemMeta pg1Meta = pg1.getItemMeta();
        pg1Meta.setDisplayName(MainGUI.getString("Page") + " 1");
        pg1.setItemMeta(pg1Meta);

        ItemStack pg2 = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        ItemMeta pg2Meta = pg2.getItemMeta();
        pg2Meta.setDisplayName(MainGUI.getString("Page") + " 2");
        pg2.setItemMeta(pg2Meta);

        ItemStack pg3 = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        ItemMeta pg3Meta = pg3.getItemMeta();
        pg3Meta.setDisplayName(MainGUI.getString("Page") + " 3");
        pg3.setItemMeta(pg3Meta);

        if (page == 1) {
            inv.setItem(8, arrow);
        }

        if (page == 2) {
            pg1 = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            pg1Meta = pg1.getItemMeta();
            pg1Meta.setDisplayName(MainGUI.getString("Page") + " 1");
            pg1.setItemMeta(pg1Meta);

            pg2 = new ItemStack(Material.INK_SACK, 1, (byte) 10);
            pg2Meta = pg2.getItemMeta();
            pg2Meta.setDisplayName(MainGUI.getString("Page") + " 2");
            pg2.setItemMeta(pg2Meta);

            pg3 = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            pg3Meta = pg3.getItemMeta();
            pg3Meta.setDisplayName(MainGUI.getString("Page") + " 3");
            pg3.setItemMeta(pg3Meta);

            inv.setItem(0, barrow);
            inv.setItem(8, arrow);
        }

        if (page == 3) {
            pg1 = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            pg1Meta = pg1.getItemMeta();
            pg1Meta.setDisplayName(MainGUI.getString("Page") + " 1");
            pg1.setItemMeta(pg1Meta);

            pg2 = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            pg2Meta = pg2.getItemMeta();
            pg2Meta.setDisplayName(MainGUI.getString("Page") + " 2");
            pg2.setItemMeta(pg2Meta);

            pg3 = new ItemStack(Material.INK_SACK, 1, (byte) 10);
            pg3Meta = pg3.getItemMeta();
            pg3Meta.setDisplayName(MainGUI.getString("Page") + " 3");
            pg3.setItemMeta(pg3Meta);

            inv.setItem(0, barrow);
        }

        inv.setItem(3, info);
        inv.setItem(4, options);
        inv.setItem(5, keepers);
        inv.setItem(7, history);

        inv.setItem(12, pg1);
        inv.setItem(13, pg2);
        inv.setItem(14, pg3);

        for (ItemStack it : shop.getShopContents(false).keySet()) {
            int slot = shop.getShopContents(false).get(it);

            if (page == 1) {
                if (slot >= 18 && slot < 54) {
                    if (it != null) {

                        if (it.getType() != Material.AIR) {
                            it.setAmount(1);
                            ItemMeta meta = it.getItemMeta();
                            List<String> lore;
                            if (meta.getLore() != null) {
                                lore = shop.getLore(it);
                            } else {
                                lore = new ArrayList<String>();
                            }

                            if (shop.isInfinite(it, false)) {
                                lore.add(MainGUI.getString("Stock") + " §7-");
                            } else {
                                lore.add(MainGUI.getString("Stock") + " §7" + shop.getStock(it, false));
                            }
                            lore.add(MainGUI.getString("Amount") + " §7" + shop.getAmount(it, false));
                            lore.add(MainGUI.getString("Price") + " §7" + shop.getPriceAsString(it, false));
                            lore.add(" ");
                            lore.add(MainGUI.getString("ManageItem"));
                            meta.setLore(lore);
                            it.setItemMeta(meta);
                            inv.setItem(slot, it);
                        }
                    }
                }
            } else if (page == 2) {
                if (slot >= 72 && slot < 108) {
                    if (it != null) {
                        it.setAmount(1);
                        ItemMeta meta = it.getItemMeta();
                        List<String> lore;
                        if (meta.getLore() != null) {
                            lore = shop.getLore(it);
                        } else {
                            lore = new ArrayList<String>();
                        }

                        if (shop.isInfinite(it, false)) {
                            lore.add(MainGUI.getString("Stock") + " §7-");
                        } else {
                            lore.add(MainGUI.getString("Stock") + " §7" + shop.getStock(it, false));
                        }
                        lore.add(MainGUI.getString("Amount") + " §7" + shop.getAmount(it, false));
                        lore.add(MainGUI.getString("Price") + " §7" + shop.getPriceAsString(it, false));
                        lore.add(" ");
                        lore.add(MainGUI.getString("ManageItem"));
                        meta.setLore(lore);
                        it.setItemMeta(meta);

                        slot = slot - 54;

                        inv.setItem(slot, it);
                    }
                }
            } else if (page == 3) {
                if (slot >= 126 && slot < 162) {
                    if (it != null) {
                        it.setAmount(1);
                        ItemMeta meta = it.getItemMeta();
                        List<String> lore;
                        if (meta.getLore() != null) {
                            lore = shop.getLore(it);
                        } else {
                            lore = new ArrayList<String>();
                        }

                        if (shop.isInfinite(it, false)) {
                            lore.add(MainGUI.getString("Stock") + " §7-");
                        } else {
                            lore.add(MainGUI.getString("Stock") + " §7" + shop.getStock(it, false));
                        }
                        lore.add(MainGUI.getString("Amount") + " §7" + shop.getAmount(it, false));
                        lore.add(MainGUI.getString("Price") + " §7" + shop.getPriceAsString(it, false));
                        lore.add(" ");
                        lore.add(MainGUI.getString("ManageItem"));
                        meta.setLore(lore);
                        it.setItemMeta(meta);

                        slot = slot - 108;

                        inv.setItem(slot, it);
                    }
                }
            }
        }
        if (!same)
            p.openInventory(inv);
    }
}
