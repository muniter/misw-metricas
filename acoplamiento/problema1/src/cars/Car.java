package cars;

import java.util.Map;

public class Car {
	private Motor motor;

	public Car(Motor motor) {
		this.motor = motor;
	}

	public Car() {
		this.motor = new Motor();
	}
	
	public void accelerate() {
		this.motor.accelerate();
	}
	
	public void stop() {
		this.motor.stop();
	}

	public Map<String, Object> getMetrics() {
		return this.motor.getMetrics();
	}
}
