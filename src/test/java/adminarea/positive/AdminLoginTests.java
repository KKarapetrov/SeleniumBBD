package adminarea.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.AdminDashboard;
import pages.adminarea.AdminLogin;

public class AdminLoginTests extends BaseTest {


    @Test
    public void successfulLogin() {
        AdminLogin.navigate();
        AdminLogin.login("admin", "parola123!");

        AdminDashboard.verifyDashboardHeadingText("Dashboard", "message in case of bug");
    }



}
