package com.xpiero.placesapi.services;

import com.xpiero.placesapi.domain.Place;
import com.xpiero.placesapi.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private PlaceRepository placeRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public Place update(String id, String name) {
        if (id != null && placeRepository.existsById(id)) {
            Place place = placeRepository.findById(id).get();
            place.setName(name);
            return placeRepository.save(place);
        }
        return null;
    }

    @Override
    public void delete(Place place) {
        placeRepository.delete(place);
    }

    @Override
    public boolean delete(String id) {
        if (id != null && placeRepository.existsById(id)) {
            Place place = placeRepository.findById(id).get();
            this.delete(place);
            return true;
        }
        return false;
    }

    @Override
    public List<Place> findAll() {
        return placeRepository.findAll();
    }
}
