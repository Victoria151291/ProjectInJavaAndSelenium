package helpers;

public class SetGetEmailData {

    private String sendLetterToAddress;
    private String subject;
    private String body;
    private String filePath;

    public SetGetEmailData setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public SetGetEmailData setBody(String body) {
        this.body = body;
        return this;
    }

    public String getBody() {
        return body;
    }


    public SetGetEmailData setAddress(String address) {
        this.sendLetterToAddress = address;
        return this;
    }

    public String getAddress() {
        return sendLetterToAddress;
    }

    public SetGetEmailData setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }
}