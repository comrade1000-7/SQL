package test;

import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDatabase;

public class AuthTest {

    @AfterAll
    public static void tearDown() {
        cleanDatabase();
    }


    @Test
    @DisplayName("Авторизация с валидным логином и паролем")
    void shouldBeSuccessful() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = SQLHelper.getRandomVerificationCode();
        verificationPage.validVerify(verificationCode);

    }
    @Test
    @DisplayName("Авторизация с рандомным логином и паролем")
    void shouldErrorShow() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.randomUser();
        loginPage.validLogin(authInfo);
        loginPage.verifyErrorNotificationVisibility();
    }
}