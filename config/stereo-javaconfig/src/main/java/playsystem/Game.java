package playsystem;

import java.util.List;

public class Game {
    private List<Player> list;

    public void setPlayerList(List<Player> list) {
        this.list = list;
    }

    public void play(){
        for(Player p : list){
            p.play();
        }
    }

//    nullpointException
}
