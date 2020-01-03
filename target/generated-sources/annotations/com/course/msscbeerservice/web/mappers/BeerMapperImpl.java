package com.course.msscbeerservice.web.mappers;

import com.course.msscbeerservice.domain.Beer;
import com.course.msscbeerservice.domain.Beer.BeerBuilder;
import com.course.msscbeerservice.web.model.BeerDto;
import com.course.msscbeerservice.web.model.BeerDto.BeerDtoBuilder;
import com.course.msscbeerservice.web.model.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-03T21:11:49+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapperImpl dateMapperImpl;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.uuid( beer.getUuid() );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDto.upc( beer.getUpc() );
        beerDto.price( beer.getPrice() );
        if ( beer.getVersion() != null ) {
            beerDto.version( beer.getVersion().intValue() );
        }
        beerDto.createdDate( dateMapperImpl.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.lastModifiedDate( dateMapperImpl.asOffsetDateTime( beer.getLastModifiedDate() ) );

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.uuid( beerDto.getUuid() );
        if ( beerDto.getVersion() != null ) {
            beer.version( beerDto.getVersion().longValue() );
        }
        beer.beerName( beerDto.getBeerName() );
        if ( beerDto.getBeerStyle() != null ) {
            beer.beerStyle( beerDto.getBeerStyle().name() );
        }
        beer.upc( beerDto.getUpc() );
        beer.price( beerDto.getPrice() );
        beer.createdDate( dateMapperImpl.asTimestamp( beerDto.getCreatedDate() ) );
        beer.lastModifiedDate( dateMapperImpl.asTimestamp( beerDto.getLastModifiedDate() ) );

        return beer.build();
    }
}
