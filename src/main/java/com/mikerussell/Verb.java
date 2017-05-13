package com.mikerussell;
/**
 * Created by mrussell on 6/29/16.
 */


public class Verb {

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

    public String getSimplePast() {
        return simplePast;
    }

    public void setSimplePast(String simplePast) {
        this.simplePast = simplePast;
    }

    public Boolean getIrregular() {
        return isIrregular;
    }

    public void setIrregular(Boolean irregular) {
        isIrregular = irregular;
    }

    protected String presentParticiple;
    protected String pastParticiple;
    protected String baseForm;
    protected String simplePast;
    protected Boolean isIrregular;

    public String getThirdPersonSingular() {
        return thirdPersonSingular;
    }

    public void setThirdPersonSingular(String thirdPersonSingular) {
        this.thirdPersonSingular = thirdPersonSingular;
    }

    protected String thirdPersonSingular;

    public Verb(String baseForm, String thirdPersonSingular, String simplePast, String pastParticiple, String presentParticiple, Boolean isIrregular){
        this.baseForm=baseForm;
        this.thirdPersonSingular = thirdPersonSingular;
        this.simplePast=simplePast;
        this.pastParticiple=pastParticiple;
        this.presentParticiple=presentParticiple;
        this.isIrregular=isIrregular;
    }
}
