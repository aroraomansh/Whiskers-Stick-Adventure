public class Score{

    private double currentScore;
    private double bestScore;
    private double cherryCount;

    public Score(double currentScore, double bestScore, double cherryCount) {
        this.currentScore = currentScore;
        this.bestScore = bestScore;
        this.cherryCount = cherryCount;
    }

    public double getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(double currentScore) {
        this.currentScore = currentScore;
    }

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public double getCherryCount() {
        return cherryCount;
    }

    public void setCherryCount(double cherryCount) {
        this.cherryCount = cherryCount;
    }

    @Override
    public String toString() {
        return "Score{" +
                "currentScore=" + currentScore +
                ", bestScore=" + bestScore +
                ", cherryCount=" + cherryCount +
                '}';
    }
}