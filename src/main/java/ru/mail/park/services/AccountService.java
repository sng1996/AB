package ru.mail.park.services;

import org.springframework.stereotype.Service;
import ru.mail.park.model.UserEntity;
import ru.mail.park.database.Factory;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccountService {
    private static final AtomicLong ID_GENETATOR = new AtomicLong(0);

    public UserEntity addUser(String login, String password, String email) throws SQLException {
        final int id = (int) ID_GENETATOR.getAndIncrement();
        final UserEntity userEntity = new UserEntity(id, login, password, email);
        Factory.getInstance().getUserDAO().addUser(userEntity);
        return userEntity;
    }

    public UserEntity getUser(String login) throws SQLException {
        return Factory.getInstance().getUserDAO().getUser(login);
    }

    public UserEntity getUserById(int id) throws SQLException {
        return Factory.getInstance().getUserDAO().getUserById(id);
    }

    public void deleteUser(UserEntity user) throws SQLException {
        Factory.getInstance().getUserDAO().deleteUser(user);
    }
}
