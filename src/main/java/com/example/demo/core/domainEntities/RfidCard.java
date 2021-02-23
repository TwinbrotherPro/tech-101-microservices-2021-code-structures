package com.example.demo.core.domainEntities;

public class RfidCard {
    private String id;

    private State lifeCycleState;

    public RfidCard(String id, State lifeCycleState) {
        this.id = id;
        this.lifeCycleState = lifeCycleState;
    }

    public State getLifeCycleState() {
        return this.lifeCycleState;
    }

    public String getId() {
        return this.id;
    }

    public void setLifeCycleState(State lifeCycleState) {
        this.lifeCycleState = lifeCycleState;
    }

    public enum State {
        ACTIVE, INACTIVE
    }
}
