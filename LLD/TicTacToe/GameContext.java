public class GameContext {

    private GameState currenState;

    public GameContext() {
        currentState = new XTurnState();
    }

    public void setState(GameState state) {
        this.cuurentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public boolean isGameOver() {
        return currentState.isGameOver();
    }

    public GameState getCurrentState() {
        return currenState;
    }
}
