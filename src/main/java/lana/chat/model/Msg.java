package lana.chat.model;

public class Msg {
    private int id;
    private String username;
    private String content;

    public Msg() {
    }

    public Msg(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public Msg(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
