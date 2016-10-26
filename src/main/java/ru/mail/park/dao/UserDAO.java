package ru.mail.park.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.mail.park.model.UserEntity;
import ru.mail.park.database.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by sergeigavrilko on 24.10.16.
 */
public class UserDAO {

    Configuration conf = new Configuration().configure();
    ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
    SessionFactory sf = conf.buildSessionFactory(sr);

    public void addUser(UserEntity user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public UserEntity getUser(String login) throws SQLException {
        Session session = null;
        UserEntity user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (UserEntity) session.load(UserEntity.class, login);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return user;
    }

    public UserEntity getUserById(int id) throws SQLException {
        Session session = null;
        UserEntity user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            user = session.load(UserEntity.class, id);
            session.getTransaction().commit();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return user;
    }

    public void deleteUser(UserEntity user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
