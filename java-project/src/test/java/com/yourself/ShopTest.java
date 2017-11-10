package com.yourself;

import org.junit.Assert;
import org.junit.Test;
import com.yourself.TechIOUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShopTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;
    private final PrintStream stderr = System.err;

    private void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    private void cleanUpStreams() {
        System.setOut(stdout);
        System.setErr(stderr);
    }

    @Test
    public void test(){
        try {
            assertNotEnough();
            assertEnough();
            TechIOUtil.success(true);
        } catch (AssertionError ae) {
            TechIOUtil.success(false);
            TechIOUtil.msg("שגיאה!", ae.getMessage());
        }

    }

    private void assertEnough() throws AssertionError {
        setUpStreams();
        Shop.shop(25);
        String content = outContent.toString();
        cleanUpStreams();
        Assert.assertTrue("הלקוח לא הצליח לקנות את הבננה, למרות שיש לו מספיק כסף (25)", content.contains("pizza"));
    }

    private void assertNotEnough() throws AssertionError {
        setUpStreams();
        Shop.shop(15);
        String content = outContent.toString();
        cleanUpStreams();
        Assert.assertFalse(" הלקוח הצליח לקנות את הפיצה, למרות שאין לו מספיק כסף (15)", content.contains("pizza"));
    }

}
