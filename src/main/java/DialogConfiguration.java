import javax.swing.*; // import des librairies
import java.awt.*; // import des librairies
import java.awt.event.*; // import des librairies

public class DialogConfiguration extends JDialog implements ActionListener{ // création de la classe DialogConfiguration
    public JLabel tauxDeChange; // initalisation de la variable label taux de change
    public JButton valider, annuler; // initalisation des variables boutons valider et annuler
    public JTextField tTaux; // initalisation de la variable champ de texte Jttaux
    public double tauxDC=0; // initialisation de la variabel double tauxDC et mise à 0
    public DialogConfiguration() { // création du constructeur DialogConfiguration
        super (new JFrame(), "TAUX DE CONVERSION", true); //Création de la fenêtre taux de conversion

        setLayout(new FlowLayout()); // initialisation de l'affichage
        setLocationRelativeTo(null); // place la fenêtre a l'endroit null
        tauxDeChange = new JLabel("Taux de change"); // création du label taux de change
        valider = new JButton("Valider"); // création du bouton valider
        valider.addActionListener(this); // ajout d'une action pour l'appuie du bouton
        valider.setActionCommand("Valider"); // permet d'utiliser un actionperformed pour le bouton Valider
        tTaux = new JTextField("",10); // création d'un champ de texte tTAux ajouter a la colonne 10
        annuler = new JButton("Annuler"); // création du bouton annuler
        annuler.addActionListener(this); // ajout d'une action pour l'appuie du bouton
        annuler.setActionCommand("Annuler"); // permet d'utiliser un actionperformed pour le bouton annuler
        add(tauxDeChange); // ajout du label taux de change
        add(tTaux); // ajout du texte tTaux
        add(valider); // ajout du bouton valider
        add(annuler); // ajout du bouton annuler
        pack(); //Organise l'affichage des elements
        setVisible(true); // affichage des élements
    }
    //____________Actions des bouttons________________
    public void actionPerformed(ActionEvent e) { // création de la méthode action
        if(e.getActionCommand() == "Annuler") dispose(); // ajout de l'action fermeture au bouton annuler
        else if(e.getActionCommand() == "Valider"){ // ajout de l'action modification du taux pour le bouton valider
            try{
                Convertisseur.taux=Double.parseDouble(tTaux.getText());
                JOptionPane.showMessageDialog(new JFrame(), "OK", "Changement du taux", JOptionPane.INFORMATION_MESSAGE);
                // affichage d'un message pour valider la veleur entrée ou changer le taux
                dispose(); // Ferme la fenetre
            }
            catch(Exception t) {JOptionPane.showMessageDialog(new JFrame(), "Entrez un nombre !!!", "WARNING", JOptionPane.WARNING_MESSAGE);}
            // attraper toute les exceptions pour les cas d'erreur
        }
    }
}