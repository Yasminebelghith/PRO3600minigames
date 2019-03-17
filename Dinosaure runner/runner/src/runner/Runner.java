package runner;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Runner extends Application {
	int score = 0;
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		
		stage.setTitle("Runner dinosaur");
		Group group = new Group();
		Scene scene = new Scene(group);
	    stage.setScene(scene);
	    Canvas canevas = new Canvas(640, 540);
	    group.getChildren().add(canevas);
	    stage.setResizable(false);
	    GraphicsContext gc = canevas.getGraphicsContext2D();
	    
	    //liste obstacles et bonus
	    ArrayList<Objet> list_objet = new ArrayList<Objet>();
	    double vitesse_objets = -3;
	    for (int i=0; i<5; i++) {
	    	double a = Math.random();
	    	if (a<0.25) {
	    		Tronc tronc_i = new Tronc();
	    		tronc_i.setPosition(620, 310);
			    tronc_i.setSpeed(vitesse_objets,0);
			    list_objet.add(tronc_i);
	    	} else if (a<0.5) {
	    		Boule_de_feu bdf_i = new Boule_de_feu();
	    		bdf_i.setPosition(620, 310);
			    bdf_i.setSpeed(vitesse_objets,0);
			    list_objet.add(bdf_i);
	    	} else if (a<0.75) {
	    		Trefle trefle_i = new Trefle();
	    		trefle_i.setPosition(620, 310);
			    trefle_i.setSpeed(vitesse_objets,0);
			    list_objet.add(trefle_i);
	    	} else {
	    		Coeur coeur_i = new Coeur();
	    		coeur_i.setPosition(620, 310);
			    coeur_i.setSpeed(vitesse_objets,0);
			    list_objet.add(coeur_i);
	    	}  
	    }
	    
	    Dinosaure dino = new Dinosaure("dino.png",62,36);
	    dino.x=0;
	    dino.y=310;
	    dino.render(gc);
	    
	    AnimationTimer animation = new AnimationTimer() {
		    public void handle (long now) {
		    	//mise en place de l'image de fond
			    Image image = new Image("prairie.jpg",640,540,false,false);
			    gc.drawImage(image,0,0);
			    
			    //génération d'obstacles
			    Iterator<Objet> it = list_objet.iterator();
			    Objet o = it.next();
			    o.x+=o.xSpeed;
			    dino.render(gc);
			    if (o.x==-19) {
			    	it.remove();
			    }
			    if (!dino.intersecte(o)) {
			    	o.render(gc);
			    } else {
			    	score+=o.points;
			    	it.remove();
			    }
			    
			    
			    //mise en forme de l'interface graphique
			    gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 24));
			    gc.setFill(Color.TURQUOISE);
			    gc.setStroke(Color.BLUE);
			    gc.setLineWidth(1);
		        gc.fillText("Score: "+score, 510, 36);
			    gc.strokeText("Score: "+score, 510,36);
			    
			    
			    //controle du dino avec le clavier
			    EventHandler<KeyEvent> event = new EventHandler<KeyEvent>() {
				    public void handle (KeyEvent e) {
					    switch(e.getCode()) {
					    case UP:    dino.y-=10 ; break;
					    case DOWN:  dino.y+=10 ; break;
					    default:
					    }
					    if (dino.y>310) { //le dino ne peut pas passer sous terre
					    	dino.y = 310;
					    }
					    dino.render(gc);
				    };
			    };
			    scene.setOnKeyPressed(event);
			    
			    
			    if (!it.hasNext() && o.x==-30) {
			    	gc.fillText("FIN DU JEU Score: "+score,320,220);
				    gc.strokeText("FIN DU JEU Score: "+score,320,220);
			    }
			  
		    }; 
	    };
	    animation.start();
        stage.show();
	}

}
