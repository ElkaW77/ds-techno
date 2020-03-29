package com.leo.discord.command;

import java.util.List;

public interface ICommand {
    void handle(CommandContext ctx);

    String getName();

    default List<String> getAliasess(){
        return List.of();
    }
}
