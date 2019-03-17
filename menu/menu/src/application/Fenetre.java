package application;

//import java.awt.Color; 
import javax.swing.JFrame;
//import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JButton;
import java.awt.GridLayout;
 
public class Fenetre extends JFrame implements ActionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Score bouton = new Score("Score");
	
public Fenetre(){             
    this.setTitle("Menu principal");
    this.setSize(400, 580);
    this.setLocationRelativeTo(null);               

    this.setLayout(new GridLayout(3, 2));

    this.getContentPane().add(new JButton("jeu 1"));
    this.getContentPane().add(new JButton("jeu 2"));
    this.getContentPane().add(new JButton("jeu 3"));
    this.getContentPane().add(new JButton("jeu 4"));
    this.getContentPane().add(new JButton("jeu 5"));
    this.getContentPane().add(bouton);
    bouton.addActionListener(this);
    
    this.setVisible(true);
  
  }

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	System.out.println("salut ca va");
}       
}