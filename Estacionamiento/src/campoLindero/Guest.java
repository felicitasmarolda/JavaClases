package campoLindero;

import java.util.ArrayList;

public class Guest extends Car{
    public int peopleInCar;
    public Integer price = 150;

    public Guest(int peopleInCar){
        this.peopleInCar = peopleInCar;
    }

    public int peopleInCar() {
        return peopleInCar;
    }

    @Override
    public Integer price() {
        return price;
    }
}
