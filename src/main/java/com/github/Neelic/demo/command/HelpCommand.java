package com.github.Neelic.demo.command;

import com.github.Neelic.demo.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.Neelic.demo.command.CommandName.*;

/**
 * Help {@link Command}.
 */
public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String HELP_MESSAGE = String.format("""
                    ✨<b>Дотупные команды</b>✨

                    <b>Начать\\закончить работу с ботом</b>
                    %s - начать работу со мной
                    %s - приостановить работу со мной
                    %s - получить статистику пользователей
                    %s - получить помощь в работе со мной
                    """,
            START.getCommandName(), STOP.getCommandName(), STAT.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
