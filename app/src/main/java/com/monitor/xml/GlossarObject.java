package com.monitor.xml;

/**
 * Created by Loren on 23.02.2016.
 */
public class GlossarObject {

    // Tags der Glossar Elemente
    String title = "";
    String content = "";

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }
}
