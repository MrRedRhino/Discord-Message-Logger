package org.pipeman.msg_logger;

import org.pipeman.dccapi.events.Listener;
import org.pipeman.dccapi.events.messages.MessageCreateEvent;
import org.pipeman.dccapi.events.messages.MessageDeleteEvent;
import org.pipeman.dccapi.events.ws.LoggedInEvent;
import org.pipeman.dccapi.wrappers.Attachment;
import org.pipeman.dccapi.wrappers.Message;
import org.pipeman.msg_logger.util.AttachmentDownloader;

public class MessageListener implements Listener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Message message = event.message();
        if (message.guild().isEmpty()) return;

        for (Attachment attachment : message.attachments()) {
            long fId = Main.UID.newUID();
            Database.storeAttachment(message.id(), attachment.filename(), fId);
            AttachmentDownloader.downloadAttachment(attachment.url(), fId);
        }

        Database.storeMessage(
                message.mentionEveryone(),
                message.author().id(),
                message.content(),
                message.guild().get().id(),
                message.id(),
                message.channel().id(),
                false
        );
    }

    @Override
    public void onMessageDelete(MessageDeleteEvent event) {
        Database.makeMessageDeleted(event.message().messageID());
    }

    @Override
    public void onLogin(LoggedInEvent event) {
        System.out.println("Logged in to discord");
    }
}
