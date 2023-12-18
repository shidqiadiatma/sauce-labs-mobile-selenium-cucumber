package com.shidqiadiatma.helpers;

import com.github.javafaker.Faker;
import java.util.Locale;

public class randomData {
    static Faker faker = new Faker(new Locale("ID"));

    public static String getFirstName() {
        return faker.name().firstName();
    }
    public static String getLastName() {
        return faker.name().lastName();
    }
    public static String getPostalCode() {
        return faker.address().zipCode();
    }


}