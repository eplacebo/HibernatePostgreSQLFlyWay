package repository.impl;

import entity.Post;
import org.hibernate.Session;
import repository.PostRepository;

import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @Override
    public Post getById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Post post = session.get(Post.class, aLong);
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    public List<Post> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List <Post> posts = session.createQuery("FROM Post").list();
        session.getTransaction().commit();
        session.close();
        return posts;
    }


    @Override
    public Post update(Post post) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Post post1 = session.get(Post.class, post.getId());
        post1.setContent(post.getContent());
        session.update(post1);
        session.getTransaction().commit();
        session.close();
        return post1;
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Post post = session.get(Post.class, aLong);
        session.delete(post);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public Post save(Post post) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(post);
        session.getTransaction().commit();
        session.close();
        return post;
    }
}


