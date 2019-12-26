package com.course.msscbeerservice.service;

import com.course.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beeId);

    BeerDto saveBeer(BeerDto beer);

    BeerDto updateBeer(UUID uuid, BeerDto beer);
}
