package com.course.msscbeerservice.brewery.model.event;

import com.course.msscbeerservice.brewery.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
