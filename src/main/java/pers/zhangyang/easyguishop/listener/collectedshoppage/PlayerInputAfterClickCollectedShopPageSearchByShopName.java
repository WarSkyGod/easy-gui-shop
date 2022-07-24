package pers.zhangyang.easyguishop.listener.collectedshoppage;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import pers.zhangyang.easyguishop.domain.CollectedShopPage;
import pers.zhangyang.easyguishop.yaml.MessageYaml;
import pers.zhangyang.easylibrary.base.FiniteInputListenerBase;
import pers.zhangyang.easylibrary.util.MessageUtil;

public class PlayerInputAfterClickCollectedShopPageSearchByShopName extends FiniteInputListenerBase {

    private final CollectedShopPage collectedShopPage;

    public PlayerInputAfterClickCollectedShopPageSearchByShopName(Player player, OfflinePlayer owner, CollectedShopPage allShopPage) {
        super(player, owner, allShopPage, 1);
        this.collectedShopPage = allShopPage;
        MessageUtil.sendMessageTo(player, MessageYaml.INSTANCE.getStringList("message.chat.howToSearchByShopNameInCollectedShopPage"));
    }


    @Override
    public void run() {

        collectedShopPage.searchByShopName(messages[0]);
    }
}
