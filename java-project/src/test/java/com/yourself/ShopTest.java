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
            assert10();
            assert50();
            TechIOUtil.success(true);
        } catch (AssertionError ae) {
            TechIOUtil.success(false);
            TechIOUtil.msg("שגיאה!", ae.getMessage());
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
