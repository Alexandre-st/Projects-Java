package game;

public class Game {

    private Map map;

    private Player player;
    private Store store;

    public Game(GameInputs gameInputs) {
        this.player = new Player(gameInputs.getPlayerName(), gameInputs.getPlayerCast());
        this.map = new Map();
    }

    public Map getMap() {
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Store getStore() {
        return this.store;
    }
}
