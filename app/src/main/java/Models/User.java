package Models;

public class User {
    private String id;
    private String username;
    private String picture;

    private User() {}

    public User(String picture,String id, String username) {
        this.id = id;
        this.username = username;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPicture() {
        return picture;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
