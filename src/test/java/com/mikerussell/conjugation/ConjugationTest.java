package com.mikerussell.conjugation;

import com.mikerussell.conjugation.Conjugation;
import com.mikerussell.conjugation.Verb;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrussell on 7/2/16.
 */

public class ConjugationTest {

    Verb verb;
    Conjugation conj;
    Conjugation beConj;
    Conjugation haveConj;

    @Before
    public void setUp(){
        verb = new Verb("go", "goes", "went","gone","going",true);
        conj = new Conjugation(verb);
        beConj = new Conjugation(new Verb("be", "is", "were", "been", "being", true));
        haveConj = new Conjugation(new Verb("have", "has", "had","had","having",true));
    }

    @Test
    public void canCreateSubjectAndVerb(){




        conj.setSelectedPerson("I");

        assertEquals("I go", conj.getSimplePresent());
    }

    @Test
    public void canConjugateAllSimplePresentPersons(){

        for(int i = 1; i <= 8; i++) {

            conj.setSelectedPerson(i);

            String expectedConjugation = conj.getSelectedPerson() + " " + conj.getVerb().getBaseForm();
            if(conj.getSelectedPerson() == "He" || conj.getSelectedPerson() == "She" || conj.getSelectedPerson() == "It"){
                expectedConjugation = conj.getSelectedPerson() + " " + conj.getVerb().getThirdPersonSingular();
            }

            String actualConjugation = conj.getSimplePresent();
            assertEquals(expectedConjugation, actualConjugation);
        }
    }

    @Test
    public void canConjugateSimplePresentThirdPersonSingular(){

        conj.setSelectedPerson("He");

        String expectedConjugation = "He goes";
        assertEquals(expectedConjugation, conj.getSimplePresent());
    }

    @Test
    public void canConjugateSimplePast(){
        conj.setSelectedPerson("He");
        assertEquals("He went", conj.getSimplePast());
    }

    @Test
    public void canConjugateSimplePastThirdPersonSingularOfBe(){
        //new Verb("be", "is", "were", "been", "being", true);

        beConj.setSelectedPerson("She");
        assertEquals("She was", beConj.getSimplePast());
    }

    @Test
    public void canConjugatePresentProgressive(){

        for(int i = 1; i <= 8; i++) {

            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expectedConjugation = beConj.getSimplePresent() + " " + conj.getVerb().getPresentParticiple();

            String actualConjugation = conj.getPresentProgressive();
            assertEquals(expectedConjugation, actualConjugation);
        }
    }


    @Test
    public void canConjugatePastProgressive(){

        for(int i = 1; i <= 8; i++) {

            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expectedConjugation = beConj.getSimplePast() + " " + conj.getVerb().getPresentParticiple();
            System.out.println(expectedConjugation);
            String actualConjugation = conj.getPastProgressive();
            assertEquals(expectedConjugation, actualConjugation);
        }
    }

    @Test
    public void canConjugateGoingToFuture(){

        for(int i = 1; i <= 8; i++){
            beConj.setSelectedPerson(i);
            String expected = beConj.getSimplePresent() + " going to " + verb.getBaseForm();
            conj.setSelectedPerson(i);
            String actualConjugation = conj.getFutureGT();
            assertEquals(expected, actualConjugation);
            System.out.println(actualConjugation);
        }

    }

    @Test
    public void canConjugateWillFuture(){
        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expected = conj.getSelectedPerson() + " will " + conj.getVerb().getBaseForm();
            String actualConjugation = conj.getFutureWill();
            assertEquals(expected, actualConjugation);
            System.out.println(actualConjugation);
        }
    }

    @Test
    public void canConjugatePresentPerfect(){

        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            haveConj.setSelectedPerson(i);
            String expected = haveConj.getSimplePresent() + " " + conj.getVerb().getPastParticiple();
            String actualConjugation = conj.getPresentPerfect();
            assertEquals(expected, actualConjugation);
            System.out.println(actualConjugation);
        }
    }

    @Test
    public void canConjugatePastPerfect(){

        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            haveConj.setSelectedPerson(i);
            String expected = haveConj.getSimplePast() + " " + conj.getVerb().getPastParticiple();
            String actualConjugation = conj.getPastPerfect();
            assertEquals(expected, actualConjugation);
            System.out.println(actualConjugation);
        }
    }

    @Test
    public void canConjugateFuturePerfect(){

        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            haveConj.setSelectedPerson(i);
            String expected = haveConj.getFutureWill() + " " + conj.getVerb().getPastParticiple();
            String actualConjugation = conj.getFuturePerfect();
            assertEquals(expected, actualConjugation);
            System.out.println(actualConjugation);
        }
    }

    @Test
    public void canConjugateFutureProgressive(){
        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expected = beConj.getFutureWill() + " " + conj.getVerb().getPresentParticiple();
            String actualConjugation = conj.getFutureProgressive();
            assertEquals(expected, actualConjugation);
            System.out.println(actualConjugation);
        }
    }

    @Test
    public void canConjugateFuturePerfectProgressive(){
        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expected = beConj.getFuturePerfect() + " " + conj.getVerb().getPresentParticiple();
            String actualConjugation = conj.getFuturePerfectProgressive();
            assertEquals(expected, actualConjugation);
            System.out.println(actualConjugation);
        }
    }

    @Test
    public void canConjugatePresentPerfectProgressive(){
        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            haveConj.setSelectedPerson(i);
            String expected = haveConj.getPresentPerfect() + " " + conj.getVerb().getPresentParticiple();
            String actualConjugation = conj.getPresentPerfectProgressive();
            assertEquals(expected, actualConjugation);
            System.out.println(actualConjugation);
        }
    }



}
