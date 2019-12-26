package com.course.msscbeerservice.web.controller;

import com.course.msscbeerservice.web.model.BeerDto;
import com.course.msscbrewbery.services.BeerService;
import com.course.msscbrewbery.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v/beer")
@RestController
public class BeerController {


    /*
     *List Beers
     * Create New Beer
     *      * Update Beer by IdGet Beer by UPC Code    *
     *  */

    private  final BeerService beerService;
    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")  UUID beeId) {
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beeId), HttpStatus.OK);
    }

    @GetMapping({"/{}"})
    public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable("")  UUID beeId) {
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beeId), HttpStatus.OK);
    }

    @GetMapping({"/{}"})
    public ResponseEntity<BeerDto> listAllBeers(@PathVariable("")  UUID beeId) {
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beeId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> createNewBeer(@RequestBody BeerDto beer) {
        BeerDto savedBeerDtoV2 = beerService.saveBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeerDtoV2.getUuid().toString());
        return new ResponseEntity<>(savedBeerDtoV2, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId")UUID uuid, @RequestBody BeerDto beer) {
        BeerDto updatedBeerDtoV2 = beerService.updateBeer(uuid, beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v2/beer/" + updatedBeerDtoV2.getUuid().toString());
        return new ResponseEntity<>(updatedBeerDtoV2, httpHeaders, HttpStatus.OK);
    }

}
