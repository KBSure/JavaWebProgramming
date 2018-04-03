package playsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PlaySystemConfig {

    @Bean
    public Dice dice(){
        return new Dice(6);
    }

    @Bean
    public Player player1(){
        Player player = new Player();
        player.setDice(dice());
        player.setName("KBS");
        return player;
    }
    @Bean
    public Player player2(){
        Player player = new Player();
        player.setDice(dice());
        player.setName("SBS");
        return player;
    }
    @Bean
    public Player player3(){
        Player player = new Player();
        player.setDice(dice());
        player.setName("MBC");
        return player;
    }

    @Bean
    public List<Player> playerList(){
        List<Player> list = new ArrayList<>();

        list.add(player1());
        list.add(player2());
        list.add(player3());
        return list;
    }

    @Bean
    public Game game(){
        Game game = new Game();
        game.setPlayerList(playerList());
        return game;
    }


}
