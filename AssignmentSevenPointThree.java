package JavaProject;
//@autor Bill Rosander bijo4628
import java.util.ArrayList;

public class AssignmentSevenPointThree {
    //@UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<Dog>();
    
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