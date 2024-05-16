public class Feeder {
    /**
     * The amount of food, in grams, currently in the bird feeder; initialized in
     * the constructor and
     * always greater than or equal to zero
     */
    private int currentFood;

    /**
     * Simulates one day with numBirds birds or possibly a bear at the bird feeder,
     * as described in part (a)
     * Precondition: numBirds > 0
     */
    public void simulateOneDay(int numBirds) {
        double roll = Math.floor(Math.random() * 100); // 0 - 99
        boolean bear = roll >= 95;
        if (bear)
            currentFood = 0;
        else {
            double food = Math.floor(Math.random() * 41) + 10; // 10 - 50
            currentFood -= food * numBirds;
            if (currentFood < 0)
                currentFood = 0;
        }
    }

    /**
     * Returns the number of days birds or a bear found food to eat at the feeder in
     * this simulation,
     * as described in part (b)
     * Preconditions: numBirds > 0, numDays > 0
     */
    public int simulateManyDays(int numBirds, int numDays) {
        int count = 0;
        while (currentFood > 0 && numDays > 0) {
            simulateOneDay(numBirds);
            numDays--;
            count++;
        }
        return count;
    }
    // There may be instance variables, constructors, or methods that are not shown.

    public static void main(String args[]) {
        Feeder f = new Feeder();
        f.currentFood = 1000;
        f.simulateOneDay(5);
        System.out.println(f.simulateManyDays(5, 6));
    }
}
