import java.io.*;
import java.util.Scanner;  
public class Motus_class {
	public static Scanner x;
	
	public static String readFile(String ch){ //readFile est une fonction qui permet la saisie du mot et sa vérification  
		boolean t;
		int l,c;
		l=0; c=0;
		ch="";
		do {                                              
			try {                                               //ouverture du fichier liste_francais.txt
				x = new Scanner(new File("liste_francais.txt"));      
			}
			catch(Exception e){                                 //erreur eventuelle
				System.out.println("Fichier inexistant");
			}
			System.out.println("Saisir un mot a 7 lettres"); //saisie du mot proposé
			ch=Lire.S().toUpperCase();                    
			l=ch.length();   

			t=true;                
			while((x.hasNext())&&(t==false)){   //boucle balayant le fichier liste_francais.txt et verifiant si le mot figure dans la liste     
				String A = x.next().toUpperCase();  //la methode hasNext stocke chaque mot dans une variable et le compare avec le mot proposé
				t=ch.equals(A);                     //on sort de la boucle lorsque le mot figure dans la liste ou lorsque toute la liste est balayée
			}                                //t permet la vérification de l'existance du mot dans le dictionnaire français
			x.close();                          //fermeture du fichier pour l'ouvrir de nouveau et rebalayer le fichier à chaque tour de boucle
			if (l==7) {
				if (t==false) {

					System.out.println("Le mot saisi n'est pas dans le dictionnaire francais, veuillez reessayer"); 
				} 
				else {	System.out.println("Le mot est bien dans le dictionnaire francais");
				}
			}
			else {
				if (t==false) {
					System.out.println("Ce n'est ni un mot francais ni un mot a 7 lettres, veuillez reessayer");
				}
				else {
					System.out.println("C'est un mot francais mais ce n'est pas un mot a 7 lettres, veuillez reessayer");
				}

			} 
		} while ((l!=7) || (t==false));  //2 conditions pour que le mot soit accepté: longueur=7 et existence du mot dans le dictionnaire
		return ch;                       //la fonction readFile retourne le mot proposé
	}
	
	
}
