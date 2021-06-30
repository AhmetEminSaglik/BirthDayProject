package errormessage;

class InterruptProcess {

    public static void killProcess(String error) {
        try {
            throw new Exception(error);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }

    }

}
