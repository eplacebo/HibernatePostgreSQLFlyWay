package prototype;

import entity.Post;

public class PostPrototype {

    public static Post postPrototype(){
        return new Post("test");
    }
}
