package ru.mail.park.services;

import org.springframework.stereotype.Service;
import ru.mail.park.model.UserEntity;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionService {
    private Map<String, UserEntity>  sessionIdToUser = new HashMap<>();

    public void addUserToSession (String sessionId, UserEntity userEntity) {
        sessionIdToUser.put(sessionId, userEntity);
    }

    public void endSession (String sessionId) {
        sessionIdToUser.remove(sessionId);
    }

    public UserEntity getUserBySessionId(String sessionId) {
        return sessionIdToUser.get(sessionId);
    }

    public long getLength() {
        return sessionIdToUser.size();
    }
}