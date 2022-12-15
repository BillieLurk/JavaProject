package JavaProject;
//@author Bill Rosander bijo4628
import java.util.ArrayList;

public class AssignmentEightPointTwo {
    //@UnderTest(id="owners")
    private ArrayList<Owner> owners = new ArrayList<>();

    //@UnderTest(id="U8.2")
    public Owner findOwner(String name) {
        Owner o = null;
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                o = owners.get(i);
            }
        }
        return o;
    }
}
