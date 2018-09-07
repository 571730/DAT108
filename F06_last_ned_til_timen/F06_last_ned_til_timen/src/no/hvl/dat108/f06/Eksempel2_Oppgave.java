package no.hvl.dat108.f06;
/* Kopiert fra javabrains.io sitt Java 8 Lambda Basics kurs */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Eksempel2_Oppgave {
	
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// 1: Sorter personene på etternavn.

		List<Person> sortertPeople = people.stream().sorted(Comparator.comparing(Person::getLastName))
                .collect(toList());
		sortertPeople.forEach(person -> System.out.println(person.getLastName()));
        System.out.println(" ");

        // Annen måte
        //Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		
		// 2: Skriv ut alle personene, én linje per person. 
		// 		Lag en egen hjelpemetode printAll(...) som gjør dette.

		printAll(people);
		
		// 3: Skriv ut alle personene som har etternavn som begynner på C.
		//		Lag en egen hjelpemetode printLastNameStartsWithC(...) som gjør dette. 
		
        printAllStartsWithC(people);

		// 4: Skriv ut alle personene som har fornavn som begynner på C.
		//		Vi ser nå at det er tungvint å lage én utskriftsmetode per
		//      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
		//		gjør jobben i stedet. Denne tar inn listen + et lambdauttrykk.

        printConditionally(people, x -> x.getLastName().startsWith("C"));
		
		// 5: Skriv ut ALLE personene ved å bruke printConditionally;
        printConditionally(people, a -> true);

        doConditionally(people, p -> p.getAge() > 50, p -> System.out.println(p));
	}

	public static void printAll(List<Person> list){
	    list.stream().forEach(person -> System.out.println(person.toString()));
        System.out.println(" ");
    }

    public static void printAllStartsWithC(List<Person> list){
	    list.stream().filter(person -> person.getLastName().charAt(0) == 'C')
                .forEach(person -> System.out.println(person));
        System.out.println(" ");
    }

    /*
    public static void printConditionally(List<Person> list, Predicate<Person> pred){
	    list.stream().forEach(person -> {
	        if(pred.test(person)){
                System.out.println(person);
            }
        });
    }
    */


    public static void printConditionally(List<Person> list, Function<Person, Boolean> function){
	    list.stream().forEach(person -> {
	        if (function.apply(person)){
                System.out.println(person);
            }
        });
    }

    public static void doConditionally(List<Person> list, Predicate<Person> pred, Consumer<Person> cons){
        list.stream().forEach(person -> {
            if (pred.test(person)){
                cons.accept(person);
            }
        });
    }
}
