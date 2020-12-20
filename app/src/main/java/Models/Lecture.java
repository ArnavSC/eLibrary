package Models;

public class Lecture {
    String name,subject,link;

    public Lecture() { }

    public Lecture(String name, String subject, String link) {
        this.name = name;
        this.subject = subject;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
