package com.homel.preparation.concurrency.threadlocal.without;

import com.homel.preparation.concurrency.threadlocal.Context;
import com.homel.preparation.concurrency.threadlocal.UserRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserContext implements Runnable {

    public static Map<Integer, Context> userContextPerUserId
            = new ConcurrentHashMap<>();
    private Integer userId;
    private UserRepository userRepository = new UserRepository();

    public SharedMapWithUserContext(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
        userContextPerUserId.put(userId, new Context(userName));
    }
}
