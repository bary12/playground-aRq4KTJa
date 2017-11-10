package com.yourself;

import org.junit.Assert;
import org.junit.Test;
import com.yourself.TechIOUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShopTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    private void cleanUpStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void test(){
        try {
            assert50();
            assert10();
            TechIOUtil.success(true);
        } catch (AssertionError ae) {
            TechIOUtil.msg("שגיאה!", ae.getMessage());
            TechIOUtil.success(false);
        }

    }

    private void assert50() throws AssertionError {
        setUpStreams();
        Shop.shop(50);
        String content = outContent.toString();
        cleanUpStreams();
        Assert.assertTrue("בננה לא נקנתה כאשר money = 50", content.contains("banana"));
    }

    private void assert10() throws AssertionError {
        setUpStreams();
        Shop.shop(10);
        String content = outContent.toString();
        cleanUpStreams();
        Assert.assertFalse("הודפסה המילה banana למסך, למרות שאין ללקוח מספיק כסף", content.contains("banana"));
    }

}
