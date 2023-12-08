import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Serialiseur {
    public static void SerialiseurObjetAJson(Object objet, int depth) throws IllegalAccessException {
    	if (depth == 1)
    	{
    		System.out.println("");
    	}
    	for(int i=0; i<depth; i++) {
    		System.out.print("\t");
    	}
        System.out.println("{");
        Field[] fields = objet.getClass().getDeclaredFields();
        int count = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(objet);
        	for(int i=0; i<depth; i++) {
        		System.out.print("\t");
        	}
            System.out.print("\t\"" + field.getName() + "\":");
            if (value instanceof String) {
                System.out.print("\"" + value + "\"");
            }
            else if (value != null && field.getType().isArray()) {
				System.out.println("[");
				int longueur = Array.getLength(value);
				for (int i = 0; i < longueur; i++) {
					Object item = Array.get(value, i);
					if(item instanceof String) {
						System.out.print("\"" + item + "\"");
						
					}else if (item != null && !item.getClass().isPrimitive()) {
						SerialiseurObjetAJson(item, depth+2);
					}else {
						System.out.print(item);
					}if(i < longueur - 1) {
				    	for(int j=0; j<depth+2; j++) {
				    		System.out.print("\t");
				    	}
						System.out.println(",");
					}
					
				}
		    	for(int i=0; i<depth+1; i++) {
		    		System.out.print("\t");
		    	}
				System.out.println("]");
			}
            else if (value !=null && !field.getType().isPrimitive()) {
            	if(depth>0) {
            		System.out.println("");
            	}
				SerialiseurObjetAJson(value, depth+1); //recursivité
			}
            else {
                System.out.print(value);
            }
            count++;
            if(count < fields.length) {
            	System.out.println(",");
            }
        }
        
        if (fields.length > 0) {
        	if(depth>0) {
        		System.out.println("");
        	}        	
        	for(int i=0; i<depth; i++) {
        		System.out.print("\t");
        	}
            System.out.println("}");
        }
    }
}  
//=======================================================================================================================
//Partie pour tester les objets array je l'ai fais car il y'avais un bug dans mon code avant il reconnais pas les arrays
// puis j'ai fais cette partie de code pour tester juste les objets arrays 
//=======================================================================================================================



       /* if (objet.getClass().isArray()) {
            System.out.print("[");
            int length = Array.getLength(objet);
            for (int i = 0; i < length; i++) {
                Object item = Array.get(objet, i);
                if (item instanceof String) {
                    System.out.print("\"" + item + "\"");
                } else {
                    System.out.print(item);
                }
                if (i < length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
        } else {
            System.out.println(objet); // Gérer les autres types d'objets si nécessaire
        }
    }
}*/