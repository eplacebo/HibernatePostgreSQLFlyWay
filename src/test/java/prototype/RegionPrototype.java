package prototype;


import entity.Region;

public class RegionPrototype {

    public static Region regionPrototype(){
        return new Region("test");
    }

}
