package com.yourself;

import org.junit.Test;

public class ShopTest {

    @Test
    public void test(){
        String content = Util.getFromStdOut(Shop::shop, 15);
        Util.assertTrue(!content.contains("pizza"), " הלקוח הצליח לקנות את הפיצה, למרות שאין לו מספיק כסף (15)");

        content = Util.getFromStdOut(Shop::shop, 25);
        Util.assertTrue(content.contains("pizza"), "הלקוח לא הצליח לקנות את הפיצה, למרות שיש לו מספיק כסף (25)");
    }

}
