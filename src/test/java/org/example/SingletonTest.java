package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SingletonTest {

    @Test
    void getInstance() {
        Object object1 = Singleton.getInstance();
        Object object2 = Singleton.getInstance();

        Assert.assertTrue(object1.equals(object2));
    }
}