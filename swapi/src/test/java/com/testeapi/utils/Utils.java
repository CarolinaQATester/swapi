package com.testeapi.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Locale;

public class Utils {

    public static Faker faker = new Faker(new Locale("pt-BR"));

    public static String getBaseUrl() {
        String baseUrl = "https://swapi.dev/api/";
        return baseUrl;
    }


}
