package org.pipeman.msg_logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Jdbi;

public class Database {

    private static Jdbi jdbi;

    public static void connect() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://pipeman.org:5432/data_mining");
        config.setUsername("pi");
        config.setPassword("fullbridgerectifier");
        jdbi = Jdbi.create(new HikariDataSource(config));
    }

    public static Jdbi jdbi() {
        return jdbi;
    }

    public static void storeMessage(boolean mentionEveryone, long author, String content, long guildId, long id,
                                    long channelId, boolean userIsPremium) {
        jdbi().useHandle(h -> {
            int i = 0;
            h.createUpdate("""
                            INSERT INTO messages
                            VALUES ((?), (?), (?), (?), (?), (?), (?));
                            """)
                    .bind(i++, mentionEveryone)
                    .bind(i++, author)
                    .bind(i++, content)
                    .bind(i++, guildId)
                    .bind(i++, id)
                    .bind(i++, channelId)
                    .bind(i, userIsPremium)
                    .execute();
        });
    }

    public static void storeAttachment(long msgId, String originalName, long fileID) {
        jdbi().useHandle(h -> h.createUpdate("INSERT INTO attachments\n" +
                                             "VALUES ((?), (?), (?))")
                .bind(0, msgId)
                .bind(1, originalName)
                .bind(2, fileID)
                .execute());
    }

    public static void makeMessageDeleted(long id) {
        jdbi().useHandle(h -> h.createUpdate("""
                        INSERT INTO deleted_msgs
                        VALUES ((?), current_timestamp);
                        """)
                .bind(0, id)
                .execute());
    }
}
