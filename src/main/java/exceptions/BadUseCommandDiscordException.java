package exceptions;

import commands.Command;
import commands.HelpCommand;
import data.Constants;
import discord.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.handle.obj.IMessage;

/**
 * Created by steve on 14/11/2016.
 */
public class BadUseCommandDiscordException implements DiscordException {

    private final static Logger LOG = LoggerFactory.getLogger(BadUseCommandDiscordException.class);

    @Override
    public void throwException(IMessage message, Command command, Object... arguments) {
        Message.sendText(message.getChannel(), message.getAuthor() + ", " + Constants.prefixCommand
                + command.getName() + " ne s'utilise pas comme ça. Tape `"
                + Constants.prefixCommand + new HelpCommand().getName()
                + " " + command.getName() + "` pour en savoir plus.");
    }
}
