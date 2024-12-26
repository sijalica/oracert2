package part10locale;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16:  Localization
Topic:  Resource Bundles
*/

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleResources {
    public static void main(String[] args) {

//        Locale.setDefault(new Locale("en", "AU"));
//
//        testProperties(Locale.getDefault());

//        int i = 1;
//        int[] iArr = {1};
//        incr(i) ;
//        incr(iArr) ;
//        System.out.println( "i = " + i + "  iArr[0] = " + iArr [ 0 ] ) ;

        int i = 0 ;
        boolean bool1 = true ;
        boolean bool2 = false;
        boolean bool  = false;
        bool = ( bool2 &  method1(i++) ); //1
        bool = ( bool2 && method1(i++) ); //2
        bool = ( bool1 |  method1(i++) ); //3
        bool = ( bool1 || method1(i++) ); //4
        System.out.println(i);

        var hasParams = (args == null ? false : true);
        if(hasParams) {
            System.out.println("has params");
        }

        {
            System.out.println("no params");
        }


        String[][][] arr  = {{ { "a", "b" , "c"}, { "d", "e", null } },
                { {"x"}, null },{{"y"}},{ { "z","p"}, {} }       };       System.out.println(arr[0][1][2]);

        var b1 = false; var b2  = false; if (b2 = b1 == false){    System.out.println("true"); } else{    System.out.println("false"); }
    }

    public static boolean method1(int i) {
        return i>0 ? true : false;
    }

    public static void incr(int   n ) { n++ ; }
    public static void incr(int[ ] n ) { n [ 0 ]++ ; }

    public static void testProperties(Locale locale) {

        System.out.println("---- Locale Passed: [" + locale
                + "] ---------");
        ResourceBundle localeData = ResourceBundle.getBundle(
                "firstBundle", locale);
        System.out.println("\tResourceBundle class = " +
                localeData.getClass().getName());
        // Get the 'selected' locale
        System.out.println("\tLocale Actually Used:  [" +
                localeData.getLocale() + "]");
        // Get a single valued based on a key
        System.out.println("\tInternationalizing the word yes  = " +
                localeData.getString("yes") + " [" + locale + "]");
        System.out.println("\t---Key/Values in properties file---");
        // Iterate through keys and do something
        localeData.keySet().forEach((s) ->
                System.out.println("\t" + s + " = " +
                        localeData.getObject(s)));

    }
}