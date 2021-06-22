// import des librairies
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogConfiguration extends JDialog implements ActionListener{ // création de la classe DialogConfiguration qui herite de JDialog
    public JLabel tauxDeChange; // initalisation de l'objet tauxDeChange de type JLabel
    public JButton valider, annuler; // initalisation des objets JButton valider et annuler de type JButton
    public JTextField tTaux; // initalisation de l'objet tTaux de type JTextField
    public double tauxDC=0; // initialisation de la variable tauxDC à 0 (de type double)
    public DialogConfiguration() { // création du constructeur DialogConfiguration
        super (new JFrame(), "TAUX DE CONVERSION", true); //Création de la fenêtre taux de conversion
        setLayout(new FlowLayout()); // configuration de la disposition de l'affichage en Flowlayout
        setLocationRelativeTo(null); // place la fenêtre au centre de l'ecran
        tauxDeChange = new JLabel("Taux de change"); // création du JLabel tauxDeChange
        valider = new JButton("Valider"); // création du JButton valider
        valider.addActionListener(this); // ajout d'une action pour l'appuie du bouton valider
        valider.setActionCommand("Valider"); // permet d'utiliser un actionperformed pour le bouton Valider
        tTaux = new JTextField("",10); // création d'un JTextField tTAux avec une largeur de 10
        annuler = new JButton("Annuler"); // création du JBouton annuler
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
    public void actionPerformed(ActionEvent e) { // création de la méthode actionPerformed
        if(e.getActionCommand() == "Annuler") dispose(); // ajout de l'action fermeture au bouton annuler
        else if(e.getActionCommand() == "Valider"){ // ajout de l'action modification du taux pour le bouton valider
            try{
                Convertisseur.taux=Double.parseDouble(tTaux.getText());//Actualisation du taux
                JOptionPane.showMessageDialog(new JFrame(), "OK", "Changement du taux", JOptionPane.INFORMATION_MESSAGE);
                // affichage d'un message pour valider la valeur entrée ou changer le taux
                dispose(); // Ferme la fenetre
            }
            catch(Exception t) {JOptionPane.showMessageDialog(new JFrame(), "Entrez un nombre !!!", "WARNING", JOptionPane.WARNING_MESSAGE);}
            // attraper toutes les exceptions pour les cas d'erreur
        }
    }
}