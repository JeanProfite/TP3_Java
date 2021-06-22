import java.text.NumberFormat; // import des librairies

public class CurrencyFormatter { // création de la classe CurrencyFormatter
    public static final String EURO = ""+ (char) (8364); // initialisation de la valeur string euro
    public static final String USD = "$US"; // initialisation de la valeur string usd
    public static final String POUNDS = "£"; // initialisation de la valeur string pounds
    public static final String MAD = "Dirham";
    public static final String YEN = "¥";

    public static String formatte(double v, int nbdec, String monnaieSymb){ // création de la methode formatte
        NumberFormat fmt = NumberFormat.getInstance(); // fmt prend l'instance de NumberFormat
        fmt.setMaximumFractionDigits(nbdec); // nbdec est le nombre maximal de chiffre après la virgule
            fmt.setMinimumFractionDigits(nbdec); // nbdec est le nombre minimal de chiffre après la virgule
            return fmt.format(v) + " " + monnaieSymb; // retourne le chiffre formatter avec le symbole de la monnaie
    }
}
