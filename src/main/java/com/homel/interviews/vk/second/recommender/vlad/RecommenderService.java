package com.homel.interviews.vk.second.recommender.vlad;

import java.util.List;

public interface RecommenderService<Document, User> {
    List<Document> getTop(User user, int limit);

    void addDocument(Document document);
}
