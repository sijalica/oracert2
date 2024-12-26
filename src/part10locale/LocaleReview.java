package part10locale;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16:  Localization
Topic:  Use Locale class
*/

import java.util.Arrays;
import java.util.Locale;

public class LocaleReview {
    public static void main(String[] args) {

        // List of Available Locales
        System.out.println("Number of Locales: " +
                Locale.getAvailableLocales().length);

        System.out.println("------Hong Kong Locales ------");
        // List only Locales with country code of "HK"
        Arrays.stream(Locale.getAvailableLocales())
                .filter((s) -> s.getCountry().equals("HK"))
                .forEach((s) -> System.out.println(s + " : " +
                        s.getDisplayName()));

        System.out.println("------ Language only ------");
        // List only Locales with country code of "US"
        Arrays.stream(Locale.getAvailableLocales())
                //.filter((s) -> s.getCountry().equals("US"))
                .filter((s) -> s.getCountry().length() == 0 && s.getLanguage().length() > 0)
                .limit(7)
                .forEach((s) -> System.out.println(s + " : " +
                        s.getDisplayName()));

        System.out.println("------ Locales with variants ------");
        // List only Locales with country code of "US"
        Arrays.stream(Locale.getAvailableLocales())
                //.filter((s) -> s.getCountry().equals("US"))
                .filter((s) -> s.getVariant().length() > 0)
                .forEach((s) -> System.out.println(s + " : " +
                        s.getDisplayName() + " : " + s.getVariant()));

        System.out.println("------ Locales with extensions ------");
        // List only Locales with country code of "US"
        Arrays.stream(Locale.getAvailableLocales())
                //.filter((s) -> s.getCountry().equals("US"))
                .filter((s) -> s.getExtensionKeys().size() > 0)
                .forEach((s) -> System.out.println(s + " : " +
                        s.getDisplayName() + " : " + s.getExtensionKeys()));

        System.out.println("--------- Static fields for common Locales --------");

        // Locale static variables for some specific Locales.
        System.out.println("Locale.ENGLISH = " + Locale.ENGLISH);
        System.out.println("Locale.FRENCH = " + Locale.FRENCH);
        System.out.println("Locale.FRANCE = " + Locale.FRANCE);
        System.out.println("Locale.CANADA = " + Locale.CANADA);
        System.out.println("Locale.CANADA_FRENCH = " + Locale.CANADA_FRENCH);
        System.out.println("--------------------------");

        // Default Locale can be retrieved
        System.out.println("Default Locale: " + Locale.getDefault());

        // User friendly Display Name can be used.
        System.out.println("DisplayName of default locale = " +
                Locale.getDefault().getDisplayName());

        // User friendly Display Name can be displayed using a different locale
        System.out.println("DisplayName of default locale for locale.FRENCH = " +
                Locale.getDefault().getDisplayName(Locale.FRENCH));

        // Using Locale Constants
        Locale l = Locale.CANADA_FRENCH;
        System.out.println("Locale.CANADA_FRENCH = " + l);
        l = Locale.US;
        System.out.println("Locale.US = " + l);

        l = new Locale("en", "U&S");
        System.out.println(l);

        l = Locale.forLanguageTag("en-U&S");
        System.out.println(l);

        l = new Locale.Builder().setRegion("U&S")
                .setLanguage("en")
                .build();
        System.out.println(l);
    }
}