package com.yourself;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShopTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void test(){
        Shop.shop(50);
        Assert.assertTrue("לא הודפסה הודעה למסך", outContent.toString().contains("banana"));
        Shop.shop(10);
        Assert.assertEquals("הודפסה הודעה למסך, למרות שאין ללקוח מספיק כסף", "", outContent.toString());
    }
}
