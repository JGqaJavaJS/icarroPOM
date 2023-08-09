package utils;

import java.util.Random;

public class RandomUtils {

    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com", "test.com"};
        String[] names = {"john", "alice", "bob", "emma", "david", "susan", "alex"};

        Random random = new Random();
        int digit = random.nextInt(10000);
        String randomName = names[random.nextInt(names.length)];
        String randomDomain = domains[random.nextInt(domains.length)];

        return randomName + digit + "@" + randomDomain;
    }
}
