package errormessage;

import java.awt.Toolkit;

class ClassicErrorMessage extends BaseErrorMessage {

    @Override
    public void showMessage(String error) {
        Toolkit.getDefaultToolkit().beep();
        System.out.println(" >>>  CLASIC ERROR --- > " + error);
    }

}
