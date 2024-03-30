package utils;

import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.text.DateFormatSymbols;
import java.text.Normalizer;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    //GENERATE RANDOM DATA USING THE JAVA FAKER LIBRARY
     private static final Faker faker = new Faker(new Locale.Builder() //e.g. for language-specific user names, addresses, etc.
            .setLanguage("es")
            .setRegion("ES")
            .build()
    );

    public static String getRandomFirstNameFaker () {
        return faker.name().firstName();
    }

    public static String getRandomLastNameFaker () {
        return faker.name().lastName();
    }

    public static String getRandomEmailFaker (String firstName, String lastName) {
        String localPart = firstName + "-" + lastName;//E.g. john-doe@example.com
        localPart = Normalizer.normalize(localPart, Normalizer.Form.NFD).replaceAll("\\p{M}", "");//This code removes diacritics because some names may contain them in Spanish, French, etc.
        localPart = localPart.replaceAll("\\s", "").toLowerCase();//This code removes whitespaces for names consisting of two words
        return faker.internet().safeEmailAddress(localPart);
    }

    public static String getRandomGenderFaker () {
        String[] genderList = {"Male", "Female", "Other"};
        return faker.options().option(genderList);
    }

    public static String getRandomPhoneFaker () {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomYearFaker () {
        return String.valueOf(faker.number().numberBetween(1900, 2024));
    }

    public static String getRandomMonthFaker () {
        //"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        String[] monthList = new DateFormatSymbols(Locale.US).getMonths(); //force the US locale to get month names in English
        return faker.options().option(monthList);
    }

    public static String getRandomSubjectFaker () {
        String[] subjectList = {"Maths", "Accounting", "Arts", "Social Studies", "Biology", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Economics", "Civics", "Hindi", "History"};
        return faker.options().option(subjectList);
    }

    public static String getRandomHobbyFaker () {
        String[] hobbyList = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbyList);
    }

    public static String getRandomPictureFaker () {
        String[] pictureList = {"SampleImage.png", "SampleImage2.png"};
        return faker.options().option(pictureList);
    }

    public static String getRandomAddressFaker () {
        return faker.address().fullAddress() + ",\n" + faker.address().country(); //multi-line
    }

    public static String getRandomStateFaker () {
        String[] stateList = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(stateList);
    }

    public static String getRandomCityFaker (String state) {
        String[] cityList = switch (state) {
            case "NCR" -> new String[]{"Delhi", "Gurgaon", "Noida"};
            case "Uttar Pradesh" -> new String[]{"Agra", "Lucknow", "Merrut"};
            case "Haryana" -> new String[]{"Karnal", "Panipat"};
            case "Rajasthan" -> new String[]{"Jaipur", "Jaiselmer"};
            default -> null;
        };
        return faker.options().option(cityList);
    }


    //===========================================================================================================



    //GENERATE RANDOM DATA USING NATIVE JAVA CODE
    public static String getRandomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10).toLowerCase() + "@gmail.com";
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("+%s (%s) %s-%s-%s", getRandomInt(1, 9), getRandomInt(100, 999),
                getRandomInt(100, 999), getRandomInt(10, 99), getRandomInt(10, 99));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public static String getRandomUuid() {
        return UUID.randomUUID().toString();
    }
}

