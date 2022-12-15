package JavaProject;

import java.util.ArrayList;

import org.junit.Test;

public class AssignmentEightPointFour {
    // @UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<>();
    // @UnderTest(id="owners")
    private ArrayList<Owner> owners = new ArrayList<>();

    private InputHandler in = new InputHandler();

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

    // @UnderTest(id="U8.3")
    public void addDogToOwner() {

        Dog d = findDog(in.readString("Enter the name of the dog"));
        if (d != null) {
            if (d.getOwner() != null) {
                System.out.println("Error: the dog already has an owner");
            } else {
                Owner o = findOwner(in.readString("Enter the name of the new owner"));
                if (o != null) {
                    o.assignDog(d);
                }
            }
        }
    }

    private Owner findOwner(String name) {
        Owner o = null;
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
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
            if (dogs.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                d = dogs.get(i);
            }
        }
        if (d == null) {
            System.out.println("Error: no dog with that name");
        }
        return d;
    }
}
