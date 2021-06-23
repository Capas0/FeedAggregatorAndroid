package ru.hse.edu.srzhuchkov;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code Feed} class represents items from RSS feed.
 */
public class Feed {
    private String title;
    private String description;
    private String link;
    private String source;
    
    public Feed() {
    }
    
    public Feed(ResultSet resultSet) {
        try {
            title = resultSet.getString("title");
            description = resultSet.getString("description");
            link = resultSet.getString("link");
            source = resultSet.getString("source");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Feed(String title, String description, String link, String source) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getLink() {
        return link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
}
