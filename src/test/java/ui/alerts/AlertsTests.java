package ui.alerts;

import ui.base.BaseTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTests extends BaseTests {

    @Test
    void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals("You successfully clicked an alert", alertsPage.getResult());
    }

    @Test
    void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String test = alertsPage.alert_getText();
        alertsPage.alert_clickDismiss();
        assertEquals("I am a JS Confirm", test);
    }

    @Test
    void testSetInputInAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        alertsPage.alert_setInput("text");
        alertsPage.alert_clickToAccept();
        assertEquals("You entered: text", alertsPage.getResult());
    }
}
