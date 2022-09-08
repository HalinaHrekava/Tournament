import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class GameTest {

    Player player = new Player(1, "Vasya", 6);
    Player player1 = new Player(2, "Ira", 2);
    Player player2 = new Player(3, "Marina", 4);
    Player player3 = new Player(4, "Oleg", 8);
    Player player4 = new Player(5, "Lena", 5);
    Player player5 = new Player(6, "Sasha", 4);

    private Game game = new Game();

    @Test
    public void findName (){
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.findByName("Sasha");
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void roundOneWinSecond() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Ira", "Lena");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void roundTwoWinFirst() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Oleg", "Vasya");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void roundThreeDraw() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Marina", "Sasha");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void NotRegisteredPlayers() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Olya", "Roma");

        });
    }

    @Test
    public void FirstPlayerNotRegistered() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Olya", "Ira");

        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Marina", "Roma");

        });
    }

}