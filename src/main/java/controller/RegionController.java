package controller;


import entity.Region;
import service.RegionService;

import java.util.List;

public class RegionController {

    RegionService regionService = new RegionService();

    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    public Region getByIdRegion(Long id) {
        return regionService.getRegion(id);
    }

    public boolean deleteByIdRegion(Long id) {
        regionService.deleteRegion(id);
        return true;
    }

    public Region saveRegion(String name) {
        return regionService.saveRegion(new Region(name));
    }

    public Region updateRegion(Long id, String name) {
        Region region = regionService.getRegion((id));
        region.setName(name);
        regionService.updateRegion(region);
        return region;
    }
}




