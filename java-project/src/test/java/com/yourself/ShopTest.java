package com.yourself;

import org.junit.Assert;
import org.junit.Test;

public class ShopTest {

    @Test
    public void test(){
        try {
            assertNotEnough();
            assertEnough();
            Util.success(true);
        } catch (AssertionError ae) {
            Util.success(false);
            Util.msg("שגיאה!", ae.getMessage());
        }

    }

    private void assertEnough() throws AssertionError {
        Util.setUpStreams();
        Shop.shop(25);
        String content = Util.outContent.toString();
        Util.cleanUpStreams();
        Assert.assertTrue("הלקוח לא הצליח לקנות את הבננה, למרות שיש לו מספיק כסף (25)", content.contains("pizza"));
    }

    private void assertNotEnough() throws AssertionError {
        Util.setUpStreams();
        Shop.shop(15);
        String content = Util.outContent.toString();
        Util.cleanUpStreams();
        Assert.assertFalse(" הלקוח הצליח לקנות את הפיצה, למרות שאין לו מספיק כסף (15)", content.contains("pizza"));
    }

}
