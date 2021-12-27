/* Authors: Frejoux Gaetan & Niord Mathieu */

/* -------------------------------------
| This class is a utility class.        |
| This is where all the "tools" methods |
| are defined.                          |
 --------------------------------------- */

import java.util.Scanner;

public class Utils {

    //Scanner for user's inputs
    public static final Scanner SCANNER = new Scanner(System.in);

    static int getIntegerInput() {
        try {
            return SCANNER.nextInt();
        }
        catch (Exception e){
            return getIntegerInput();
        }
    }
}
