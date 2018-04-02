package playsystem;

public class Dice {
    private int face;

    Dice(int face){
        this.face = face;
    }

    public int getNumber(){
        return (int)(Math.random()*face) + 1;
    }


}
