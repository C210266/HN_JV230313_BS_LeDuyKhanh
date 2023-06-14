package ra.business.config;

public class Validate {
    public static boolean checkBookDescrip(String descrip) {
        if (descrip == null && descrip.length() <= 10) {
            System.out.println("Mo ta phai khac rong va hon 10 ki tu");
            return true;
        }
        return false;
    }
}
