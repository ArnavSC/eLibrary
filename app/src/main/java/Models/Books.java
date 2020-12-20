package Models;

public class Books {
    String author, link, name, subject;

    public Books(){}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Books(String author, String link, String name, String subject) {
        this.author = author;
        this.link = link;
        this.name = name;
        this.subject = subject;
    }
}
