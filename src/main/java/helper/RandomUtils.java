package helper;

import java.util.Random;

public class RandomUtils {
    public static void main(String[] args) {
        System.out.println(generateEmail(10));
        System.out.println(generateString(7));
    }

    static Random random = new Random();

    public static String generateEmail(int length) {
        String[] domains = {"mail.com", "gmail.com", "yahoo.com", "example.com"};
        String domain = domains[random.nextInt(domains.length)];
        return (generateString(length) + "@" + domain);
    }

    public static String generateString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] randomString = new char[length];
        int charLength = characters.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = random.nextInt(charLength);
            randomString[i] = characters.charAt(index);
        }
        return new String(randomString);
    }
    public static String generatePhone(int length) {
        String characters = "0123456789";
        char[] randomString = new char[length];
        int charLength = characters.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = random.nextInt(charLength);
            randomString[i] = characters.charAt(index);
        }
        return new String(randomString);
    }
    public static String generateEmailWoDot(int length) {
        String[] domains = {"mailcom", "gmailcom", "yahoocom", "examplecom"};
        String domain = domains[random.nextInt(domains.length)];
        return (generateString(length) +"@" + domain);
    }
    public static String generateEmailWoAt(int length) {
        String[] domains = {"mail.com", "gmail.com", "yahoo.com", "example.com"};
        String domain = domains[random.nextInt(domains.length)];
        return (generateString(length)  + domain);
    }
    public static String generateStringRussianLetters(int length) {
        String characters = "йцукенгшщздлорпавыфячсмитьбююжэхё0123456789";
        char[] randomString = new char[length];
        int charLength = characters.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = random.nextInt(charLength);
            randomString[i] = characters.charAt(index);
        }
        return new String(randomString);
    }
    public static String generateEmailRussianLetters(int length) {
        String[] domains = {"mail.com", "gmail.com", "yahoo.com", "example.com"};
        String domain = domains[random.nextInt(domains.length)];
        return (generateStringRussianLetters(length) + "@" + domain);
    }
}
