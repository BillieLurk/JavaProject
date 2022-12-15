package JavaProject;

//@author Bill Rosander bijo4628
import java.util.ArrayList;

public class AssignmentEightPointOne {
    //@UnderTest(id="owners")
    private ArrayList<Owner> owners = new ArrayList<>();
    private InputHandler in = new InputHandler();

    //@UnderTest(id="U8.1")
    public void ownerToList() {
        owners.add(new Owner(in.readString("Name")));
        System.out.println(owners.get(owners.size() - 1).getName() + " added to the register");
    }
}
