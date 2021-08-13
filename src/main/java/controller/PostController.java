package controller;

import entity.Post;
import service.PostService;
import java.util.List;

public class PostController {

    PostService postService = new PostService();

    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    public Post getByIdPost(Long id) {
        return postService.getPost(id);
    }

    public boolean deleteByIdPost(Long id) {
        postService.deletePost(id);
        return true;
    }

    public Post savePost(String content) {
        return postService.savePost(new Post(content));
    }

    public Post update(Long id, String content) {
        Post post = postService.getPost(id);
        post.setContent(content);
        postService.updatePost(post);
        return post;
    }

}





