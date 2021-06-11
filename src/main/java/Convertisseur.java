import javax.swing.*; // import des librairies
import java.awt.*; // import des librairies
import java.awt.event.*; // import des librairies

public class Convertisseur extends JFrame implements ActionListener{ // création de la classe Convertisseur

    public JTextField TEuro, TDollars; // initialisation du champ de texte Teuro et Tdollars
    public JButton bp; // initialisation du bouton bp
    public boolean isNumeric = false; //initialisation d'une variable boolean is numeric et attribution a "false"
    public static double taux=1.35; // initialisation d'une variable static double taux et attribution de 1,35
    protected JComboBox liste = new JComboBox();

    public Convertisseur() { // création du constructeur

        //Création de la fenêtre et du container
        setTitle("Convertisseur 2.0"); // Création du titre de la fenetre
        Container panneau = getContentPane(); // Création du container panneau
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
        TEuro = new JTextField("0.0",10); // création du champ de texte vide Teuro
        lEuro.setHorizontalAlignment(JLabel.CENTER); // Positionnement d'un text lEuro sur centre
        pEuro.add(TEuro, BorderLayout.EAST); // ajout de l'affichage pEuro dans la sous-partie sud
        pNord.add(pEuro, BorderLayout.WEST); // ajout de l'affichage pNord dans la sous-partie ouest

        JPanel pDollars = new JPanel(new BorderLayout()); // création d'un affichage pDollars
        JPanel pDollarsBis = new JPanel(new FlowLayout()); // création d'un affichage pDollars
        JLabel lDollars = new JLabel("Dollars"); // création d'un texte lDollars
        pDollars.add(lDollars, BorderLayout.NORTH); //ajout de l'affichage pDollars dans la sous-partie nord
        TDollars = new JTextField("0.0",10);// création du champ de texte "0.0" TDollars
        TDollars.setEditable(false); // interdit a l'utilisateur d'entrer une donnée
        lDollars.setHorizontalAlignment(JLabel.CENTER); // Positionnement d'un text lDollars
        pDollarsBis.add(TDollars, BorderLayout.SOUTH); // ajout de l'affichage pDollars dans la sous-partie sud
        pDollars.add(pDollarsBis, BorderLayout.SOUTH); // ajout de l'affichage pDollars dans la sous-partie sud
        pNord.add(pDollars, BorderLayout.SOUTH); // ajout de l'affichage pNord dans la sous-partie est

        //__________________________Menu déroulant séléction devise_______________________

        liste.setPreferredSize(new Dimension(100,20)); // dimension de la liste
        liste.addItem("Dollar"); // ajout de l'item Dollar dans la liste
        liste.addItem("Yen"); // ajout de l'item Yen dans la liste
        liste.addItem("Livre"); // ajout de l'item Livre dans la liste
        liste.addItem("Dirham"); // ajout de l'item Dirham dans la liste
        pNord.add(liste, BorderLayout.EAST); // ajout de la liste dans pNord

        //_________________________Sous fenetre Centre_______________________________
        //Contient un label
        JLabel lConvert = new JLabel ("Taux de conversion: 1 € = "+taux+"$"); // création d'un label lConvert
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
    //______________________Event du menu déroulant________________________
    /*public void actionPerformed( ActionEvent e){
        try {
            String strEuros = TEuro.getText().replace(",",".");

            double val=Double.parseDouble(strEuros); // récupération de la valeur euro entrée par l'utilisateur
            System.out.println(val);
            int item = liste.getSelectedIndex();
            TDollars.setText(""+CurrencyFormatter.formatte(convertir(val,item),2,CurrencyFormatter.USD));
        }
        catch(NumberFormatException ex) { // récupère toute les excpetions
            JOptionPane.showMessageDialog(null, "Entrez un nombre !!!", "WARNING", JOptionPane.ERROR_MESSAGE);
        }
    }*/
/*public  void convertir(double val,int devise){

}*/




    //______________________Event du boutton________________________
    public void actionPerformed( ActionEvent e){
        double Dollars =0; // initialisation de la variable double dollars
        try {
            Double.parseDouble(TEuro.getText()); // récupération de la valeur euro entrée par l'utilisateur
            isNumeric = true;
        }catch(NumberFormatException f) { // récupère toute les excpetions
            isNumeric = false;
        }
        if(isNumeric) { // si isnumeric == TRUE
            double Euro = Double.parseDouble(TEuro.getText()); // attribution de la valeur entrée par l'utilisateur dans la variable double euro
            Dollars = Euro*taux; // calcul de la conversion
            TDollars.setText(String.valueOf(Dollars)); // affichage de la valeur retourner par le calcul dans l'affichage de la fenetre
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Entrez un nombre !!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            // si isnumeric == FALSE --> affichage d'une fenetre avec ecrit entrez un nombre
        }
    }

    public static void main(String[] args){ // création du main
        Convertisseur cadre = new Convertisseur(); // appel du constructeur
    }
}
