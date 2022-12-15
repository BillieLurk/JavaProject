package JavaProject;

import java.util.ArrayList;
import java.util.Arrays;

public class DogMaster {

    private static final String REGISTER_NEW_DOG = "register new dog";
    private static final String LIST_DOGS = "list dogs";
    private static final String INCREASE_AGE = "increase age";
    private static final String REMOVE_DOG = "remove dog";
    private static final String REGISTER_NEW_OWNER = "register new owner";
    private static final String GIVE_DOG = "give dog";
    private static final String LIST_OWNERS = "list owners";
    private static final String REMOVE_OWNED_DOG = "remove owned dog";
    private static final String REMOVE_OWNER = "remove owner";
    private static final String EXIT = "exit";

    // @UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<>();
    // @UnderTest(id="owners")
    private ArrayList<Owner> owners = new ArrayList<>();

    private InputHandler in = new InputHandler();

    public void run() {
        boolean run = true;
        while (run) {
            String input = in.readString("Command").toLowerCase();

            switch (input) {
                case REGISTER_NEW_DOG:
                    registerDog();
                    break;

                case LIST_DOGS:
                    listDogs();
                    break;

                case INCREASE_AGE:
                    increaseAge();
                    break;

                case REMOVE_DOG:
                    removeDog();
                    break;

                case REGISTER_NEW_OWNER:
                    registerOwner();
                    break;

                case GIVE_DOG:
                    addDogToOwner();
                    break;

                case LIST_OWNERS:
                    listOwners();
                    break;

                case REMOVE_OWNED_DOG:
                    removeOwnedDog();
                    break;

                case REMOVE_OWNER:
                    removeOwner();
                    break;

                case EXIT:
                    run = false;
                    System.out.println("Terminating program");
                    break;

                default:
                    System.out.println("Invalid Command!");
                    break;
            }
        }
    }

    // @UnderTest(id="U7.4")
    private void increaseAge() {
        String input = in.readString("Enter the name of the dog");
        Dog d = findDog(input);
        if (d != null) {
            dogs.get(dogs.indexOf(d)).increaseAge(1);
        } else {
            System.out.println("Error: no such dog");
        }
    }

    // @UnderTest(id="U7.1")
    private void registerDog() {
        dogs.add(createDog());
        System.out.println(dogs.get(dogs.size() - 1).getName() + " added to the register");
    }

    // @UnderTest(id="U6.4")
    private Dog createDog() {
        return new Dog(
                in.readString("Vad är namnet på hunden"),
                in.readString("Vad är det för ras"),
                in.readInt("Hur gammal är hunden"),
                in.readInt("Hur mycket väger hunden"));
    }

    private void printListItem(Owner o) {
        o.printOwnedDogs();

        /*
         * System.out.print(o.getName() + " [");
         * String names = "";
         * for (Dog d : o.getDogs()) {
         * if (d.getOwner() != null) {
         * if (names.equals("")) {
         * names += d.getName();
         * } else {
         * names += ", " + d.getName();
         * }
         * }
         * }
         * System.out.print(names);
         * System.out.print("]\n");
         */
    }

    // @UnderTest(id="U8.4")
    private void listOwners() {
        if (!owners.isEmpty()) {
            for (Owner o : owners) {
                printListItem(o);
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
            sortDogs();
            for (int i = 0; i < dogs.size(); i++) {
                if (dogs.get(i).getTailLength() >= tail) {
                    Dog d = dogs.get(i);
                    printListDog(d);
                }
            }
        } else {
            System.out.println("Error: no dogs in register");
        }
    }

    private void printListDog(Dog d) {
        if (d.getOwner() != null) {
            System.out.println("* " + d.getName() + " (" + d.getBreed() + ", " + d.getAge() + " years, "
                    + d.getWeight() + " kilo, " + d.getTailLength() + " cm tail, owned by "
                    + d.getOwner().getName() + ")");
        } else {
            System.out.println("* " + d.getName() + " (" + d.getBreed() + ", " + d.getAge() + " years, "
                    + d.getWeight() + " kilo, " + d.getTailLength() + " cm tail)");
        }
    }

    // @UnderTest(id="U7.6.4")
    private void sortDogs() {
        for (int i = 0; i < dogs.size() - 1; i++) {
            int smallest = findSmallest(i);
            if (compareDog(i, smallest)) {
                swapDog(i, smallest);
            }
        }
    }

    // @UnderTest(id="U7.6.2")
    private boolean compareDog(int dogOne, int dogTwo) {
        // Method returns true if a the two dogs is not in order
        // first line: compare dog tail
        // second and third: if the dogs has the same tail length AND if they are not in
        // alphabetical order

        return dogs.get(dogOne).getTailLength() > dogs.get(dogTwo).getTailLength()
                || dogs.get(dogOne).getTailLength() == dogs.get(dogTwo).getTailLength()
                        && dogs.get(dogOne).getName().compareToIgnoreCase(dogs.get(dogTwo).getName()) > 0;
    }

    // @UnderTest(id="U7.6.3")
    private int findSmallest(int index) {
        int smallest = index;
        for (int j = index; j < dogs.size(); j++) {
            if (compareDog(smallest, j)) {
                smallest = j;
            }
        }
        return smallest;
    }

    // @UnderTest(id="U7.6.1.1")
    private void swapDog(int dogOne, int dogTwo) {
        Dog temp = dogs.get(dogOne);
        dogs.set(dogOne, dogs.get(dogTwo));
        dogs.set(dogTwo, temp);
    }

    // @UnderTest(id="U8.8")
    private void removeDog() {
        String input = in.readString("Enter the name of the dog");
        Dog d = findDog(input);
        if (d != null) {
            d.removeOwner();
            dogs.remove(d);

            System.out.println(d.getName() + " is removed from the register");
        } else {
            System.out.println("Error: no such dog");
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

    // @UnderTest(id="U7.3")
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

    // @UnderTest(id="U8.1")
    private void registerOwner() {
        owners.add(new Owner(in.readString("Name")));
        System.out.println(owners.get(owners.size() - 1).getName() + " added to the register");
    }

    // @UnderTest(id="U8.3")
    private void addDogToOwner() {
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

    // @UnderTest(id="U8.6")
    private void removeOwnedDog() {
        Dog dog = findDog(in.readString("Enter the name of the dog"));
        if (dog != null) {
            if (dog.getOwner() != null) {
                System.out.println(dog.getName() + " is removed from " + dog.getOwner());
                dog.removeOwner();

            } else {
                System.out.println("Error: " + dog.getName() + " is not owned by anyone");
            }
        }
    }

    // @UnderTest(id="U8.7")
    private void removeOwner() {

        Owner owner = findOwner(in.readString("Enter the name of the user"));
        if (owner != null) {
            owner.removeOwnedDogs(dogs);
            owners.remove(owner);
        }
    }
}