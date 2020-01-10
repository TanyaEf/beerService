package com.course.msscbeerservice.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID uuid;

    @Version
    private Long version;

    private String beerName;
    private String beerStyle;
    @Column(unique = true)
    private String upc;
    private Integer quantityToBrew;
    private Integer minOnHand;
    private BigDecimal price;

    @CreationTimestamp
    @Column(updatable =  false)
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
}
