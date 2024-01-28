package za.org.animeapp.util;

import java.util.Random;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        if ((str == null || str.isEmpty())) {
            return true;
        }
        return false;
    }
    public static int generateId() {
        return new Random().nextInt(100000);
    }
}
