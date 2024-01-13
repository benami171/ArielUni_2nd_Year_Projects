public class ConcretePlayer implements Player {

    private int wins;
    private boolean isPlayerOne;

    public void addWin(){
        this.wins++;
    }
    public void resetWins(){
        this.wins = 0;
    }
     @Override
    public int getWins() {
        return this.wins;
    }
    public ConcretePlayer(boolean isPlayerOne) {
        this.isPlayerOne = isPlayerOne;
        this.wins = 0;
    }
    @Override
    public boolean isPlayerOne() {
        return isPlayerOne;
    }

}
