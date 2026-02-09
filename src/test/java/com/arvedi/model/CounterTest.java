package com.arvedi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    @Test
    void incrementsAndResets() {
        Counter c = new Counter();
        c.increment(); c.increment(); c.decrement();
        assertEquals(1, c.getValue());
        c.reset();
        assertEquals(0, c.getValue());
    }
}
