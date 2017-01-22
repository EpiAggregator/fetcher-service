package com.epiaggregator.services.fetcher.dtos;

import com.rometools.rome.feed.synd.SyndEntry;

import java.util.Date;

public class Entry {
    private final String author;
    private final String link;
    private final String title;
    private final Date pubDate;
    private final String description;

    public Entry() {
        this.link = null;
        this.pubDate = null;
        this.description = null;
        this.title = null;
        this.author = null;
    }

    public Entry(SyndEntry entry) {
        this.author = entry.getAuthor();
        this.link = entry.getLink();
        this.title = entry.getTitle();
        this.pubDate = entry.getPublishedDate();
        this.description = entry.getDescription().getValue();
    }

    public String getAuthor() {
        return author;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }
}
