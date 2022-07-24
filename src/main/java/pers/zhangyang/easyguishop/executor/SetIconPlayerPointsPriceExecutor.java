package pers.zhangyang.easyguishop.executor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import pers.zhangyang.easyguishop.exception.NotExistIconException;
import pers.zhangyang.easyguishop.service.CommandService;
import pers.zhangyang.easyguishop.service.impl.CommandServiceImpl;
import pers.zhangyang.easyguishop.yaml.MessageYaml;
import pers.zhangyang.easylibrary.base.ExecutorBase;
import pers.zhangyang.easylibrary.util.MessageUtil;
import pers.zhangyang.easylibrary.util.TransactionInvocationHandler;

public class SetIconPlayerPointsPriceExecutor extends ExecutorBase {

    public SetIconPlayerPointsPriceExecutor(@NotNull CommandSender sender, String cmdName, @NotNull String[] args) {
        super(sender, cmdName, args);
    }

    @Override
    protected void run() {
        if (args.length != 2) {
            return;
        }
        int price;
        try {
            price = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageUtil.invalidArgument(sender, args[1]);
            return;
        }
        if (price < 0) {
            MessageUtil.invalidArgument(sender, args[1]);
            return;
        }
        args[0] = ChatColor.translateAlternateColorCodes('&', args[0]);
        CommandService guiService = (CommandService) new TransactionInvocationHandler(new CommandServiceImpl()).getProxy();
        try {
            guiService.setIconPlayerPointsAndPrice(args[0], price);


        } catch (NotExistIconException e) {
            MessageUtil.sendMessageTo(sender, MessageYaml.INSTANCE.getStringList("message.chat.notExistIconWhenSetIconPlayerPointsPrice"));
            return;
        }
        MessageUtil.sendMessageTo(sender, MessageYaml.INSTANCE.getStringList("message.chat.setIconPlayerPointsPrice"));
    }
}
