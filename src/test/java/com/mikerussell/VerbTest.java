package com.mikerussell;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrussell on 6/30/16.
 */

public class VerbTest {
    @Test
    public void canCreateNewVerb() throws Exception {

        Verb verb = new Verb("go", "goes", "went","gone","going",true);
        assertEquals("go", verb.getBaseForm());
        assertEquals("goes", verb.getThirdPersonSingular());
    }

}
