package com.epiaggregator.services.fetcher.dtos;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private final String description;
    private final String title;
    private final String link;
    private final String feedUri;
    private final List<Entry> entries = new ArrayList<>();
    private String image = null;

    public Feed(String url, SyndFeed feed) {
        this.feedUri = url;

        this.description = feed.getDescription();
        this.title = feed.getTitle();
        this.link = feed.getLink();
        if (feed.getImage() != null) {
            this.image = feed.getImage().getUrl();
        }
        for (SyndEntry entry : feed.getEntries()) {
            this.entries.add(new Entry(entry));
        }
    }

    public String getFeedUri() {
        return feedUri;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getImage() {
        return image;
    }

    public List<Entry> getEntries() {
        return entries;
    }
}
