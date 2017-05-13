package com.mikerussell.conjugation;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by mrussell on 7/2/16.
 */
public class Conjugation {
    public HashMap<Integer, String> persons = new HashMap<Integer, String>();
    String selectedPerson = "";

    Verb verb;

    public Conjugation(Verb verb) {
        persons.put(1, "I");
        persons.put(2, "You");
        persons.put(3, "He");
        persons.put(4, "She");
        persons.put(5, "It");
        persons.put(6, "We");
        persons.put(7, "You guys");
        persons.put(8, "They");
        this.verb = verb;

        Random rand = new Random();
        Integer selectedPersonVal = rand.nextInt(8);
        selectedPerson = persons.get(selectedPersonVal);

    }

    public HashMap<Integer, String> getPersons() {
        return persons;
    }

    public void setPersons(HashMap<Integer, String> persons) {
        this.persons = persons;
    }

    public String getPresentSimple() {
        if(selectedPerson.toLowerCase().equals("He".toLowerCase()) || selectedPerson.toLowerCase().equals("She".toLowerCase()) || selectedPerson.toLowerCase().equals("It".toLowerCase())){
            return selectedPerson + " " + getVerb().getThirdPersonSingular();
        }

        if(verb.getBaseForm().toLowerCase().equals("be")){
            if(selectedPerson.toLowerCase().equals("i")){
                return selectedPerson + " " + "am";
            }
            else{
                return selectedPerson + " " + "are";
            }

        }


        return selectedPerson + " " + getVerb().getBaseForm();
    }

    public String getPresentProgressive(){
        Verb be = new Verb("be", "is", "was", "been", "being",true);
        Conjugation auxiliaryVerb = new Conjugation(be);
        auxiliaryVerb.setSelectedPerson(selectedPerson);
        return auxiliaryVerb.getPresentSimple() + " " + verb.getPresentParticiple();


    }

    public String getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(int selectedPersonKey){ this.selectedPerson = getPersons().get(selectedPersonKey);}

    public void setSelectedPerson(String selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public Verb getVerb() {
        return verb;
    }

    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    public String getPastSimple() {

        if(verb.getBaseForm().toLowerCase().equals("be") && (
                getSelectedPerson().toLowerCase().equals("he") ||
                        getSelectedPerson().toLowerCase().equals("she") ||
                        getSelectedPerson().toLowerCase().equals("it") ||
                        getSelectedPerson().toLowerCase().equals("i")
        )){
            return selectedPerson + " " + "was";
        }

        return selectedPerson + " " + getVerb().getPastSimple();
    }

    public String getPastProgressive(){

        Verb be = new Verb("be", "is", "were", "been", "being",true);
        Conjugation auxiliaryVerb = new Conjugation(be);
        auxiliaryVerb.setSelectedPerson(selectedPerson);
        return auxiliaryVerb.getPastSimple() + " " + verb.getPresentParticiple();
    }

    public String getInfinitive(){
        return "to " + verb.getBaseForm();
    }

    public String getFutureGoingTo() {
        Verb go = new Verb("go", "goes", "went", "gone", "going",true);
        Conjugation aux = new Conjugation(go);
        aux.setSelectedPerson(selectedPerson);
        return aux.getPresentProgressive() + " " + aux.getInfinitive();
    }

    public String getFutureWill() {
        return selectedPerson + " will " + getVerb().getBaseForm();
    }

    public String getPresentPerfect() {
        Verb have = new Verb("have", "has", "had", "had", "having",true);
        Conjugation aux = new Conjugation(have);
        aux.setSelectedPerson(selectedPerson);
        return aux.getPresentSimple() + " " + verb.getPastParticiple();
    }

    public String getPastPerfect() {
        Verb have = new Verb("have", "has", "had", "had", "having",true);
        Conjugation aux = new Conjugation(have);
        aux.setSelectedPerson(selectedPerson);
        return aux.getPastSimple() + " " + verb.getPastParticiple();

    }

    public String getFuturePerfect() {
        Verb have = new Verb("have", "has", "had", "had", "having",true);
        Conjugation aux = new Conjugation(have);
        aux.setSelectedPerson(selectedPerson);
        return aux.getFutureWill() + " " + verb.getPastParticiple();
    }

    public String getFutureProgressive() {
        Verb be = new Verb("be", "is", "were", "been", "being",true);
        Conjugation auxiliaryVerb = new Conjugation(be);
        auxiliaryVerb.setSelectedPerson(selectedPerson);
        return auxiliaryVerb.getFutureWill() + " " + verb.getPresentParticiple();

    }

    public String getFuturePerfectProgressive() {
        Verb be = new Verb("be", "is", "were", "been", "being",true);
        Conjugation auxiliaryVerb = new Conjugation(be);
        auxiliaryVerb.setSelectedPerson(selectedPerson);
        return auxiliaryVerb.getFuturePerfect() + " " + verb.getPresentParticiple();
    }

    public String getPresentPerfectProgressive() {
        Verb be = new Verb("be", "is", "were", "been", "being", true);
        Conjugation auxiliaryVerb = new Conjugation(be);
        auxiliaryVerb.setSelectedPerson(selectedPerson);
        return auxiliaryVerb.getPresentPerfect() + " " + verb.getPresentParticiple();
    }

    public String getPastPerfectProgressive() {
        Verb be = new Verb("be", "is", "were", "been", "being", true);
        Conjugation auxiliaryVerb = new Conjugation(be);
        auxiliaryVerb.setSelectedPerson(selectedPerson);
        return auxiliaryVerb.getPastPerfect() + " " + verb.getPresentParticiple();
    }

    public List<String> getTenses() {
        List<String> tensez = new ArrayList<String>();
        for (Method method : this.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("get")
                    && (method.getName().toLowerCase().contains("past") ||
                    method.getName().toLowerCase().contains("present") ||
                    method.getName().toLowerCase().contains("future"))) {

                String tenseInPascalCase = method.getName().substring(3);

                String formattedString = StringUtils.join(
                        StringUtils.splitByCharacterTypeCamelCase(tenseInPascalCase),
                        ' '
                );

                tenseInPascalCase = null;
                System.out.println(formattedString);

                tensez.add(formattedString);
                formattedString = null;
            }
        }
        java.util.Collections.sort(tensez);
        return tensez;
    }
}
