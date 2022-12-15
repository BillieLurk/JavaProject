package JavaProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@autor Bill Rosander bijo4628
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class AssignmentSevenPointSix {
    // @UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<>();

    // @UnderTest(id="U7.6.4")
    public int sortDogs() {
        int swaps = 0;
        int len = dogs.size();

        for (int i = 0; i < len - 1; i++) {
            int smallest = findSmallest(i);
            if (compareDog(i, smallest)) {
                swapDog(i, smallest);
                swaps++;
            }
        }
        return swaps;
    }

    // @UnderTest(id="U7.6.2")
    private boolean compareDog(int dog1, int dog2) {
        return dogs.get(dog1).getTailLength() > dogs.get(dog2).getTailLength()
                || dogs.get(dog1).getTailLength() == dogs.get(dog2).getTailLength()
                        && dogs.get(dog1).getName().compareToIgnoreCase(dogs.get(dog2).getName()) > 0;
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
    private void swapDog(int dog1, int dog2) {
        Dog temp = dogs.get(dog1);
        dogs.set(dog1, dogs.get(dog2));
        dogs.set(dog2, temp);
    }

    // @UnderTest(id="U7.6.1.2")
    private void swaper(int dog1, int dog2) {
        Collections.swap(dogs, dog1, dog2);
    }

    @Test
    public void tester() {
        dogs.add(new Dog("pBOB", "0FISK1", 7, 64));
        dogs.add(new Dog("aBOB", "1FISK1", 7, 64));
        dogs.add(new Dog("FOSK", "6jalla", 9, 42));
        dogs.add(new Dog("MEJO", "3Bong", 4, 61));
        dogs.add(new Dog("DSA", "4BING", 6, 43));
        dogs.add(new Dog("POP", "5Balla", 7, 10));
        dogs.add(new Dog("BOLO", "2CingCHONG", 21, 22));
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).toString());
        }

        System.out.println(sortDogs());

        System.out.println("---SORTED---");
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).toString());
        }
    }
}