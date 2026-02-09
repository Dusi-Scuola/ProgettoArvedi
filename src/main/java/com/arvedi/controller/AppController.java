package com.arvedi.controller;

import com.arvedi.model.Counter;

/**
 * This class is the CONTROLLER in the MVC architecture.
 *
 * Responsibilities:
 *  - Receives commands from the Views (CLI or GUI)
 *  - Uses the Model (Counter) to apply the business logic
 *  - Returns updated values back to the View
 *
 * NOTE:
 *  The View must NEVER modify the Model directly.
 *  All interactions with the Model go through the Controller.
 */
public class AppController {

    // Reference to the Model (Counter)
    private final Counter counter;

    /**
     * The Controller receives an instance of the Model.
     * This allows different Controllers to use different Models if needed.
     */
    public AppController(Counter counter) {
        this.counter = counter;
    }

    /** Returns the current counter value */
    public int getCount() {
        return counter.getValue();
    }

    /** Increases the counter by 1 and returns the new value */
    public int increment() {
        counter.increment();
        return counter.getValue();
    }

    /** Decreases the counter by 1 and returns the new value */
    public int decrement() {
        counter.decrement();
        return counter.getValue();
    }

    /** Resets the counter to 0 */
    public void reset() {
        counter.reset();
    }
}