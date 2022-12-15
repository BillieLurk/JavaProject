package JavaProject;

//@autor Bill Rosander bijo4628
import java.util.ArrayList;

public class AssignmentSevenPointFour {
    //@UnderTest(id="dogs").
    private ArrayList<Dog> dogs = new ArrayList<Dog>();

    InputHandler in = new InputHandler();
    AssignmentSevenPointThree as = new AssignmentSevenPointThree();

    //@UnderTest(id="U7.4")
    public void increaseAge() {
        String input = in.readString("Enter the name of the dog");
        Dog d = as.findDog(input);
        if (d != null) {
            dogs.get(dogs.indexOf(d)).increaseAge(1);
        } else {
            System.out.println("Error: no such dog");
        }
    }
    //@UnderTest(id="U7.3")
    public Dog findDog(String name) {
        Dog d = null;
        ArrayList<Dog> foundDogs = new ArrayList<>();
        for (int i = 0; i < dogs.size(); i++) {
            if (dogs.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                d = dogs.get(i);
            }
        }
        return d;
    }

}