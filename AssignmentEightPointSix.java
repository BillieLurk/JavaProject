package JavaProject;

import java.util.ArrayList;

import org.junit.Test;

public class AssignmentEightPointSix {

    // @UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<>();
    // @UnderTest(id="owners")
    private ArrayList<Owner> owners = new ArrayList<>();

    private InputHandler in = new InputHandler();

    // @UnderTest(id="U8.6")
    public void removeDog() {
        Dog dog = findDog(in.readString("Enter the name of the dog"));
        if (dog != null) {
            if (dog.getOwner() != null) {
                System.out.println(dog.getName() + " is removed " + dog.getOwner());
                dog.removeOwner();
            } else {
                System.out.println("Error: " + dog.getName() + " is not owned by anyone");
            }
        }
    }

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

    // @UnderTest(id="U8.4")
    public void listOwners() {
        if (!owners.isEmpty()) {
            for (Owner o : owners) {
                System.out.print(o.getName() + " [");
                String names = "";
                for (Dog d : o.getDogs()) {

                    if (d.getOwner() != null) {
                        if (names.equals("")) {
                            names += d.getName();
                        } else {
                            names += ", " + d.getName();
                        }
                    }
                }
                System.out.print(names);
                System.out.print("]\n");
            }
        } else {
            System.out.println("Error: no owners in register");
        }
    }

    // @UnderTest(id="U7.2")
    private void listDogs() {

        if (!dogs.isEmpty()) {
            double tail = in.readDouble("Smallest tail length to display");
            System.out.println("The following dogs has such a large tail:");
            for (int i = 0; i < dogs.size(); i++) {
                if (dogs.get(i).getTailLength() > tail) {
                    Dog d = dogs.get(i);
                    if (d.getOwner() != null) {
                        System.out.println("* " + d.getName() + " (" + d.getBreed() + ", " + d.getAge() + " years, "
                                + d.getWeight() + " kilo, " + d.getTailLength() + " cm tail, owned by "
                                + d.getOwner().getName() + ")");
                    } else {
                        System.out.println("* " + d.getName() + " (" + d.getBreed() + ", " + d.getAge() + " years, "
                                + d.getWeight() + " kilo, " + d.getTailLength() + " cm tail)");
                    }
                }
            }
        } else {
            System.out.println("Error: no dogs in register");
        }
    }

    public void prints() {

        for (Dog dog : owners.get(0).getDogs()) {
            System.out.println(dog.toString());

        }
    }

}