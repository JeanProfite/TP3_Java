import org.jsoup.Jsoup; // import des librairies
import org.jsoup.nodes.Document; // import des librairies
import org.jsoup.nodes.Element; // import des librairies
import org.jsoup.select.Elements; // import des librairies
import java.io.IOException; // import des librairies

public class MaSoup { // création de la classe MaSoup
    public MaSoup() {}
    public static double getTaux(int index){
        double[] taux=new double[188];
        double x;
        int i=0;
        String url="http://www.changemagenta.fr/devises/cours/prix.html"; //on initialise la valeur string url et on y ajoute une adresse
        try {
            Document doc = Jsoup.connect(url).get(); // Initialisation de la valeur document doc qui se connect a l'adresse url
            Elements elements = doc.select("table.tableauItem em.hidden-xs");//On parse tableauItem hidden-xs small
            for(Element e : elements){ // boucle pour parcourir tout les élements

                String[] T = e.text().split(" "); // Initialisation de la varibale caractère T qui récupère le texte de l'élément
                String s = T[3].replace(",","."); // la variable string s permet de remplacer dans T, la virgule par un point
                x = Double.parseDouble(s); // permet de convertir un string en double
                taux[i]=x;
                i++;
            }
        }
        catch (IOException e){ // on regroupe toute les exceptions
            e.printStackTrace(); // affiche l'erreur et l'emplacement
        }
        return taux[index];
    }


    public static void main(String[] str){ // création de la boucle main

    }
}
