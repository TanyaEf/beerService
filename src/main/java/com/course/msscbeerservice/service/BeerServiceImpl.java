package com.course.msscbeerservice.service;

import com.course.msscbeerservice.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beeId) {
        return null;
    }

    @Override
    public BeerDto saveBeer(BeerDto beer) {
        return null;
    }

    @Override
    public BeerDto updateBeer(UUID uuid, BeerDto beer) {
        return null;
    }
}
