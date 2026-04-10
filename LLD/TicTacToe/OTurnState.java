public class OTurnState implements GameState {
    @Override
    public void next(GameContext content) {
        context.setState(new XTurnState());
    }
    
    @Override
    public boolean isGameOver() {
        return false;
    }
}
