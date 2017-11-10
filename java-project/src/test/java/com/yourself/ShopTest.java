package com.yourself;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.yourself.TechIOUtil;

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
        try {
            Shop.shop(50);
            Assert.assertTrue("בננה לא נקנתה כאשר money = 50", outContent.toString().contains("banana"));
            Shop.shop(10);
            Assert.assertEquals("הודפסה הודעה למסך, למרות שאין ללקוח מספיק כסף", "", outContent.toString());
            TechIOUtil.success(true);
        } catch (AssertionError ae) {
            TechIOUtil.msg("Oops! 🐞", ae.getMessage());
            TechIOUtil.success(false);
        }
    }
}
