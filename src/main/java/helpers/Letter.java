package helpers;

public class Letter {

    private String sendLetterToAddress;
    private String subject;
    private String body;
    private String filePath;

    public Letter setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Letter setBody(String body) {
        this.body = body;
        return this;
    }

    public String getBody() {
        return body;
    }


    public Letter setAddress(String address) {
        this.sendLetterToAddress = address;
        return this;
    }

    public String getAddress() {
        return sendLetterToAddress;
    }

    public Letter setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }
}