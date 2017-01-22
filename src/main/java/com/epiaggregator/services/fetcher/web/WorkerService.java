package com.epiaggregator.services.fetcher.web;

import com.epiaggregator.services.fetcher.dtos.Feed;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
class WorkerService {
    @Async
    CompletableFuture<List<Feed>> fetchFeeds(List<String> feedUrls) {
        return CompletableFuture.supplyAsync(() -> {
            SyndFeedInput input = new SyndFeedInput();
            List<Feed> feeds = new ArrayList<>();
            for (String feedUrl : feedUrls) {
                try {
                    SyndFeed feed = input.build(new XmlReader(new URL(feedUrl)));
                    feeds.add(new Feed(feedUrl, feed));
                } catch (FeedException | IOException e) {
                    e.printStackTrace();
                }
            }
            return feeds;
        });
    }
}
