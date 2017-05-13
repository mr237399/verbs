package com.mikerussell;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mrussell on 5/12/17.
 */
public class VerbInventoryTest {


    @Before
    public void setup(){

    }

    @Test
    public void shouldLoadVerbs(){
        VerbInventory verbInventory = new VerbInventory("target/test-classes/verbs.csv");
        System.out.println(verbInventory.getVerbs().size());
        assertTrue(verbInventory.getVerbs().size()  == 18);

        for (Verb verb : verbInventory.getVerbs()){
                testConjugations(verb);
        }
    }

    @Test
    public void getIrregularVerbsOnlyReturnsIrregularVerbs(){
        VerbInventory verbInventory = new VerbInventory("target/test-classes/verbs.csv");
        System.out.println(verbInventory.getIrregularVerbs().size());
        assertTrue(verbInventory.getIrregularVerbs().size()  == 3);
    }


    private void testConjugations(Verb verb) {
        Conjugation conj = new Conjugation(verb);
        for(int i = 1; i <= conj.persons.size(); i++){
            conj.setSelectedPerson(i);
            System.out.println(conj.getFutureWill());
            assertEquals(conj.getFutureWill(), conj.getSelectedPerson() + " will " + verb.getBaseForm());
        }

    }


}
