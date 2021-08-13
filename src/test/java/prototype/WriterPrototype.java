package prototype;


import entity.Region;
import entity.Writer;
import repository.WriterRepository;
import repository.impl.WriterRepositoryImpl;

public class WriterPrototype {
    WriterRepository writerRepository = new WriterRepositoryImpl();

    public static Writer writerPrototype() {
        return new Writer("test","test",new Region("test"));
    }

}
