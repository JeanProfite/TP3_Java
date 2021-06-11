import javax.swing.*; // import des librairies
import java.awt.event.*; // import des librairies

public class MenuConvertisseur extends JMenuBar { // Création de la classe MenuConvertisseur

    JMenu Option, Aide; // initialisation des variables qui formeront notre menu
    JMenuItem configurer, quitter, aPropos; // initialisation des variables qui formeront nos sous menu

    MenuConvertisseur(){ // création du constructeur MenuConvertisseur
        //JMenuBar Mb=new JMenuBar(); // création de la bar de menus en haut de la fenetre
        Option=new JMenu("Option"); // Création du menu Options
        Aide=new JMenu("Aide"); // Création du menu Aide
        configurer=new JMenuItem("Configurer"); // Création du sous-menu configurer
        quitter=new JMenuItem("quitter"); // Création du sous-menu quitter
        aPropos=new JMenuItem("A propos"); // Création du sous-menu a propos
        Option.add(configurer); // ajout du sous-menu configurer dans le menu option
        Option.add(quitter); // ajout du sous-menu quitter dans le menu option
        Aide.add(aPropos); // ajout du sous-menu apropos dans le menu Aide
        add(Option); // ajout du menu option dans la bar de menu
        add(Aide);// ajout du menu Aide dans la bar de menu

        //____________Actions des bouttons________________
        quitter.addActionListener(new ActionListener() {  // Appliquer une action lors de l'appui du bouton
            public void actionPerformed(ActionEvent v) {
                System.exit(0);
            } //Fermeture de la fennetre
        });

        aPropos.addActionListener(new ActionListener() { // Appliquer une action lors de l'appui du bouton
            public void actionPerformed(ActionEvent v) { //Message pop up "A propos"
                JOptionPane.showMessageDialog(new JFrame(), "Cette application vous permet de convertir des euros en dollars. \nAvec la possibilité de changer le taux de change.", "A propos", JOptionPane.INFORMATION_MESSAGE);
                // Affichage d'une fentre avec le texte
            }
    });
        configurer.addActionListener(new ActionListener() { // Appliquer une action lors de l'appui du bouton
            public void actionPerformed(ActionEvent v) {new DialogConfiguration();} //Appel de la methode DialogConfiguration()
    });
    }
}