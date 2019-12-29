package com.course.msscbeerservice.web.controller;

import com.course.msscbeerservice.service.BeerService;
import com.course.msscbeerservice.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    private  final BeerService beerService;
    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")  UUID beeId) {
//        return new ResponseEntity<BeerDto>(beerService.getBeerById(beeId), HttpStatus.OK);
        return new ResponseEntity<BeerDto>(HttpStatus.OK);
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
    public ResponseEntity<BeerDto> createNewBeer(@Valid @RequestBody BeerDto beer) {
//        BeerDto savedBeerDtoV2 = beerService.saveBeer(beer);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Location", "/api/v1/beer/" + savedBeerDtoV2.getUuid().toString());
//        return new ResponseEntity<>(savedBeerDtoV2, httpHeaders, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId")UUID uuid, @Valid @RequestBody BeerDto beer) {
//        BeerDto updatedBeerDtoV2 = beerService.updateBeer(uuid, beer);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Location", "/api/v2/beer/" + updatedBeerDtoV2.getUuid().toString());
//        return new ResponseEntity<>(updatedBeerDtoV2, httpHeaders, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
