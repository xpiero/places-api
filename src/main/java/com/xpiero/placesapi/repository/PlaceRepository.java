package com.xpiero.placesapi.repository;

import com.xpiero.placesapi.domain.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlaceRepository extends MongoRepository<Place, String> {

    @Query("{name:'?0'}")
    List<Place> findByName(String name);

}
