package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import demo.classes.Dummy;
import demo.classes.LambdaScope;
import demo.classes.Person;
import demo.interfaces.Converter;
import demo.interfaces.Formula;
import demo.interfaces.PersonFactory;

public class DemoApplication {
    public static void main(String[] args){
        // Default method for interfaces
        Formula formula = new Formula() {
            @Override
            public double increaseByOne(int a) {
                return a + 1;
            }   
        };
        double cal = formula.increaseByOne(2);
        double sqrt = formula.sqrt(2);
        System.out.println(cal + " " + sqrt);

    
        // Lambda expression
        List<String> names = Arrays.asList("gino", "ethan", "amy", "nishant");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); // o1 preceed o2
            }
        });
        System.out.println(names);
        
        Collections.sort(names,  (String a, String b) -> {return b.compareTo(a);});
        System.out.println(names);
        // for one line method bodies, you can skip both the {} and the return keyword.
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println(names);

        // Functional interfaces
        Converter<Integer, String> converter_0 = (from) -> Integer.valueOf(from);
        Integer a = converter_0.convert("123");
        System.out.println(a);

        // Method and Constructor References
        Converter<Integer, String> converter_1 = Integer::valueOf;
        Integer b = converter_1.convert("321");
        System.out.println(b);

        Dummy dummy = new Dummy();
        Converter<String, String> startWith = dummy::startWith;
        System.out.println(startWith.convert("Java"));

        PersonFactory<Person> pFactory = Person::new;
        Person ethan = pFactory.create("Ethan", "Zhang");
        System.out.println(ethan.getFirstName() + " " + ethan.getLastName());

        // Lambda Scope
        // local variable (must either be decleared or be implicitly final)
        final int num = 1;
        Converter<String, Integer> converter_2 = (from) -> String.valueOf(num + 1);
        System.out.println(converter_2.convert(num));
        // fields and static variables
        LambdaScope ls = new LambdaScope();
        ls.testScope();

        // Predicate
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("ethan");
        predicate.negate().test("ethan");
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> notEmpty = isEmpty.negate();
        System.out.println(nonNull.test(Boolean.FALSE) && isNull.test(null) && isEmpty.test("") && notEmpty.test("s"));
        
        // Functions can chain functions with addThen()
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));

        // Suppliers do not accept arguments
        Supplier<Person> pSupplier = Person::new;
        pSupplier.get();

        // Consumers represents operations to be performed on a single input argument.
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName() + "!");
        greeter.accept(ethan);

        // Optional
        Optional<String> optional_0 = Optional.of("ethan");
        System.out.println("op0 isPresent: "+optional_0.isPresent());
        System.out.println("op1 get: "+optional_0.get());
        Optional<String> optional_1 = Optional.ofNullable(null);
        System.out.println("op1 isPresent: "+optional_1.isPresent());
        System.out.println("orElse: "+optional_1.orElse("ethan"));
    }
}