package com.example.esercizioFlight.Utils;

import java.util.Random;

public class RandomUtils {

    private static String alpha = "qwertyuiopasdfghjklzxcvbnm1234567890";
    private static Random random = new Random();

    public static String randomString(int length) {

        StringBuilder risultato = new StringBuilder();
        for (int i = 0; i < length; i++) {
            risultato.append(alpha.charAt(random.nextInt(0,alpha.length())));
        }
        System.out.println(risultato);
        return risultato.toString();
    }
}
