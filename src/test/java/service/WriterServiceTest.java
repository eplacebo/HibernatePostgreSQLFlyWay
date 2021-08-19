package service;

import entity.Writer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.impl.WriterRepositoryImpl;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static prototype.WriterPrototype.writerPrototype;

@ExtendWith(MockitoExtension.class)
class WriterServiceTest {

    @Mock
    WriterService writerService;

    @Mock
    List<Writer> listWriters;

    @Captor
    ArgumentCaptor<Writer> requestCaptorWriter = ArgumentCaptor.forClass(Writer.class);

    @BeforeEach
    void setUp() {
        listWriters.add(writerPrototype());
    }


    @Test
    void testGetWriter() {
        when(writerService.getWriter(anyLong())).thenReturn(writerPrototype());
        Writer writer = writerService.getWriter(444L);
        assertNotNull(writer);
        assertEquals("test", writerService.getWriter(444L).getFirstname());
        verify(writerService, times(2)).getWriter(any());
    }

    @Test
    void saveWriter() {
        when(writerService.saveWriter(any())).thenReturn(writerPrototype());
        writerService.saveWriter(writerPrototype());
        verify(writerService, times(1)).saveWriter(requestCaptorWriter.capture());
        assertNotNull(requestCaptorWriter.getValue());
        assertEquals(writerPrototype().getFirstname(), requestCaptorWriter.getValue().getFirstname());
    }

    @Test
    void deleteWriter() {
        when(writerService.deleteWriter((anyLong()))).thenReturn(true);
        boolean b = writerService.deleteWriter(444L);
        assertTrue(b);
        verify(writerService, times(1)).deleteWriter(anyLong());
    }

    @Test
    void getAllWriters() {
        when(writerService.getAllWriters()).thenReturn(listWriters);
        assertNotNull(writerService.getAllWriters());
        verify(writerService, times(1)).getAllWriters();
    }

    @Test
    void updateWriter() {
        when(writerService.updateWriter(any())).thenReturn(writerPrototype());
        PostService postService = new PostService();
        Writer writer = writerService.updateWriter(writerPrototype());
        assertNotEquals("D", writer.getFirstname());
        verify(writerService, times(1)).updateWriter(any());
    }
}
