package playsystem;

public class Player {
    private String name;
    private Dice dice;

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println(name + "이 던진 주사위가" + dice.getNumber() + "나왔습니다.");
    }
}
