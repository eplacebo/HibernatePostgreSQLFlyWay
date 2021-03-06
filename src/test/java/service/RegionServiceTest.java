package service;

import entity.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.impl.RegionRepositoryImpl;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static prototype.RegionPrototype.regionPrototype;

@ExtendWith(MockitoExtension.class)
class RegionServiceTest {

    @Mock
    RegionService regionService;


    @Captor
    ArgumentCaptor<Region> requestCaptorRegion = ArgumentCaptor.forClass(Region.class);


    @BeforeEach
    void setUp() {
    }


    @Test
    void GetRegion() {
        when(regionService.getRegion(anyLong())).thenReturn(regionPrototype());
        Region region = regionService.getRegion(666L);
        assertNotNull(region);
        assertEquals(regionPrototype().getId(),region.getId());
        assertEquals(regionPrototype().getName(),region.getName());
        verify(regionService, times(1)).getRegion(any());
    }

    @Test
    void saveRegion() {
        when(regionService.saveRegion(any())).thenReturn(regionPrototype());
        regionService.saveRegion(any());
        verify(regionService, times(1)).saveRegion(requestCaptorRegion.capture());
        assertNotNull(requestCaptorRegion.getAllValues());
    }

    @Test
    void deleteRegion() {
        when(regionService.deleteRegion(anyLong())).thenReturn(true);
        boolean b = regionService.deleteRegion(666L);
        assertTrue(b);
        verify(regionService, times(1)).deleteRegion(anyLong());
    }

    @Test
    void getAllRegions() {
        List<Region> list = new ArrayList<>();
        list.add(0,regionPrototype());
        when(regionService.getAllRegions()).thenReturn(list);
        assertNotNull(regionService.getAllRegions().get(0));
        verify(regionService,times(1)).getAllRegions();
    }

    @Test
    void updateRegion() {
        when(regionService.updateRegion(any())).thenReturn(regionPrototype());
        Region region = new Region( "D");
        region= regionService.updateRegion(regionPrototype());
        assertNotEquals("D",region.getName());
        verify(regionService,times(1)).updateRegion(any());
    }
}
