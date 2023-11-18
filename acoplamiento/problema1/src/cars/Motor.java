package cars;

import java.util.Map;

public class Motor {

    private int speed;
    private int rpm;
    private float oilLevel;
    private float gasLevel;

    public Motor() {

    }

    public void accelerate() {
        this.rpm += 100;
        this.speed += 10;
        this.oilLevel -= 0.1F;
        this.gasLevel -= 0.5F;
    }

    public void stop() {
        this.oilLevel -= 0.1F;
    }

    public Map<String, Object> getMetrics() {
        Map<String, Object> metrics = new java.util.HashMap<String, Object>();
        metrics.put("speed", this.speed);
        metrics.put("rpm", this.rpm);
        metrics.put("oilLevel", this.oilLevel);
        metrics.put("gasLevel", this.gasLevel);
        return metrics;
    }
}
