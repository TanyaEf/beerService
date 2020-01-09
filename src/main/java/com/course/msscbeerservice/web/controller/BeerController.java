package com.course.msscbeerservice.web.controller;

import com.course.msscbeerservice.service.BeerService;
import com.course.msscbeerservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@AllArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    private  final BeerService beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")  UUID beeId) {
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beeId), HttpStatus.OK);
    }

    //TODO update method
//    @GetMapping({"/{}"})
//    public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable("")  UUID beeId) {
//        return new ResponseEntity<BeerDto>(beerService.getBeerById(beeId), HttpStatus.OK);
//    }

    //TODO update method
//    @GetMapping({"/{}"})
//    public ResponseEntity<BeerDto> listAllBeers(@PathVariable("")  UUID beeId) {
//        return new ResponseEntity<BeerDto>(beerService.getBeerById(beeId), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<BeerDto> createNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId")UUID uuid, @Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeer(uuid, beerDto), HttpStatus.NO_CONTENT);
    }

}
