package JavaProject;
//@autor Bill Rosander bijo4628
import java.util.ArrayList;

public class AssignmentSevenPointFive {
    // @UnderTest(id="dogs")
    private ArrayList<Dog> dogs = new ArrayList<Dog>();

    // @UnderTest(id="owners")
    private ArrayList<Owner> owners = new ArrayList<Owner>();

    private InputHandler in = new InputHandler();

    //@UnderTest(id="U7.5")
    public void removeDog() {
        String input = in.readString("Enter the name of the dog");
        Dog d = findDog(input);
        if (d != null) {
            d.removeOwner();
            dogs.remove(d);
            
            System.out.println(d.getName()+" is removed from the register");
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

    //@UnderTest(id="U7.3")
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
}