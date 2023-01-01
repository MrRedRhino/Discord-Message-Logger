package org.pipeman.msg_logger.util;

import org.pipeman.msg_logger.Config;
import org.pipeman.msg_logger.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AttachmentDownloader {
    private static final Queue<Attachment> toDelete = new LinkedList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentDownloader.class);
    private static Thread thread;
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    public static synchronized void downloadAttachment(String url, long id) {
        toDelete.offer(new Attachment(url, id));

        if (thread == null || !thread.isAlive()) {
            thread = new Thread(AttachmentDownloader::download);
            thread.start();
        }
    }

    private static void download() {
        for (Attachment att; (att = toDelete.poll()) != null; ) {
            try {
                LOGGER.info("Downloading " + att);
                HttpRequest request = HttpRequest.newBuilder(URI.create(att.url())).build();
                Path path = Path.of(Config.get().downloadPath, String.valueOf(att.id()));
                HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofFile(path));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private record Attachment(String url, long id) {
    }
}
