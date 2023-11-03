package campoLindero;

public class Individual extends Car{
    public int peopleInCar;
    public Individual(int peopleInCar){
        this.peopleInCar = peopleInCar;
    }
    @Override
    public int peopleInCar() {
        return peopleInCar;
    }

    @Override
    public Integer price() {
        return 50 + 60*peopleInCar;
    }
}
