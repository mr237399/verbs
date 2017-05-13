package com.mikerussell.conjugation;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

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

        assertEquals("I go", conj.getPresentSimple());
    }

    @Test
    public void canConjugateAllSimplePresentPersons(){

        for(int i = 1; i <= 8; i++) {

            conj.setSelectedPerson(i);

            String expectedConjugation = conj.getSelectedPerson() + " " + conj.getVerb().getBaseForm();
            if(conj.getSelectedPerson() == "He" || conj.getSelectedPerson() == "She" || conj.getSelectedPerson() == "It"){
                expectedConjugation = conj.getSelectedPerson() + " " + conj.getVerb().getThirdPersonSingular();
            }

            String actualConjugation = conj.getPresentSimple();
            assertEquals(expectedConjugation, actualConjugation);
        }
    }

    @Test
    public void canConjugateSimplePresentThirdPersonSingular(){

        conj.setSelectedPerson("He");

        String expectedConjugation = "He goes";
        assertEquals(expectedConjugation, conj.getPresentSimple());
    }

    @Test
    public void canConjugatePastSimple() {
        conj.setSelectedPerson("He");
        assertEquals("He went", conj.getPastSimple());
    }

    @Test
    public void canConjugatePastSimpleThirdPersonSingularOfBe() {
        //new Verb("be", "is", "were", "been", "being", true);

        beConj.setSelectedPerson("She");
        assertEquals("She was", beConj.getPastSimple());
    }

    @Test
    public void canConjugatePresentProgressive(){

        for(int i = 1; i <= 8; i++) {

            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expectedConjugation = beConj.getPresentSimple() + " " + conj.getVerb().getPresentParticiple();

            String actualConjugation = conj.getPresentProgressive();
            assertEquals(expectedConjugation, actualConjugation);
        }
    }


    @Test
    public void canConjugatePastProgressive(){

        for(int i = 1; i <= 8; i++) {

            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expectedConjugation = beConj.getPastSimple() + " " + conj.getVerb().getPresentParticiple();
            String actualConjugation = conj.getPastProgressive();
            assertEquals(expectedConjugation, actualConjugation);
        }
    }

    @Test
    public void canConjugateGoingToFuture(){

        for(int i = 1; i <= 8; i++){
            beConj.setSelectedPerson(i);
            String expected = beConj.getPresentSimple() + " going to " + verb.getBaseForm();
            conj.setSelectedPerson(i);
            String actualConjugation = conj.getFutureGoingTo();
            assertEquals(expected, actualConjugation);

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

        }
    }

    @Test
    public void canConjugatePresentPerfect(){

        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            haveConj.setSelectedPerson(i);
            String expected = haveConj.getPresentSimple() + " " + conj.getVerb().getPastParticiple();
            String actualConjugation = conj.getPresentPerfect();
            assertEquals(expected, actualConjugation);

        }
    }

    @Test
    public void canConjugatePastPerfect(){

        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            haveConj.setSelectedPerson(i);
            String expected = haveConj.getPastSimple() + " " + conj.getVerb().getPastParticiple();
            String actualConjugation = conj.getPastPerfect();
            assertEquals(expected, actualConjugation);

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

        }
    }

    @Test
    public void canConjugatePresentPerfectProgressive(){
        for(int i = 1; i <= 8; i++){
            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expected = beConj.getPresentPerfect() + " " + conj.getVerb().getPresentParticiple();
            String actualConjugation = conj.getPresentPerfectProgressive();
            assertEquals(expected, actualConjugation);

        }
    }

    @Test
    public void canConjugatePastPerfectProgressive() {
        for (int i = 1; i <= 8; i++) {
            conj.setSelectedPerson(i);
            beConj.setSelectedPerson(i);
            String expected = beConj.getPastPerfect() + " " + conj.getVerb().getPresentParticiple();
            String actualConjugation = conj.getPastPerfectProgressive();
            assertEquals(expected, actualConjugation);

        }
    }

    @Test
    public void getVerbTensesListOnlyReturnsTenseNames() {

        assert (beConj.getTenses().size() == 13);
        assertEquals(4, instancesOf("past"));
        assertEquals(4, instancesOf("present"));
        assertEquals(5, instancesOf("future"));
    }

    @Test
    public void setVerbTest() {
        conj.setVerb(verb);
        assertEquals(verb, conj.getVerb());
    }

    private int instancesOf(String time) {
        return beConj.getTenses().stream().filter(v -> v.toLowerCase().contains(time) == true).collect(Collectors.toList()).size();
    }


}
