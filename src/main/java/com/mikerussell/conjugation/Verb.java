package com.mikerussell.conjugation;
/**
 * Created by mrussell on 6/29/16.
 */


public class Verb {

    protected String presentParticiple;
    protected String pastParticiple;
    protected String baseForm;
    protected String PastSimple;
    protected Boolean isIrregular;
    protected String thirdPersonSingular;

    public Verb(String baseForm, String thirdPersonSingular, String PastSimple, String pastParticiple, String presentParticiple, Boolean isIrregular) {
        this.baseForm = baseForm;
        this.thirdPersonSingular = thirdPersonSingular;
        this.PastSimple = PastSimple;
        this.pastParticiple = pastParticiple;
        this.presentParticiple = presentParticiple;
        this.isIrregular = isIrregular;
    }

    public String getPresentParticiple() {
        return presentParticiple;
    }

    public void setPresentParticiple(String presentParticiple) {
        this.presentParticiple = presentParticiple;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public void setPastParticiple(String pastParticiple) {
        this.pastParticiple = pastParticiple;
    }

    public String getBaseForm() {
        return baseForm;
    }

    public void setBaseForm(String baseForm) {
        this.baseForm = baseForm;
    }

    public String getPastSimple() {
        return PastSimple;
    }

    public void setPastSimple(String PastSimple) {
        this.PastSimple = PastSimple;
    }

    public Boolean getIrregular() {
        return isIrregular;
    }

    public void setIrregular(Boolean irregular) {
        isIrregular = irregular;
    }

    public String getThirdPersonSingular() {
        return thirdPersonSingular;
    }

    public void setThirdPersonSingular(String thirdPersonSingular) {
        this.thirdPersonSingular = thirdPersonSingular;
    }
}
