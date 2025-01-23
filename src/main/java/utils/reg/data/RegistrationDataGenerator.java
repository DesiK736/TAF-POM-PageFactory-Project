package utils.reg.data;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class RegistrationDataGenerator {
    public static String createUser() {

        return new SimpleDateFormat("SSS").format(new Date()) + "Student";
    }

    public static String createEmail() {

        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "@abv.bg";
    }

    public static String createInvalidEmail() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "!";
    }

    public static String createPassword() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "@abv.bg";
    }

    public static String createPasswordFor() {
        return new SimpleDateFormat("mmssSSS").format(new Date()) + "_student";
    }

    public static String generateUniqueUsername() {
        return "user_" + System.currentTimeMillis();
    }

    public static String generateUniqueEmail() {
        String domain = "@abv.bg";
        int usernameLength = 15 - domain.length();

        String username = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, usernameLength);

        return username + domain;
    }
}
