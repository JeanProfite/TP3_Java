import org.jsoup.Jsoup; // import des librairies
import org.jsoup.nodes.Document; // import des librairies
import org.jsoup.nodes.Element; // import des librairies
import org.jsoup.select.Elements; // import des librairies
import java.io.IOException; // import des librairies

public class MaSoup { // création de la classe MaSoup
    public static void main(String[] str){ // création de la boucle main
        String url="http://www.changemagenta.fr"; //on initialise la valeur string url et on y ajoute une adresse
        try {
            Document doc = Jsoup.connect(url).get(); // Initialisation de la valeur document doc qui se connect a l'adresse url
            Elements elements = doc.select("table.tableauItem em.hidden-xs");//On parse tableauItem hidden-xs small
            for(Element e : elements){ // boucle pour parcourir tout les élements
                String[] T = e.text().split(" "); // Initialisation de la varibale caractère T qui récupère le texte de l'élément
                String s = T[3].replace(",","."); // la variable string s permet de remplacer dans T, la virgule par un point
                double x = Double.parseDouble(s); // permet de convertir un string en double
                //System.out.println(e.text()); // on affiche le texte de l'élement
                System.out.println(T[1]+": "+x); // on affiche le deuxième caractère de T  et X

            }

        }
        catch (IOException e){ // on regroupe toute les exceptions
            e.printStackTrace(); // affiche l'erreur et l'emplacement
        }
    }
}
