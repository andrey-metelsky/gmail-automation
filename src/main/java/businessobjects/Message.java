package businessobjects;

import java.io.File;

public class Message {
    String recipient;
    String subject;
    File attachment;

    public Message(String recipient, String subject, File attachment) {
        this.recipient = recipient;
        this.subject = subject;
        this.attachment = attachment;
    }

    public Message(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;

    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }
}
