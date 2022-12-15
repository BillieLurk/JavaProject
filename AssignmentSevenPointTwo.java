package JavaProject;

import java.util.ArrayList;

public class AssignmentSevenPointTwo {
    // @UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<Dog>();

    private InputHandler in = new InputHandler();

    // @UnderTest(id="U7.2")
    public void listDogs() {

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

    // @UnderTest(id="U7.1")
    private void dogToList() {
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
}