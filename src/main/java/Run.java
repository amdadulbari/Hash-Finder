import apis.Hashtoolkit;
import apis.Leakz;
import apis.NitrxGen;
import constants.SettingsConstant;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner hashScanner = new Scanner(System.in);
        System.out.println(SettingsConstant.APP_TITLE);
        System.out.print("\n\n\n\nPlease Enter the hash: ");
        String hash = hashScanner.nextLine();
        System.out.println("Please Wait . . . . ");


        Hashtoolkit hashtoolkit = new Hashtoolkit();
        boolean success = hashtoolkit.doCrack(hash);
        if (success == false) {
            Leakz leakz = new Leakz();
            success = leakz.doCrack(hash);
        }
        if (success == false) {
            NitrxGen nitrxGen = new NitrxGen();
            success = nitrxGen.doCrack(hash);
        }
        if (success == false) {
            System.out.println("Unable to Crack the Hash !");
        }

    }
}
