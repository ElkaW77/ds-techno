package com.leo.discord.command.commands;

import com.leo.discord.CommandManager;
import com.leo.discord.Config;
import com.leo.discord.command.CommandContext;
import com.leo.discord.command.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class HelpCommand implements ICommand {

    private final CommandManager manager;

    public HelpCommand(CommandManager m) {
        this.manager = m;
    }

    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        if (args.isEmpty()){

            StringBuilder builder = new StringBuilder();

            builder.append("List of Commands\n");

            manager.getCommands().stream().map(ICommand::getName).forEach((it) -> builder.append("'").append(Config.get("prefix")).append(it).append("'\n"));

            channel.sendMessage(builder.toString()).queue();
            return;
        }

        String search = args.get(0);
        ICommand command = manager.getCommand(search);

        if (command == null){
            channel.sendMessage(command.getHelp()).queue();
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Show the list with commands in the bot \n" + "Usage: '!help [command]'";
    }

    @Override
    public List<String> getAliases() {
        return List.of("commands", "cmds", "commandlist");
    }
}
