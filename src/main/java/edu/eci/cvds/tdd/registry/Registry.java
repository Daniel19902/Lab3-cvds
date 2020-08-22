package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    private ArrayList<Integer> tempRepo = new ArrayList<>();

    public RegisterResult registerVoter(Person person) {
        if (!person.isAlive()) {
            return RegisterResult.DEAD;
        } else if (person.getAge() <= 0) {
            return RegisterResult.INVALID_AGE;
        } else if (person.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        } else if (tempRepo.contains(person.getId())) {
            return RegisterResult.DUPLICATED;
        } else {
            tempRepo.add(person.getId());
            return RegisterResult.VALID;
        }
    }

    public void clearTempRepo() {
        tempRepo.clear();
    }
}
