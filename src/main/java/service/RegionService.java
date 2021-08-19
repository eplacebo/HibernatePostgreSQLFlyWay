package service;


import entity.Region;
import repository.RegionRepository;
import repository.impl.RegionRepositoryImpl;

import java.util.List;

public class RegionService {

    RegionRepository regionRepository = new RegionRepositoryImpl();


    public RegionService() {
        this.regionRepository = regionRepository;
    }

    public Region getRegion(Long id) {
        return regionRepository.getById(id);
    }

    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

    public boolean deleteRegion(Long id) {
        regionRepository.deleteById(id);
        return true;
    }

    public List<Region> getAllRegions() {
        return regionRepository.getAll();
    }

    public Region updateRegion(Region region) {
        return regionRepository.update(region);
    }

}

