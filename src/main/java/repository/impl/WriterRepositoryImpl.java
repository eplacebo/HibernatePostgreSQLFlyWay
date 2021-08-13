package repository.impl;

import entity.Writer;
import org.hibernate.Session;
import repository.WriterRepository;

import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public Writer getById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Writer writer = session.get(Writer.class, aLong);
        session.getTransaction().commit();
        session.close();
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List <Writer> writers= session.createQuery("FROM Writer").list();
        session.getTransaction().commit();
        session.close();
        return writers;
    }

    @Override
    public Writer update(Writer writer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Writer writer1 = session.get(Writer.class, writer.getId());
        writer1.setFirstname(writer.getFirstname());
        writer1.setLastname(writer.getLastname());
        writer1.setPosts(writer.getPosts());
        writer1.setRegion(writer.getRegion());
        session.update(writer1);
        session.getTransaction().commit();
        session.close();
        return writer1;
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Writer writer = session.get(Writer.class, aLong);
        session.delete(writer);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public Writer save(Writer writer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(writer);
        session.getTransaction().commit();
        session.close();
        return writer;
    }
}
