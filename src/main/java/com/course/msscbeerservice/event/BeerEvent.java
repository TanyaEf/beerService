package com.course.msscbeerservice.event;

import com.course.msscbeerservice.web.model.BeerDto;
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
