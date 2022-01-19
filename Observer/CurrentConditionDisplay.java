package Observer;

import Observer.Interface.DisplayElement;
import Observer.Interface.Observer;
import Observer.Interface.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    public void display(){
        System.out.println("Current conditions: " + temperature +
                                   "F degrees and " + humidity + "% humidity" +
                                   " with pressure " + pressure + "hPa");
    }
    public void update(float temp, float humidity, float pressure){
        //when update is called we save the values and display them
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

}
