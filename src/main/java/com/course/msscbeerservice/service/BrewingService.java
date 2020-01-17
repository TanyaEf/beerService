package com.course.msscbeerservice.service;

import com.course.msscbeerservice.config.JmsConfig;
import com.course.msscbeerservice.domain.Beer;
import com.course.msscbeerservice.event.BrewBeerEvent;
import com.course.msscbeerservice.repositories.BeerRepository;
import com.course.msscbeerservice.service.inventory.BeerInventoryService;
import com.course.msscbeerservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();
        beers.forEach(beer -> {
            Integer invOnH = beerInventoryService.getOnhandInventory(beer.getUuid());
            log.debug("Min Onhand is: " + beer.getMinOnHand());
            log.debug("Inventory is: "  + invOnH);

            if (beer.getMinOnHand() >= invOnH) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEU, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
