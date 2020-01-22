package com.course.msscbeerservice.service;

import com.course.msscbeerservice.brewery.model.BeerDto;
import com.course.msscbeerservice.brewery.model.BeerPagedList;
import com.course.msscbeerservice.brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID uuid, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc);
}
