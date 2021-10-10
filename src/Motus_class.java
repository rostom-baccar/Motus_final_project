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

	public static boolean verif(char c, String ch2) { //la fonction verif retourne false si un caractère donné n'est pas dans 
		boolean t;                                    //une chaîne donnée, et retourne true si le caractère est bien dans la chaîne
		int i;
		t=false;
		i=0;    
		int ascii=c;       
		ascii=ascii+32;                              //ascii est une variable qui permet la conversion d'une lettre majuscule en minuscule
		char c1=(char)ascii;                         //c1 permet la comparaison avec la meme lettre mais en minuscule (cette condition permet d'éviter
		//d'avoir 2 fois la meme lettre en minuscule quand le mot passe par la procédure traitement 2)

		do {
			i=i+1;
			if ((c==ch2.charAt(i-1)) || (c1==ch2.charAt(i-1))) {         //comparasion de c avec la lettre eventuelle en majuscule 
				//et c1 avec la lettre eventuelle en minuscule
				t=true;
			}
		} while ( (t==false) && ((i-1)!=6) );
		return (t);	
	}	

	public static String traitement1(String ch, String ch1, String ch2){ //traitement 1 concerne les lettres bien placées
		int i,j;
		for (i=1; i<=7; i++) {
			for (j=1; j<=7; j++) {
				if ( (ch.charAt(i-1)==ch1.charAt(j-1)) && (i==j) && (i!=1) ) {  //i==j: les 2 lettres sont à la même position
					//condition i différent de 1 car la 1ère lettre est connue       
					//pas besoin de uppercase car ch est déjà en maj
					ch2=ch2.substring(0,i-1)+ch.charAt(i-1)+ch2.substring(i);
				}
			}
		}
		return (ch2);
	}	


	public static String traitement2(String ch, String ch1, String ch2){  //traitement 2 concerne les lettres mal placées
		int i,j;
		boolean t;
		char c;
		for (i=1; i<=7; i++) {
			for (j=1; j<=7; j++) {
				if ( (ch.charAt(i-1)==ch1.charAt(j-1)) && (i!=j) && (i!=1) ) { //i!=j: les 2 lettres sont les meme mais à des positions différentes
					//condition i différent de 1 car la 1ère lettre est connue
					t=verif(ch.charAt(i-1),ch2);
					if (t==false) {
						int ascii=ch.charAt(i-1);       //introduction de la variable ascii afin de convertir une lettre en majuscule à
						ascii=ascii+32;                 //son équivalent en minuscule
						c=(char)ascii; 
						ch2=ch2.substring(0,i-1)+c+ch2.substring(i);
					}
				}
			}
		}
		return (ch2);
	}

	public static void main(String[] args){                
		System.out.println("BIENVENUE AU JEU MOTUS!");
		System.out.println("Vous avez 6 essais pour essayer de deviner le mot a 7 lettres tire au hasard");
		System.out.println();
		String resp;
		boolean t1;
		do {
			String ch,ch1,ch2;     //ch1 est le mot tiré au harard, ch2 est le mot proposé qui sera
			ch="";                 //mis à jour après traitement(coloriage des lettres/version beta: min et maj)
			int i,c; 
			boolean t;              
			c=0;      
			i = (int)(Math.random()*2888);                     //i nombre au hadard entre 0 et 2887 (nombre de mots à 7 lettres)
			ch1=dictionnaire[i].toUpperCase();                   //ch1 un mot tiré au hasard (selon i) parmi les mots à 7 lettres 
			ch2=ch1.charAt(0)+"------";                          //on donne la 1ere lettre à l'utilisateur
			System.out.println(ch2);
			do {

				c=c+1;
				ch=readFile(ch);                    //saisie de ch: readFile est une fonciton de saisie et de vérification du mot proposé ch

				if (ch.charAt(0)!=ch2.charAt(0)) { //si la 1ère lettre donnée n'est pas respectée, celle-ci est remplacée par un tiret
					ch2="-------";
				}    
				ch2=traitement1(ch,ch1,ch2); //colorie en rouge les lettres bien placées (version beta: majuscule)
				ch2=traitement2(ch,ch1,ch2); //colorie en jaune les lettres mal placées (version beta: minuscule), Remarque: traitement 2 utilise verif


				//POUR DESACTIVER LA FONCTIONNALITE DE L'APPARTENANCE DU MOT PROPOSE AU DICTIONNAIRE AFIN DE FACILITER LES TESTS, 
				//IL FAUT AFFECTER t A TRUE JUSTE AVANT LA FIN DE LA BOUCLE WHILE DANS LA FONCITON readFile

				t=ch.equals(ch1);  //comparaison du mot proposé avec le mot à deviner: stockée dans la variable booléenne t
				if (t==false) {

					System.out.println(ch2);	 //remarque: l'affichage de ch2 dans un 1er temps avant la réinitialisation permet au joueur
					//de connaitre son avancement quant au devinement du mot

					ch2=ch1.charAt(0)+"------";

					System.out.println("Essais restants: "+(6-c));
				} 
			} while ( (c!=6) && (t==false) );

			if (t==true) {
				System.out.println("Vous avez gagne!");
			}
			else {
				System.out.println("Vous avez perdu!");
				System.out.println("Le mot a deviner etait "+ch1);
			}

			System.out.println("Voulez-vous rejouer?");
			resp=Lire.S().toUpperCase();
			t1=resp.equals("OUI");
		}while (t1==true);

	} 

}
