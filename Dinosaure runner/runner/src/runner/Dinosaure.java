package runner;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Dinosaure {
	Image image;
	double largeur;
	double hauteur;
	double x;
	double y;
	double xSpeed;
	double ySpeed;
	
	Dinosaure(String name, double largeur, double hauteur) {
		this.image = new Image(name,largeur, hauteur, false, false);
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	public void render(GraphicsContext gc) {
		gc.drawImage(this.image,x,y);
	}
	
	public void setSpeed(double xSpeed, double ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	
	public void validatePosition(){
		if (largeur + x >= 640) {
			x = 0;
		} else if (x<0) {
			x=0;
		}
	}
	
	public boolean intersecte(Objet o) {
		if (o.y+o.hauteur >=this.y && o.y+o.hauteur <= this.y+this.hauteur && o.x+o.largeur >= this.x && o.x+o.largeur <= this.x+this.largeur){
			return true;
		}
		if (o.y+o.hauteur >=this.y && o.y+o.hauteur <= this.y+this.hauteur && o.x >= this.x && o.x <= this.x+largeur) {
			return true;
		}
		if (o.y >= this.y && o.y <= this.y+this.hauteur && o.x+o.largeur >= this.x && o.x+o.largeur <= this.x+this.largeur) {
			return true;
		}
		if (o.y >= this.y && o.y <= this.y+this.hauteur && o.x >= this.x && o.x <= this.x+largeur) {
			return true;
		}
		return false;
	}

}
