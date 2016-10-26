package ru.mail.park.database;

import ru.mail.park.dao.UserDAO;

/**
 * Created by sergeigavrilko on 24.10.16.
 */
public class Factory {

    private static UserDAO userDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO getUserDAO(){
        if (userDAO == null){
            userDAO = new UserDAO();
        }
        return userDAO;
    }
}
