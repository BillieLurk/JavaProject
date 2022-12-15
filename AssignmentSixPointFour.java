package JavaProject;

public class AssignmentSixPointFour {
    private InputHandler in = new InputHandler();

    public Dog createDog(){
        return new Dog(
        in.readString("Vad är namnet på hunden"), 
        in.readString("Vad är det för ras"), 
        in.readInt("Hur gammal är hunden"), 
        in.readInt("Hur mycket väger hunden"));
    }
}