package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private final Registry registry = new Registry();

    @Test
    public void registerDeadPerson() {
        Person person = new Person("Daniel Hernández", 1, 22, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
        registry.clearTempRepo();
    }

    @Test
    public void registerInvalidAgePerson() {
        Person person = new Person("Daniel Hernández", 1, 0, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
        registry.clearTempRepo();
    }

    @Test
    public void registerUnderagePerson() {
        Person person = new Person("Daniel Hernández", 1, 17, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
        registry.clearTempRepo();
    }

    @Test
    public void registerValidPerson() {
        Person person = new Person("Daniel Hernández", 1, 22, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        registry.clearTempRepo();
    }

    @Test
    public void registerDuplicatePerson() {
        Person person = new Person("Daniel Hernández", 1, 22, Gender.MALE, true);
        registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
        registry.clearTempRepo();
    }
}
