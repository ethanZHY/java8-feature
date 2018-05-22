package demo.interfaces;

import demo.classes.Person;

public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}