package runner;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Objet {
	Image image;
	double largeur;
	double hauteur;
	double x;
	double y;
	double xSpeed;
	double ySpeed;
	double width;
	double height;
	int points;
	
	Objet(String name, double largeur, double hauteur,double width, double height,int points) {
		this.image = new Image(name,largeur, hauteur, false, false);
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.width = width;
		this.height = height;
		this.points = points;
	}
	
	public void render(GraphicsContext gc) {
		gc.drawImage(this.image,x,y);
	}
	
	public void setSpeed(double xSpeed, double ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public void setPosition(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	
	public void validatePosition(){
		if (largeur + x >= width) {
			x = 0;
		} else if (x<0) {
			x=0;
		}
	}

}
