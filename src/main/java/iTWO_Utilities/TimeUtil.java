package iTWO_Utilities;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class TimeUtil {
    public static NgWebDriver ngWebDriver;

    public static void longTime() {
        try {
            Thread.sleep(15000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void midTime() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void shortTime() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void veryShortTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static NgWebDriver WaitForSynchronized() {
        ngWebDriver.waitForAngularRequestsToFinish();
        return ngWebDriver;
    }
}
