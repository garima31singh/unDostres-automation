package org.undostres.Assertions;

public class assertionClass {
    public static void compareStrings(String actual_text,String expected_text){
        if(actual_text.contains(expected_text)){
            System.out.println(actual_text  + " equals " + expected_text);
        }
        else {
            System.out.println(actual_text + " not equals " + expected_text);
        }
    }
    public static void comapareUrl(String actual_url,String expected_url){
        if(actual_url.equals(expected_url)){
            System.out.println("Assertion passed as " + actual_url + " equals to " + expected_url);
        } else {
            System.out.println("Assertion failed as" + actual_url + " is not similar to " + expected_url);
        }
    }
}

