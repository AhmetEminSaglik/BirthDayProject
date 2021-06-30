package animationwaitingtime;

import static java.lang.Thread.sleep;

public class AnimationWaitingTime extends Thread {

    public void wait(int ms) {
        try {
            sleep(ms);
        } catch (InterruptedException ex) {
            new errormessage.ErrorMessage().appearClassicError(getClass(), "Bekleme suresi hatasi");
        }
    }
}
