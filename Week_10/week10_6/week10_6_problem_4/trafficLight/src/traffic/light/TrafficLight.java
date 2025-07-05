package Week_10.week10_6.week10_6_problem_4.trafficLight.src.traffic.light;

public enum TrafficLight {
    RED(10_000), GREEN(12_000), YELLOW(3_000);

    private final int duration;

    private TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
