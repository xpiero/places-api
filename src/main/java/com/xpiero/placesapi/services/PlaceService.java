package com.xpiero.placesapi.services;

import com.xpiero.placesapi.domain.Place;

import java.util.List;

public interface PlaceService {

    Place save(Place place);

    Place update(String id, String name);

    void delete(Place place);

    boolean delete(String id);

    List<Place> findAll();

}
