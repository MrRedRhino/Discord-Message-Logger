package org.pipeman.msg_logger;

import org.pipeman.pconf.AbstractConfig;
import org.pipeman.pconf.ConfigProvider;

import java.nio.file.Path;

public class Config extends AbstractConfig {
    private static final ConfigProvider<Config> PROVIDER = ConfigProvider.of("config.properties", Config::new);


    public final String token = get("token", "");
    public final String downloadPath = get("attachment-download-path", "attachments/");

    public Config(String file) {
        super(file);
        store(Path.of(file), "");
    }

    public static Config get() {
        return PROVIDER.c();
    }
}
