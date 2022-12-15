package JavaProject;
//@autor Bill Rosander bijo4628

import java.util.ArrayList;

public class AssignmentSevenPointOne {
    private InputHandler in = new InputHandler();

    // @UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<Dog>();

    // @UnderTest(id="U7.1")
    public void dogToList() {
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