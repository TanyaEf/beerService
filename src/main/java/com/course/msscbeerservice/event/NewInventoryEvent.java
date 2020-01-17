package com.course.msscbeerservice.event;

import com.course.msscbeerservice.web.model.BeerDto;

public class NewInventoryEvent extends BeerEvent{

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}

