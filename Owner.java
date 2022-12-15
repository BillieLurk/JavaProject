package JavaProject;

import java.util.ArrayList;
import java.util.Arrays;

public class Owner {

    private String name;
    private Dog[] myDogs = new Dog[0];

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Dog[] getDogs() {
        Dog[] myDogsCopy = new Dog[myDogs.length];
        System.arraycopy(myDogs, 0, myDogsCopy, 0, myDogs.length);
        return myDogsCopy;
    }

    // @UnderTest(id="U8.3")
    // relations logic
    public void assignDog(Dog dog) {
        if (dog.getOwner() == null) {
            if (!hasOwnerShip(dog)) {
                addDogToArray(dog);
                if (dog.getOwner() != this) {
                    dog.assignOwner(this);
                }
            }
        }
    }

    private void addDogToArray(Dog dog) {
        myDogs = Arrays.copyOf(myDogs, myDogs.length + 1);
        myDogs[myDogs.length - 1] = dog;
    }

    // @UnderTest(id="U8.6")
    public void removeDog(Dog dog) {

        if (hasOwnerShip(dog)) {
            Dog[] temp = new Dog[myDogs.length - 1];
            dog.assignOwner(null);

            if (myDogs.length > 1) {
                for (int i = 0, j = 0; i < myDogs.length; i++) {
                    if (dog != myDogs[i]) {

                        temp[j++] = myDogs[i];
                    }
                }
                myDogs = temp;
            } else {
                myDogs = new Dog[0];
            }
        }
    }

    public void removeOwnedDogs(ArrayList<Dog> dogs) {
        for (Dog dog : myDogs) {
            dogs.remove(dog);
        }
    }

    public void printOwnedDogs() {

        // should be a string builder
        System.out.print(getName() + " [");
        String names = "";
        for (Dog d : myDogs) {
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

    // @UnderTest(id="U8.5")
    public boolean hasOwnerShip(Dog d) {
        for (Dog dog : myDogs) {
            if (dog == d) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return name;
    }
}
