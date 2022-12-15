package JavaProject;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AssignmentEightPointThree {

    // @UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<>();
    // @UnderTest(id="owners")
    private ArrayList<Owner> owners = new ArrayList<>();

    private InputHandler in = new InputHandler();

    // @UnderTest(id="U8.3")
    public void addDogToOwner() {

        Dog d = findDog(in.readString("Enter the name of the dog"));
        if (d != null && d.getOwner() == null) {

            Owner o = findOwner(in.readString("Enter the name of the new owner"));
            if (o != null) {
                o.assignDog(d);
            }
        } else {
            System.out.println("Error: the dog already has an owner");
        }
    }

    private Owner findOwner(String name) {
        Owner o = null;
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getName().equalsIgnoreCase(name)) {
                o = owners.get(i);
            }
        }
        if (o == null) {
            System.out.println("Error: no owner with that name");
        }
        return o;
    }

    private Dog findDog(String name) {
        Dog d = null;
        for (int i = 0; i < dogs.size(); i++) {
            if (dogs.get(i).getName().equalsIgnoreCase(name)) {
                d = dogs.get(i);
            }
        }
        if (d == null) {
            System.out.println("Error: no dog with that name");
        }
        return d;
    }

    @Test
    public void tester() {

        dogs.add(new Dog("BOB1", "FISK1", 7, 64));
        dogs.add(new Dog("Boll", "LINGLONG", 5, 41));
        dogs.add(new Dog("BOLO", "CingCHONG", 21, 22));
        dogs.add(new Dog("MEJO", "Bong", 4, 61));
        dogs.add(new Dog("DSA", "BING", 6, 43));
        dogs.add(new Dog("POP", "Balla", 7, 10));
        dogs.add(new Dog("FOSK", "jalla", 9, 42));

        owners.add(new Owner("adam"));
        owners.add(new Owner("Diego"));
        owners.add(new Owner("Olle"));
        owners.add(new Owner("bobbo"));
        owners.add(new Owner("fiskus"));
        owners.add(new Owner("Diskus"));
        owners.add(new Owner("TOM"));

        addDogToOwner();

        // System.out.println("**"+dogs.get(1).getOwner());
        for (int i = 0; i < owners.get(1).getDogs().length; i++) {
            System.out.println(owners.get(1).getDogs()[i].toString());
        }

        addDogToOwner();
        for (int i = 0; i < owners.get(1).getDogs().length; i++) {
            System.out.println(owners.get(1).getDogs()[i].toString());
        }
        // System.out.println("*"+dogs.get(1).getOwner());
    }
}
