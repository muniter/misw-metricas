package cars;

class Application {
    public static void main(String[] args) {
        Car car = new Car();
        Dashboard dashboard = new Dashboard();

        dashboard.printDashboard(car.getMetrics());
        car.accelerate();
        dashboard.printDashboard(car.getMetrics());
        car.stop();
        dashboard.printDashboard(car.getMetrics());
    }
}