package org.undostres.sript;

import org.testng.annotations.Test;
import org.undostres.base.Base;
import org.undostres.pages.Recharge;
import org.undostres.pages.fbLogin;
import org.undostres.pages.payment;

public class rechargeMobile extends Base{
    @Test
    public void testRechargeMobileFlow() throws InterruptedException {
        //Enter Recharge related details
        Recharge ref= new Recharge(driver,pr);
        ref.rechargeScreen();

        //Enter card details
        payment obj= new payment(driver,pr);
        obj.paymentScreen();

        //Login to Facebook
        fbLogin ref1= new fbLogin(driver,pr);
        ref1.facebookLogin();


    }
}
