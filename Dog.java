package JavaProject;

public class Dog {

    private String name;
    private String breed;
    private int age;
    private int weight;
    private Owner owner;
    
    
    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public Dog(String name, String breed, int age, int weight, Owner owner) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;

        this.owner = owner;
    }

    // @UnderTest(id="U8.3")
    //relations logic
    public void assignOwner(Owner owner) {
        if (this.owner == null) {
            this.owner = owner;
            if (!owner.hasOwnerShip(this)) {
                owner.assignDog(this);
            }
        }
    }

    // @UnderTest(id="U8.6")
    public void removeOwner() {
        if (owner != null) {
            owner.removeDog(this);
            this.owner = null;
        }
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void increaseAge(int amount) {
        if (amount > 0) {
            age += amount;
        }
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getTailLength() {
        final double DACHSHUND_TAIL = 3.7;
        if (breed.toLowerCase().equals("tax") || breed.toLowerCase().equals("dachshund")) {
            return DACHSHUND_TAIL;
        } else {
            return ((double) age * (double) weight) / 10;
        }
    }

    public String toString() {
        return name + " " + breed + " " + age + " " + weight + " " + getTailLength();
    }

}
