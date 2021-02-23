package com.example.demo.core.domainServices;

import com.example.demo.core.domainEntities.RfidCard;

public interface IRfidCardRepository {

    public RfidCard getRfidCardById(String id);

    public void saveRfidCard(RfidCard card);
}
