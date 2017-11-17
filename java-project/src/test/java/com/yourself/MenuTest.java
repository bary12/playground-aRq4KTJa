package com.yourself;

import org.junit.Test;

public class MenuTest {

    @Test
    public void test() {
        String out = Util.getFromStdOut(Menu::menu, "pizza");
        Util.assertTrue(out.contains("pizza"), "");

    }
}
