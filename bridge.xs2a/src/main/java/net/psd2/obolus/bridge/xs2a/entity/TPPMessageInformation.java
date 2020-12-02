package net.psd2.obolus.bridge.xs2a.entity;

public class TPPMessageInformation {
    public enum Category {
        ERROR, WARNING
    }

    private Category category;
    private MessageCode code;
    private String path;
    private String text;

    public String getText() {
        return text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MessageCode getCode() {
        return code;
    }

    public void setCode(MessageCode code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setText(String text) {
        this.text = text;
    }

}
