package com.mikerussell.conjugation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrussell on 6/30/16.
 */

public class VerbTest {

    Verb verb = new Verb("go", "goes", "went", "gone", "going", true);

    @Test
    public void canCreateNewVerb() throws Exception {


        assertEquals("go", verb.getBaseForm());
        assertEquals("goes", verb.getThirdPersonSingular());
    }

    @Test
    public void testAllSetters() throws Exception {

        for (java.lang.reflect.Method method : Verb.class.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                //TODO: Invoke the setter
                System.out.println(method.getParameterTypes()[0].getCanonicalName());
                if (method.getParameterTypes()[0].getCanonicalName().equals("java.lang.String")) {
                    String testString = "test";
                    method.invoke(verb, testString);

                    String actualReturn = (String) Verb.class
                            .getDeclaredMethod(method.getName().replace("set", "get"))
                            .invoke(verb);
                    assertEquals(testString, actualReturn);

                }
                if (method.getParameterTypes()[0].getCanonicalName().equals("java.lang.Boolean")) {
                    Boolean testBool = true;
                    method.invoke(verb, testBool);

                    Boolean actualReturn = (Boolean) Verb.class
                            .getDeclaredMethod(method.getName().replace("set", "get"))
                            .invoke(verb);
                    assertEquals(testBool, actualReturn);
                }
                //TODO: Invoke on its getter
            }
        }


    }

}
