package repository.impl;

import entity.Region;
import org.hibernate.Session;
import repository.RegionRepository;

import java.util.List;

public class RegionRepositoryImpl implements RegionRepository {

    @Override
    public Region getById(Long aLong) {
        return HibernateUtil.getSessionFactory().openSession().get(Region.class, aLong);

    }

    @Override
    public List<Region> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List <Region> regions = session.createQuery("FROM Region").list();
        session.getTransaction().commit();
        session.close();
        return regions;
    }

    @Override
    public Region update(Region region) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Region region1 = session.get(Region.class, region.getId());
        region1.setName(region.getName());
        session.update(region1);
        session.getTransaction().commit();
        session.close();
        return region1;
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Region region = session.get(Region.class, aLong);
        session.delete(region);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public Region save(Region region) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(region);
        session.getTransaction().commit();
        session.close();
        return region;
    }
}
