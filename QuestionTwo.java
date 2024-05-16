public class Scoreboard {
    String teamOne;
    String teamTwo;
    int scoreOne;
    int scoreTwo;
    int activeTeam = 1;

    public Scoreboard(String teamOne, String teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.scoreOne = 0;
        this.scoreTwo = 0;
    }

    public String getScore() {
        return scoreOne + "-" + scoreTwo + "-" + (activeTeam == 1 ? teamOne : teamTwo);
    }

    public void recordPlay(int points) {
        if (points <= 0) {
            if (activeTeam == 1)
                activeTeam = 2;
            else
                activeTeam = 1;
        } else {
            if (activeTeam == 1)
                scoreOne += points;
            else
                scoreTwo += points;
        }
    }

    public static void main(String args[]) {
        Scoreboard game = new Scoreboard("Red", "Blue");
        System.out.println(game.getScore());
        game.recordPlay(1);
        System.out.println(game.getScore());
        game.recordPlay(0);
        System.out.println(game.getScore());
        System.out.println(game.getScore());
        game.recordPlay(3);
        System.out.println(game.getScore());
        game.recordPlay(1);
        game.recordPlay(0);
        System.out.println(game.getScore());
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        System.out.println(game.getScore());
        Scoreboard match = new Scoreboard("Lions", "Tigers");
        System.out.println(match.getScore());
        System.out.println(game.getScore());
    }
}
