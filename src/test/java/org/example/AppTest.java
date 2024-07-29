package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testApp() {
        App app = new App();
        Assert.assertEquals( 4, app.sum(4,2));
    }
}


