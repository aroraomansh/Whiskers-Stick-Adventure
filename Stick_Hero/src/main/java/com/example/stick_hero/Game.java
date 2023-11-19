import java.util.List;

public class Game {

    private String phase;
    private List<Platform> platforms;
    private List<Tree> trees;
    private List<Save> saves;

    // Constructor
    public Game(String phase, List<Platform> platforms, List<Tree> trees, List<Save> saves) {
        this.phase = phase;
        this.platforms = platforms;
        this.trees = trees;
        this.saves = saves;
    }

    // Getters and Setters
    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public List<Save> getSaves() {
        return saves;
    }

    public void setSaves(List<Save> saves) {
        this.saves = saves;
    }

    // Methods
    public void resetGame() {
        // Implementation for resetting the game
    }

    public void startGame() {
        // Implementation for starting the game
    }

    public void pauseGame() {
        // Implementation for pausing the game
    }

    public void resumeGame() {
        // Implementation for resuming the game
    }

    public void exitGame() {
        // Implementation for exiting the game
    }

    public void revive() {
        // Implementation for reviving the player or game state
    }

    @Override
    public String toString() {
        return "Game{" +
                "phase='" + phase + '\'' +
                ", platforms=" + platforms +
                ", trees=" + trees +
                ", saves=" + saves +
                '}';
    }
}
