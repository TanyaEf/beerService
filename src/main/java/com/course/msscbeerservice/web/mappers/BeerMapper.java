package com.course.msscbeerservice.web.mappers;

import com.course.msscbeerservice.domain.Beer;
import com.course.msscbeerservice.brewery.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapperImpl.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDtoWithInventory(Beer beer);
}
