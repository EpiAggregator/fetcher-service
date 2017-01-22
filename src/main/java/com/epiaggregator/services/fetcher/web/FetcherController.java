package com.epiaggregator.services.fetcher.web;

import com.epiaggregator.services.fetcher.dtos.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class FetcherController {
    @Autowired
    private WorkerService workerService;

    @RequestMapping(method = RequestMethod.POST, path = "/fetch")
    public CompletableFuture<List<Feed>> fetchFeed(@RequestBody List<String> feedUrls) {
        return workerService.fetchFeeds(feedUrls);
    }
}
