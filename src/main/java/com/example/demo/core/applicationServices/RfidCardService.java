package com.example.demo.core.applicationServices;

import com.example.demo.core.domainEntities.RfidCard;
import com.example.demo.core.domainEntities.RfidCard.State;
import com.example.demo.core.domainServices.IRfidCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RfidCardService {

    private IRfidCardRepository cardRepository;

    @Autowired
    public RfidCardService(IRfidCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public RfidCard activateRfidCard(String cardId) {
        var card = this.cardRepository.getRfidCardById(cardId);
        card.setLifeCycleState(State.ACTIVE);
        this.cardRepository.saveRfidCard(card);
        return card;
    }
}
