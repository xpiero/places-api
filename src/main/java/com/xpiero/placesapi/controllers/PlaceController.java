package com.xpiero.placesapi.controllers;

import com.xpiero.placesapi.domain.Place;
import com.xpiero.placesapi.services.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceController.class);

    @Autowired
    private PlaceService placeService;

    @GetMapping("")
    public ResponseEntity<List<Place>> getAllPlaces() {
        List<Place> places = placeService.findAll();
        if (places != null) {
            return ResponseEntity.ok(places);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/place")
    public ResponseEntity<Place> savePlace(@RequestBody Place place) {
        Place created = placeService.save(place);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.badRequest().build();
    }
}
