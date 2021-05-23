package models.entities;

public class StudentSearchByPasses extends Student {

    private int lowerBoundOfUnexcusedPasses;
    private int upperBoundOfUnexcusedPasses;
    private int upperBoundOfAnotherPasses;
    private int lowerBoundOfAnotherPasses;
    private int upperBoundOfSicknessPasses;
    private int lowerBoundOfSicknessPasses;

    public StudentSearchByPasses() {
        super();
    }

    public int getLowerBoundOfUnexcusedPasses() {
        return lowerBoundOfUnexcusedPasses;
    }

    public void setLowerBoundOfUnexcusedPasses(int lowerBoundOfUnexcusedPasses) {
        this.lowerBoundOfUnexcusedPasses = lowerBoundOfUnexcusedPasses;
    }

    public int getUpperBoundOfUnexcusedPasses() {
        return upperBoundOfUnexcusedPasses;
    }

    public void setUpperBoundOfUnexcusedPasses(int upperBoundOfUnexcusedPasses) {
        this.upperBoundOfUnexcusedPasses = upperBoundOfUnexcusedPasses;
    }

    public int getUpperBoundOfAnotherPasses() {
        return upperBoundOfAnotherPasses;
    }

    public void setUpperBoundOfAnotherPasses(int upperBoundOfAnotherPasses) {
        this.upperBoundOfAnotherPasses = upperBoundOfAnotherPasses;
    }

    public int getLowerBoundOfAnotherPasses() {
        return lowerBoundOfAnotherPasses;
    }

    public void setLowerBoundOfAnotherPasses(int lowerBoundOfAnotherPasses) {
        this.lowerBoundOfAnotherPasses = lowerBoundOfAnotherPasses;
    }

    public int getUpperBoundOfSicknessPasses() {
        return upperBoundOfSicknessPasses;
    }

    public void setUpperBoundOfSicknessPasses(int upperBoundOfSicknessPasses) {
        this.upperBoundOfSicknessPasses = upperBoundOfSicknessPasses;
    }

    public int getLowerBoundOfSicknessPasses() {
        return lowerBoundOfSicknessPasses;
    }

    public void setLowerBoundOfSicknessPasses(int lowerBoundOfSicknessPasses) {
        this.lowerBoundOfSicknessPasses = lowerBoundOfSicknessPasses;
    }
}
