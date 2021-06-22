import org.jsoup.Jsoup; // import des librairies
import org.jsoup.nodes.Document; // import des librairies
import org.jsoup.nodes.Element; // import des librairies
import org.jsoup.select.Elements; // import des librairies
import java.io.IOException; // import des librairies

public class MaSoup { //Création de la classe MaSoup
    public MaSoup() {} //Création du constructeur
    public static double getTaux(int index){//Création de la methode getTaux qui renvoie le taux n°index de la page web
        double[] taux=new double[188];//Création du tableau taux de 188 valeurs
        double x;//Initialisation de x
        int i=0; //initialisation du compteur i
        String url="http://www.changemagenta.fr/devises/cours/prix.html"; //on initialise la valeur string url et on y ajoute une adresse
        try {
            Document doc = Jsoup.connect(url).get(); // Initialisation de la valeur document doc qui se connect a l'adresse url
            Elements elements = doc.select("table.tableauItem em.hidden-xs");//On parse tableauItem hidden-xs small
            for(Element e : elements){ // boucle pour parcourir tout les élements de "elements"
                String[] T = e.text().split(" ");//On met dans le Tableau T chaque element de "elements" en utilisant l'espace comme séparateur
                String s = T[3].replace(",","."); // la variable string s permet de remplacer la virgule par un point pour le 3em élément de T
                x = Double.parseDouble(s); // on convertie s en double dans x
                taux[i]=x;//On met x (le taux) dans le tableau taux a l'élément n°i
                i++;//on icrémente le compteur
            }
        }
        catch (IOException e){ // on regroupe toutes les exceptions
            e.printStackTrace(); // affiche l'erreur et l'emplacement
        }
        return taux[index]; //On retourne le taux a l'indice index
    }
}
