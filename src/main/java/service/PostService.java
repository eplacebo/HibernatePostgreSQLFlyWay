package service;

import entity.Post;
import repository.PostRepository;
import repository.impl.PostRepositoryImpl;

import java.util.List;

public class PostService {
    PostRepository postRepository = new PostRepositoryImpl();

    public PostService() {
        this.postRepository = postRepository;
    }

    public Post getPost(Long id) {
        return postRepository.getById(id);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public boolean deletePost(Long id) {
        postRepository.deleteById(id);
        return true;
    }

    public List<Post> getAllPosts() {
        return postRepository.getAll();
    }

    public Post updatePost(Post post) {
        return postRepository.update(post);
    }

}
