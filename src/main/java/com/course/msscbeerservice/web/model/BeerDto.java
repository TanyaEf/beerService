package com.course.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    @Null
    private UUID uuid;
    @Size(min = 3, max = 20)
    private String beerName;
    @NotNull
    private BeerStyleEnum beerStyle;
    @Positive
    @NotNull
    private Long upc;
    private @Positive Integer quantityOnHand;
    @NotNull
    @Positive
    private BigDecimal price;
    @Null
    private Integer version;
    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModifiedDate;
}
