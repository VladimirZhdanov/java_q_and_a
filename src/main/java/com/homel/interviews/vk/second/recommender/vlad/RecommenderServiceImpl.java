package com.homel.interviews.vk.second.recommender.vlad;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class RecommenderServiceImpl<Document, User> implements RecommenderService<Document, User> {

    // Необходимо реализовать сервис который может сохранять документ и получать  топ К (limit) документов для пользователя по скору этой функции
    private final Scorer scorer;
    private final List<Document> documents = new CopyOnWriteArrayList<>();

    public RecommenderServiceImpl(Scorer scorer) {
        this.scorer = scorer;
    }

    @Override
    public List<Document> getTop(User user, int limit) {
        return documents.stream()
                .map(document -> {
                    double score = scorer.getScore(document, user);
                    return Map.entry(document, score);
                })
                .sorted((d1, d2) -> {
                    Double score1 = d1.getValue();
                    Double score2 = d2.getValue();
                    if (score1 == score2) {
                        return 0;
                    }
                    if (score1 > score2) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .map(documentPair -> (Document) documentPair.getKey())
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public void addDocument(Document document) {
        documents.add(document);
    }
}
