package com.course.msscbeerservice.web.mappers;

import com.course.msscbeerservice.domain.Beer;
import com.course.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapperImpl.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
