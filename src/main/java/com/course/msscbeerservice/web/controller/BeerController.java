package com.course.msscbeerservice.web.controller;

import com.course.msscbeerservice.service.BeerService;
import com.course.msscbeerservice.web.model.BeerDto;
import com.course.msscbeerservice.web.model.BeerPagedList;
import com.course.msscbeerservice.web.model.BeerStyleEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private  final BeerService beerService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity<BeerPagedList> listBeers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                   @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                   @RequestParam(value = "beerName", required = false) String beerName,
                                                   @RequestParam(value = "beerStyle", required = false) BeerStyleEnum beerStyle){

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        BeerPagedList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(beerList, HttpStatus.OK);
    }

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
