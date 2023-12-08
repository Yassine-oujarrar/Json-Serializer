

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
    	
    	
    	Compagnie c1 = new Compagnie("Mazda");
        Voiture v1 = new Voiture("Mazda 3", 2001, c1);
        Voiture v2 = new Voiture("Mercedes gclass", 2020, c1);
        
        Voiture[] voitures = {v1,v2};
        
        Garage g = new Garage(voitures);
        
        Serialiseur.SerialiseurObjetAJson(v1,0);
        Serialiseur.SerialiseurObjetAJson(g,0);
    }
    }
