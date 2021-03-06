package com.example.demo.external.database;

import com.example.demo.core.domainEntities.RfidCard;
import com.example.demo.core.domainEntities.RfidCard.State;
import com.example.demo.core.domainServices.IRfidCardRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RfidCardRepository implements IRfidCardRepository {

    Logger logger = LoggerFactory.getLogger(RfidCardRepository.class);

    @Override
    public RfidCard getRfidCardById(String id) {
        return new RfidCard(id, State.INACTIVE);
    }

    @Override
    public void saveRfidCard(RfidCard card) {

        logger.info("Storing Card " + card.getId() + " in database");
    }

}
