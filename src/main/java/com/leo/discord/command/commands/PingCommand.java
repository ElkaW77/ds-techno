package com.leo.discord.command.commands;

import com.leo.discord.command.CommandContext;
import com.leo.discord.command.ICommand;
import net.dv8tion.jda.api.JDA;

public class PingCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();

        jda.getRestPing().queue(
                (ping) -> ctx.getChannel()
                        .sendMessageFormat("Reset ping: %sms\nWS ping: %sms", ping, jda.getGatewayPing()).queue()
        );
    }

    public String getHelp() {
        return "Shows the Current ping from the bot to the discord Server";
    }

    @Override
    public String getName() {
        return "ping";
    }
}
