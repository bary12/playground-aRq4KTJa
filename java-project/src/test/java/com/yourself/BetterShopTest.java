package com.yourself;

import org.junit.Assert;
import org.junit.Test;

public class BetterShopTest {

    private static final String enough = "can buy pizza";
    private static final String notEnough = "t have enough money";


    @Test
    public void test(){
        String content = Util.getFromStdOut(BetterShop::shop, 25);
        Util.assertTrue(content.contains(enough), "ההודעה \nYou can buy pizza \nלא הודפסה למסך, למרות שיש ללקוח מספיק כסף");
        Util.assertTrue(!content.contains(notEnough), "הודפסה ההודעה הלא נכונה");

        content = Util.getFromStdOut(BetterShop::shop, 15);
        Util.assertTrue(content.contains(enough), "ההודעה \nYou don't have enough money\n לא הודפסה למסך, למרות שאין ללקוח מספיק כסף");
        Util.assertTrue(!content.contains(notEnough), "הודפסה ההודעה\n You can buy pizza\nכאשר לא היה ללקוח מספיק כסף");
    }

}
