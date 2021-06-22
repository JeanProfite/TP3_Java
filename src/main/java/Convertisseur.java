// import des librairies
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Convertisseur extends JFrame implements ActionListener{ // création de la classe Convertisseur qui herite de JFrame

    public JTextField TEuro, TDollars; // initialisation des objet Teuro et Tdollars de type JTextField
    public JButton bp; // initialisation de l'objet bp de type JButton
    public JLabel lDollars=new JLabel(""), lConvert=new JLabel(""), lMonnaie=new JLabel("");// initialisation des objet lDollars,lConvert et lMonnaie de type JLabel
    public boolean isNumeric = false; //initialisation d'une variable boolean isNumeric et attribution de la valeur "false"
    public static double taux=MaSoup.getTaux(0); // initialisation d'une variable static double taux et apelle de getTaux pour initialiser le taux en dollars
    public static String currency=CurrencyFormatter.USD;// Initialisation de currency au format USD
    protected JComboBox liste = new JComboBox();//Initialisation de l'objet liste de type JComboBox

    public Convertisseur() { // création du constructeur

        //Création de la fenêtre et du container
        setTitle("Convertisseur 2.0"); // Création du titre de la fenetre
        Container panneau = getContentPane(); // Panneau principal
        JPanel pNord = new JPanel(new BorderLayout()); // création de la sous-partie Nord pour afficher les éléments de la fenetre
        panneau.add(pNord, BorderLayout.NORTH); // ajout dans le container
        JPanel pCentre = new JPanel(new BorderLayout());// création de la sous-partie Center pour afficher les éléments de la fenetre
        panneau.add(pCentre, BorderLayout.CENTER); // ajout dans le container
        JPanel pSud = new JPanel(new FlowLayout());// création de la sous-partie Sud pour afficher les éléments de la fenetre
        panneau.add(pSud, BorderLayout.SOUTH); // ajout dans le container

        //_________________________Sous fenetre Nord_______________________________
        //Contient deux labels et les JTextFields

        JPanel pEuro = new JPanel(new BorderLayout());  // création d'un affichage pEuro
        JLabel lEuro = new JLabel("Euro"); // création d'un text lEuro
        pEuro.add(lEuro, BorderLayout.NORTH); // ajout de l'affichage pEuro dans la sous-partie nord
        TEuro = new JTextField("0.0",10); // création du champ de texte vide TEuro
        lEuro.setHorizontalAlignment(JLabel.CENTER); // Positionnement d'un text lEuro sur centre
        pEuro.add(TEuro, BorderLayout.EAST); // ajout de l'affichage pEuro dans la sous-partie est
        pNord.add(pEuro, BorderLayout.WEST); // ajout de l'affichage pNord dans la sous-partie ouest

        JPanel pDollars = new JPanel(new BorderLayout()); // création d'un JPanel pDollars avec une disposition en BorderLayout
        JPanel pDollarsBis = new JPanel(new FlowLayout()); // création d'un JPanel pDollarsBis avec une disposition en FlowLayout
        lDollars.setText("Valeur en Dollar");//Mise a jour du text de lDollars
        pDollars.add(lDollars, BorderLayout.NORTH); //ajout de l'affichage pDollars dans la sous-partie nord
        TDollars = new JTextField(CurrencyFormatter.formatte(0,2,CurrencyFormatter.USD),10);// création d'un JTextField de taille 10 avec "0.0 $" dedans
        TDollars.setEditable(false); // interdit a l'utilisateur d'entrer une donnée
        lDollars.setHorizontalAlignment(JLabel.CENTER); // Positionnement de lDollars au centre
        pDollarsBis.add(TDollars, BorderLayout.SOUTH); // ajout de l'affichage TDollars dans la sous-partie sud de pDollarsBis
        pDollars.add(pDollarsBis, BorderLayout.SOUTH); // ajout de l'affichage pDollarsBis dans la sous-partie de pDollars
        pNord.add(pDollars, BorderLayout.SOUTH); // ajout de l'affichage pDollars dans la sous-partie sud de pNord

        //__________________________Menu déroulant séléction devise_______________________

        JPanel pMonnaie = new JPanel(new BorderLayout()); // création d'un JPanel pMonnaie avec une disposition en BorderLayout
        lMonnaie.setText("Monnaie");//Initialisation du texte de lMonnaie
        lMonnaie.setHorizontalAlignment(JLabel.CENTER); // Positionnement de lMonnaie au centre
        liste.setPreferredSize(new Dimension(100,18)); // dimension de la liste
        liste.addItem("Dollar"); // ajout de l'item Dollar dans la liste
        liste.addItem("Yen"); // ajout de l'item Yen dans la liste
        liste.addItem("Livre"); // ajout de l'item Livre dans la liste
        liste.addItem("Dirham"); // ajout de l'item Dirham dans la liste
        pMonnaie.add(lMonnaie, BorderLayout.NORTH);// ajout de lMonnaie dans la sous-partie nord de pMonnaie
        pMonnaie.add(liste, BorderLayout.CENTER); // ajout de liste dans la sous-partie centre de pMonnaie
        pNord.add(pMonnaie, BorderLayout.EAST); // ajout de pMonnaie dans la sous-partie est de pNord
        liste.addActionListener(this); // ajout d'un ActionListner pour le la liste

        //_________________________Sous fenetre Centre_______________________________
        //Contient un label

        lConvert.setText("Taux de conversion: 1 $US = "+taux+" €");
        lConvert.setHorizontalAlignment(JLabel.CENTER); // positionnement au centre de lConvert
        pCentre.add(lConvert,BorderLayout.CENTER); // ajout du label lConvert

        //_________________________Sous fenetre Sud_______________________________
        //Contient le bouton

        bp = new JButton("CONVERTIR"); // création du bouton Convertir
        pSud.add(bp); // ajout du bouton dans pSud
        bp.addActionListener(this); // ajout d'une action pour le bouton

        //Affectation de l'action fermeture lors du clique sur le bouton X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fermeture de la fenêtre su appuie sur la croix de la fenêtre
        setJMenuBar(new MenuConvertisseur());
        setSize(300,200); //Réglage de l'affichage de la fenetre
        setVisible(true); // affichage de la fenetre
    }
    public void actionPerformed( ActionEvent e){
        Object source = e.getSource();
        //______________________Event du menu déroulant________________________
        //______________________Event du boutton________________________

        if (source == liste) {//Entre dans le if si l'utilisateur change de devise
            switch(liste.getSelectedIndex()) {//selon la devise séléctionner on met a jour "taux" et "currency" qui est utilisé pour mettre la devise au bon format
                case 0: //Cas pour les Dollars
                    taux=MaSoup.getTaux(0);//La variable taux prend la valeur du taux du Dollars
                    currency=CurrencyFormatter.USD;//La variable currency prend la valeur $US
                    break;
                case 1:
                    taux=MaSoup.getTaux(6)/100;
                    currency=CurrencyFormatter.YEN;
                    break;
                case 2:
                    taux=MaSoup.getTaux(2);
                    currency=CurrencyFormatter.POUNDS;
                    break;
                case 3:
                    taux=MaSoup.getTaux(120)/100;
                    currency=CurrencyFormatter.MAD;
                    break;
            }
        }
            try {
                String strEuros = TEuro.getText().replace(",", ".");
                double val = Double.parseDouble(strEuros); // récupération de la valeur euro entrée par l'utilisateur
                int item = liste.getSelectedIndex();
                TDollars.setText("" + CurrencyFormatter.formatte(convertir(val, item), 2, currency));
            } catch (NumberFormatException ex) { // récupère toute les excpetions
                JOptionPane.showMessageDialog(null, "Entrez un nombre !!!", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
    }

public  double convertir(double val,int devise){
    double Dollars =0; // initialisation de la variable double dollars
    try {
        Double.parseDouble(TEuro.getText()); // récupération de la valeur euro entrée par l'utilisateur
        isNumeric = true;
    }catch(NumberFormatException f) { // récupère toute les excpetions
        isNumeric = false;
    }
    if(isNumeric) { // si isnumeric == TRUE
        double Euro = Double.parseDouble(TEuro.getText()); // attribution de la valeur entrée par l'utilisateur dans la variable double euro
        Dollars = Euro/taux; // calcul de la conversion
        TDollars.setText(String.valueOf(Dollars)); // affichage de la valeur retourner par le calcul dans l'affichage de la fenetre
        lConvert.setText("Taux de conversion: " +CurrencyFormatter.formatte(1, 0, currency)+" = "+CurrencyFormatter.formatte(taux, 4, CurrencyFormatter.EURO));
        lDollars.setText("Valeur en "+(String) liste.getSelectedItem());
    }
    else{
        JOptionPane.showMessageDialog(new JFrame(), "Entrez un nombre !!!", "WARNING", JOptionPane.WARNING_MESSAGE);
        // si isnumeric == FALSE --> affichage d'une fenetre avec ecrit entrez un nombre
    }
    return Dollars;
}


    public static void main(String[] args){ // création du main
        Convertisseur cadre = new Convertisseur(); // appel du constructeur
    }
}
