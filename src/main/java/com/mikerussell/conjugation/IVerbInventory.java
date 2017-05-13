package com.mikerussell.conjugation;

import java.util.List;

/**
 * Created by mrussell on 5/12/17.
 */
public interface IVerbInventory {

    void loadVerbsFromFile(String filename);

    List<Verb> getVerbs();

    List<Verb> getIrregularVerbs();

    //TODO: Get verbs by rule

}
