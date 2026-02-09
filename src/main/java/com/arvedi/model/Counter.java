package com.arvedi.model;

/**
 * This class is the MODEL in the MVC architecture.
 *
 * The Model contains:
 *  - the data (state)
 *  - the basic logic that manipulates the data
 *
 * IMPORTANT:
 *  The Model does NOT know anything about the GUI or CLI.
 *  It is completely independent.
 */
public class Counter {

    // Internal state (the counter value)
    private int value;

    /** Returns the current value */
    public int getValue() {
        return value;
    }

    /** Increases the value by 1 */
    public void increment() {
        value++;
    }

    /** Decreases the value by 1 */
    public void decrement() {
        value--;
    }

    /** Resets the value to 0 */
    public void reset() {
        value = 0;
    }
}