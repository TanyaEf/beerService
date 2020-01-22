package com.course.msscbeerservice.brewery.model.event;

import com.course.msscbeerservice.brewery.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}

