package org.pipeman.msg_logger;

import de.mkammerer.snowflakeid.structure.Structure;
import org.pipeman.dccapi.DiscordClient;
import org.pipeman.msg_logger.util.LoggerImpl;
import org.pipeman.msg_logger.util.UID;
import org.slf4j.impl.StaticLoggerBinder;

import java.io.File;

public class Main {
    public static final UID UID = new UID(1, new Structure(46, 6, 11));

    public static void main(String[] args) {
        File downloadPathFile = new File(Config.get().downloadPath);
        downloadPathFile.mkdir();

        StaticLoggerBinder.getSingleton().setLogger(new LoggerImpl());
        Database.connect();

        DiscordClient client = DiscordClient.connect(Config.get().token);
        client.getEventEmitter().addListener(new MessageListener());
    }
}