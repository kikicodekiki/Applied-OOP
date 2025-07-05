package Week_10.week10_6.week10_6_problem_4.test.src.test;

import Week_10.week10_6.week10_6_problem_4.trafficLight.src.traffic.light.TrafficLight;

public class TrafficLightTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // checks the time at which we start
        long endTime = System.currentTimeMillis();

        long lightStartTime;
        long currentTime;

        while (endTime - startTime <= 90_000) {
            for (TrafficLight light : TrafficLight.values()) {
                System.out.println(light);
                lightStartTime = System.currentTimeMillis();
                currentTime = lightStartTime;
                int lightDuration = light.getDuration();
                while (currentTime - lightStartTime <= lightDuration) {
                    currentTime = System.currentTimeMillis();
                    if(currentTime - startTime >= 90_000) {
                        return;
                    }

                }
            }
            //endTime = System.currentTimeMillis();
        }
    }
}
