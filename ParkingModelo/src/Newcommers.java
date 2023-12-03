public class Newcommers extends Car{
    public Newcommers(int peopleInCar) {
        super(peopleInCar);
    }

    @Override
    public int getMoneyToBeEarned() {
        return 50 + 60*getPeopleInCar();
    }
}
