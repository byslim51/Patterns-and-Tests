package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Test
    void bank() {
        Assert.assertEquals(1,new BankService().bank());
    }
}