package service;

import entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.impl.PostRepositoryImpl;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static prototype.PostPrototype.postPrototype;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    PostService postService;

    @Mock
    List<Post> listPost;

    @BeforeEach
    void setUp() {
        listPost.add(postPrototype());
    }

    @Captor
    ArgumentCaptor<Post> requestCaptorPost = ArgumentCaptor.forClass(Post.class);


    @Test
    void testGetPost() {
        when(postService.getPost(anyLong())).thenReturn(postPrototype());
        Post post = postService.getPost(555L);
        assertNotNull(post);
        assertEquals("test", postService.getPost(555L).getContent());
        verify(postService, times(2)).getPost(any());
    }

    @Test
    void savePost() {
        when(postService.savePost(any())).thenReturn(postPrototype());
        postService.savePost(postPrototype());
        verify(postService, times(1)).savePost(requestCaptorPost.capture());
        assertNotNull(requestCaptorPost.getAllValues());
        assertEquals(postPrototype().getContent(), requestCaptorPost.getValue().getContent());
    }

    @Test
    void deletePost() {
        when(postService.deletePost(anyLong())).thenReturn(true);
        boolean b = postService.deletePost(555L);
        assertTrue(b);
        verify(postService, times(1)).deletePost(anyLong());
    }

    @Test
    void getAllPost() {
        when(postService.getAllPosts()).thenReturn(listPost);
        assertNotNull(postService.getAllPosts());
        verify(postService, times(1)).getAllPosts();
    }

    @Test
    void updatePost() {
        when(postService.updatePost(any())).thenReturn(postPrototype());
        Post post = new Post("D");
        post = postService.updatePost(postPrototype());
        assertNotEquals("D", post.getContent());
        verify(postService, times(1)).updatePost(any());
    }
}


