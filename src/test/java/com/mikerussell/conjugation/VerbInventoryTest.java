package com.mikerussell.conjugation;

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
        assertTrue(verbInventory.getVerbs().size()  == 18);

        for (Verb verb : verbInventory.getVerbs()){
                testConjugations(verb);
        }
    }

    @Test
    public void getIrregularVerbsOnlyReturnsIrregularVerbs(){
        VerbInventory verbInventory = new VerbInventory("target/test-classes/verbs.csv");
        assertTrue(verbInventory.getIrregularVerbs().size()  == 3);
    }


    private void testConjugations(Verb verb) {
        Conjugation conj = new Conjugation(verb);
        for(int i = 1; i <= conj.persons.size(); i++){
            conj.setSelectedPerson(i);
            assertEquals(conj.getFutureWill(), conj.getSelectedPerson() + " will " + verb.getBaseForm());
        }

    }


}
