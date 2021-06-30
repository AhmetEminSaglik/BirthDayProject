package errormessage;

public class WarningMessage extends BaseErrorMessage {

    @Override
    public void showMessage(String error) {
        System.out.println(" >>>  WARNING  --- > " + error);
    }

}
