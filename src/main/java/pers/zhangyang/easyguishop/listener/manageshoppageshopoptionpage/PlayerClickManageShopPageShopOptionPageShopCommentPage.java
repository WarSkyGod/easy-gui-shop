package pers.zhangyang.easyguishop.listener.manageshoppageshopoptionpage;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import pers.zhangyang.easyguishop.domain.ManageShopPageShopOptionPage;
import pers.zhangyang.easyguishop.domain.ShopCommentPage;
import pers.zhangyang.easyguishop.meta.ShopMeta;
import pers.zhangyang.easylibrary.annotation.EventListener;
import pers.zhangyang.easylibrary.annotation.GuiDiscreteButtonHandler;

@EventListener
public class PlayerClickManageShopPageShopOptionPageShopCommentPage implements Listener {

    @GuiDiscreteButtonHandler(guiPage = ManageShopPageShopOptionPage.class, slot = {23})
    public void onPlayerClickAllShopNextPage(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        InventoryHolder holder = inventory.getHolder();

        Player player = (Player) event.getWhoClicked();
        ManageShopPageShopOptionPage allShopPageShopOptionPage = (ManageShopPageShopOptionPage) holder;
        ShopMeta shopMeta = allShopPageShopOptionPage.getShopMeta();
        ShopCommentPage allShopPageShopOptionPageShopCommentPage = new ShopCommentPage(allShopPageShopOptionPage, player, shopMeta);

        allShopPageShopOptionPageShopCommentPage.send();


    }

}