package com.course.msscbeerservice.brewery.model.event;

import com.course.msscbeerservice.brewery.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 3516438080644297636L;

    private BeerDto beerDto;
}
