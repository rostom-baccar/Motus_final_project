import java.io.*;
import java.util.Scanner;  
public class Motus_class {
	
	public static final  String[] dictionnaire={       //tous les mots à 7 lettres
			"abaisse", "abandon", "abattre", "abattus", "abbesse", "abceder", 
			"abdomen", "abeille", "abidjan", "abjurer", "abonnee", "abonner", 
			"abonnes", "aborder", "abordes", "abortif", "aboutir", "aboutit", 
			"abrasif", "abregee", "abreger", "abricot", "abriter", "abroger", 
			"absence", "absente", "absents", "absolue", "absorbe", "abstenu", 
			"absurde", "abusive", "abyssin", "abyssin", "acceder", "accents", 
			"accepte", "accepte", "accorde", "accorde", "accords", "accrues", 
			"accueil", "accusee", "accuser", "accuses", "acetone", "acharne", 
			"achetee", "acheter", "achetes", "achevee", "achever", "acheves", 
			"acidite", "acidule", "acolyte", "acompte", "acquise", "acteurs", 
			"actinie", "actions", "activer", "actives", "actrice", "actuels", 
			"adamien", "adamite", "adaptee", "adapter", "adaptes", "addenda", 
			"adeptes", "adequat", "adherer", "adipeux", "adjoint", "admirer", 
			"adoptee", "adopter", "adoptes", "adoucir", "adresse", "adresse", 
			"adultes", "adverbe", "adverse", "aeriens", "affable", "affecte", 
			"affecte", "affiche", "affiche", "affiler", "affirme", "affirme", 
			"afflige", "affluer", "affrete", "affreux", "affront", "aff�ter", 
			"afghane", "afghane", "afghans", "afghans", "afrique", "agencer", 
			"agences", "aggrave", "agilite", "agitent", "agneler", "agraire", 
			"agrandi", "agregat", "aguerri", "aigreur", "aiguise", "aileron", 
			"ailette", "aimable", "aimante", "airains", "aisance", "ajaccio", 
			"ajoutee", "ajouter", "ajuster", "alarmer", "albanie", "alb�tre", 
			"albinos", "alcoolo", "alerter", "alfredo", "algebre", "algerie", 
			"aligner", "alignes", "allegee", "alleger", "allegre", "allegro", 
			"alliage", "allonge", "allonge", "allouer", "alloues", "allumer", 
			"allures", "alterer", "alveole", "amarrer", "amasser", "amateur", 
			"amazone", "ambiant", "ambigu�", "amenage", "amender", "amendes", 
			"amiable", "amiante", "amicale", "amities", "amnesie", "amorcee", 
			"amorphe", "amortir", "amphore", "ampleur", "ampoule", "amputer", 
			"amusant", "analyse", "analyse", "anatoli", "anchois", "anciens", 
			"andante", "andorre", "andrieu", "angeles", "angelot", "anglais", 
			"anglais", "aniline", "animale", "animaux", "animees", "annales", 
			"annexer", "annexes", "annonce", "annonce", "annuels", "annulee", 
			"annuler", "anonyme", "anormal", "antenne", "anthony", "anthrax", 
			"antique", "antoine", "antonio", "anxiete", "anxieux", "apaiser", 
			"apanage", "apathie", "aphasie", "aplanir", "aplatir", "apollon", 
			"apparue", "apparus", "appelee", "appeler", "appeles", "appelle", 
			"appetit", "apporte", "apporte", "apports", "apposer", "apprend", 
			"apprite", "appuyee", "appuyer", "appuyes", "aquilon", "arbitre", 
			"arbuste", "arcades", "arguant", "arizona", "armenie", "armoire", 
			"arnault", "arrache", "arrange", "arritee", "arriter", "arrites", 
			"arriere", "arriere", "arrimer", "arrivee", "arriver", "arrives", 
			"arrondi", "arroser", "arsenal", "arsenic", "article", "artisan", 
			"artiste", "asbeste", "asocial", "aspects", "asperge", "aspirer", 
			"assauts", "assener", "asservi", "assigne", "assises", "assiste", 
			"assiste", "associe", "associe", "assorti", "assoupi", "assouvi", 
			"assumer", "assuree", "assurer", "assures", "atchoum", "atelier", 
			"athenes", "athlete", "atlanta", "attache", "attaque", "attaque", 
			"attarde", "atteint", "atteler", "attendu", "attente", "attifer", 
			"attique", "attirer", "attires", "attiser", "attrait", "aubaine", 
			"auberge", "auguste", "aurions", "austere", "austral", "auteurs", 
			"autobus", "autocar", "automne", "avaient", "avancee", "avancer", 
			"avances", "avances", "avarier", "avatars", "aveline", "avenant", 
			"avenues", "avertir", "avertis", "avertit", "aveugle", "avidite", 
			"avignon", "avocats", "avorter", "avouent", "azimuts", "azoteux", 
			"baccara", "bagages", "bagarre", "bahamas", "bahreon", "baigner", 
			"b�iller", "baisser", "baklava", "balader", "balafre", "balance", 
			"balatum", "balayer", "baleine", "balkans", "ballade", "ballast", 
			"ballets", "ballons", "balourd", "bambins", "bandage", "bangkok", 
			"banques", "banquet", "baptime", "baptise", "baraque", "baraque", 
			"barbara", "barbare", "barbier", "bariole", "baroque", "barrage", 
			"barreau", "baryton", "basalte", "bascule", "bascule", "basique", 
			"bassine", "bastion", "batavia", "bateaux", "b�tisse", "battage", 
			"battant", "battent", "batteur", "bavarde", "baviere", "bavures", 
			"bayonne", "beatles", "beauvau", "beckett", "becoter", "begayer",
			"bel �ge", "belarus", "belfast", "belfond", "belfort", "bercail", "berceau", 
			"bergman", "berlioz", "bernard", "besogne", "besoins", "beurrer", 
			"biaiser", "bibelot", "bient�t", "bigarre", "bigleux", "billets", 
			"binaire", "birmane", "birmans", "biscuit", "bistrot", "bitumer", 
			"biturer", "bivouac", "bizarre", "blafard", "blaguer", "blanche", 
			"blessee", "blesser", "blesses", "blindes", "blocage", "bloquee", 
			"bloquer", "bloques", "blouson", "bluffer", "blutoir", "bobigny", 
			"bobonne", "boisson", "boiteux", "bolivie", "bonasse", "bonheur", 
			"bonjour", "bonsoir", "bordure", "bornage", "bosquet", "bouchee", 
			"boucher", "bouches", "bouchon", "bouclee", "boucler", "bouffee", 
			"bouffer", "bouffon", "bougent", "bougies", "bouleau", "boulots", 
			"bouquet", "bouquin", "bourbon", "bourdet", "bourges", "bourrer", 
			"bourrin", "bourses", "boutade", "bouteur", "boutons", "bouvard", 
			"bouvier", "branche", "branche", "brandir", "branler", "braquer", 
			"braudel", "brejnev", "brevets", "brigade", "brigand", "briguer", 
			"briller", "brioche", "briques", "briquet", "brisant", "british", 
			"bronzer", "brosser", "brousse", "bruccio", "br�lant", "br�lees", 
			"br�lure", "brusque", "brutale", "bruyant", "b�cheur", "budgets", 
			"buisson", "bulgare", "bulgare", "bureaux", "burkina", "burundi", 
			"cabaret", "cabinet", "caboche", "caboter", "cabotin", "cachait", 
			"cachent", "cachete", "cadavre", "cadeaux", "cadence", "cafeter", 
			"cahiers", "cahoter", "cailler", "caillou", "caisses", "cajoler", 
			"calcium", "calcule", "calculs", "cale en", "cale�on", "calepin", 
			"c�liner", "calleux", "calorie", "caloyer", "cameras", "camille", 
			"camions", "camping", "canards", "cancers", "candeur", "candide", 
			"canetti", "cannele", "cantine", "cantons", "capable", "capital", 
			"caprice", "capture", "caracas", "carbone", "cardite", "carence", 
			"caresse", "carioca", "carmine", "carnage", "carnets", "carotte", 
			"carreau", "cartels", "cartier", "cartons", "cascade", "caserne", 
			"casinos", "casques", "cassant", "casting", "catalan", "cathode", 
			"caucase", "caution", "caverne", "ceindre", "celebre", "celebre", 
			"celeste", "celibat", "cellier", "cellule", "cendres", "censure", 
			"centime", "central", "centree", "centres", "cerceau", "cercles", 
			"cereale", "certain", "cerveau", "cervier", "cessent", "cession", 
			"ceux-ci", "ceux-l�", "cezanne", "chacune", "chagrin", "chaines", 
			"chainon", "chaises", "chaland", "chaleur", "chambre", "chameau", 
			"chancel", "chances", "changer", "changes", "channel", "chanson", 
			"chantal", "chanter", "chantre", "chapeau", "charbon", "chargee", 
			"charger", "charges", "charges", "chariot", "charite", "charles", 
			"charmer", "charmes", "charter", "chasser", "ch�ssis", "ch�tain", 
			"ch�teau", "ch�tier", "chaudes", "chauffe", "chauler", "chemery", 
			"chemins", "chemise", "cheptel", "cheques", "cherche", "cherche", 
			"chevaux", "cheveux", "chevres", "chicago", "chichis", "chienne", 
			"chiffon", "chiffre", "chignon", "chiites", "chimere", "chinois", 
			"choisie", "choisir", "choisis", "choisit", "cholera", "ch�mage", 
			"ch�meur", "choquer", "chorale", "cigogne", "cinemas", "cingler", 
			"cinoche", "circuit", "circule", "circule", "ciseaux", "citadin", 
			"citoyen", "citro�n", "civiles", "civique", "claires", "clairon", 
			"claquer", "claquet", "classer", "classes", "classes", "claudel", 
			"clauses", "clavier", "clement", "cliches", "clients", "cligner", 
			"cliquet", "clivage", "clocher", "cloison", "cloitre", "cl�ture", 
			"cocaone", "cocotte", "cocteau", "cocuage", "coffret", "cogiter", 
			"coinces", "colback", "colbert", "coleman", "colette", "colibri", 
			"collant", "college", "collier", "colline", "cologne", "colombe", 
			"colonel", "colonie", "colonne", "colorer", "coloris", "colosse", 
			"combats", "combien", "combine", "combine", "combler", "comecon", 
			"comedie", "comique", "comites", "comment", "commere", "commise", 
			"commode", "commune", "communs", "compact", "compare", "compare", 
			"compere", "complet", "complot", "compose", "compose", "compost", 
			"compris", "compter", "comptes", "concede", "concede", "concept", 
			"concert", "concile", "conclue", "conclus", "conclut", "con�oit", 
			"concret", "con�ues", "conduit", "confere", "confiee", "confier", 
			"confins", "conflit", "confond", "confort", "confuse", "congele", 
			"congres", "conjure", "connais", "connait", "connard", "connues", 
			"conquis", "conseil", "cons�ur", "constat", "contact", "content", 
			"contenu", "continu", "contour", "contrat", "contree", "contrer", 
			"convenu", "convier", "convois", "copains", "copieur", "coppola", 
			"corbeau", "cordial", "cordier", "cordons", "coreens", "coriace", 
			"correct", "correle", "correze", "corrige", "corsage", "cortege", 
			"costard", "costaud", "costume", "cottage", "coucher", "couches", 
			"couenne", "couette", "couiner", "couleur", "couloir", "coupant", 
			"coupees", "couples", "coupoir", "coupole", "coupure", "courage", 
			"courant", "courber", "courbes", "courent", "coureur", "courses", 
			"courtes", "cousine", "cousins", "coussin", "couteau", "co�tent", 
			"co�tera", "co�teux", "coutume", "couture", "couvent", "couvert", 
			"couvrir", "crachat", "cracher", "crachin", "crainte", "crampon", 
			"cr�neur", "crapule", "craquer", "cravate", "creance", "credits", 
			"credule", "cremant", "creneau", "crepus)", "cresson", "creteil", 
			"creuser", "cribler", "cricket", "crisper", "crisser", "cristal", 
			"critere", "crochet", "croient", "croiser", "croises", "croitre", 
			"croquer", "croquis", "crotter", "crottes", "croyait", "croyant", 
			"croyons", "cruaute", "crucial", "crudite", "cruelle", "cr�ment", 
			"cubains", "cubitus", "cuiller", "cuisine", "cuisses", "cuistot",
			"cul sec", "culotte", "cultive", "cultive", "culture", "curatif", "curieux", 
			"cuvette", "cyclone", "cynique", "cynisme", "daigner", "daimler", 
			"dangers", "daniele", "danoise", "dansent", "danseur", "dattier", 
			"dauphin", "dealers", "deb�cle", "debattu", "debiner", "debiter", 
			"deborde", "debussy", "debuter", "deceder", "deceler", "decence", 
			"decerne", "dechets", "dechire", "dechoir", "decidee", "decider", 
			"decides", "decimer", "decisif", "declare", "declare", "decline", 
			"decline", "declive", "decolle", "decorer", "decorne", "decoule", 
			"decrete", "decrete", "decrets", "decrier", "decrire", "deduire", 
			"defaite", "defauts", "defendu", "defense", "defiant", "deficit", 
			"defiler", "defiles", "definie", "definir", "definis", "definit", 
			"deforme", "defunte", "degagee", "degager", "degages", "degaine", 
			"degarni", "degoter", "delegue", "delicat", "delices", "delirer", 
			"delivre", "delivre", "deloyal", "demanda", "demande", "demande", 
			"demarre", "demarre", "demiles", "demence", "dementi", "demette", 
			"demeure", "demodes", "demolir", "demonte", "demunis", "denomme", 
			"denonce", "denonce", "denoter", "denouer", "denrees", "densite", 
			"dentele", "dentier", "departs", "depasse", "depasse", "depiche", 
			"depiche", "depeint", "depense", "depense", "deperir", "deplace", 
			"deplace", "deplait", "deplier", "deplore", "deplore", "deploye", 
			"deplume", "deporte", "deposee", "deposer", "deposes", "deprave", 
			"depurer", "deputes", "derange", "derange", "deraper", "derider", 
			"deriver", "derives", "derives", "dernier", "derobee", "derober", 
			"deroule", "deroule", "deroute", "desarme", "desaveu", "deserte", 
			"deserte", "deserts", "designe", "designe", "desirer", "desoler", 
			"despote", "dessein", "dessert", "dessine", "dessine", "dessins", 
			"dessous", "destine", "destins", "desuete", "desuets", "desunir", 
			"detache", "detache", "details", "detendu", "detenir", "detente", 
			"detenue", "detenus", "deteste", "detient", "detoner", "detroit", 
			"detroit", "detruit", "devaler", "devance", "devance", "devants", 
			"devaste", "devenir", "devenue", "devenus", "devitir", "devider", 
			"devient", "deviner", "deviser", "devises", "devoile", "devoirs", 
			"devorer", "devouer", "devrait", "devront", "diabete", "diademe", 
			"diamant", "dickens", "differe", "diffuse", "diffuse", "dignite", 
			"dilater", "dilemme", "diminue", "diminue", "dimitri", "diocese", 
			"dipl�me", "dipl�me", "directe", "directs", "dirigee", "diriger", 
			"diriges", "discret", "discute", "discute", "disette", "disparu", 
			"dispose", "dispose", "dispute", "dispute", "disques", "dissous", 
			"distant", "divisee", "diviser", "divises", "divorce", "dix ans", 
			"dixieme", "dizaine", "docteur", "doillon", "doivent", "dollars", 
			"domaine", "dominee", "dominer", "dommage", "dompter", "donetsk", 
			"donnait", "donnant", "donnees", "donnent", "donnera", "donneur", 
			"dormant", "dorment", "dortoir", "dossier", "douaire", "douanes", 
			"doublee", "doubler", "doubles", "douceur", "douglas", "douleur", 
			"doutait", "doutent", "douteux", "draguer", "drapeau", "dressee", 
			"dresser", "dresses", "dreyfus", "drogman", "droguer", "drogues", 
			"drogues", "droites", "dualite", "durable", "ebauche", "ebenier", 
			"eblouir", "ebranle", "ecaille", "ecartee", "ecarter", "ecartes", 
			"echalas", "echange", "echange", "echappe", "echappe", "echarpe", 
			"echeant", "echelle", "echelon", "echoppe", "echouer", "eclaire", 
			"eclaire", "eclater", "eclipse", "ecluser", "ec�urer", "ecolier", 
			"econome", "ecorcer", "ecosser", "ecoulee", "ecouler", "ecouter", 
			"ecoutes", "ecraser", "ecrases", "ecrites", "ecuries", "edifice", 
			"edifier", "editeur", "edition", "edouard", "edredon", "eduardo", 
			"eduquer", "effacer", "effigie", "effiler", "efforce", "efforts", 
			"effraie", "effrene", "egalite", "eglises", "egoosme", "egooste", 
			"egorger", "elabore", "elargie", "elargir", "elargit", "electif", 
			"elegant", "element", "elevage", "elevees", "eleveur", "elimine", 
			"eloigne", "eltsine", "elysees", "emacier", "emanant", "emarger", 
			"emballe", "embiter", "emblave", "embleme", "embryon", "emerger", 
			"emettre", "emeutes", "emigree", "emigrer", "emigres", "eminent", 
			"emirats", "emmener", "emmerde", "emotion", "emousse", "empaler", 
			"empiche", "empiche", "empiler", "empirer", "empires", "emploie", 
			"emplois", "employe", "emporte", "emporte", "emprise", "emprunt", 
			"en face", "en haut", "encadre", "enclins", "encrier", "enculer", 
			"endormi", "endroit", "enduire", "endurer", "energie", "enerver", 
			"enfance", "enfants", "enferme", "enfiler", "enflure", "enfoire", 
			"enfouir", "engagee", "engager", "engages", "englobe", "engluer", 
			"engrais", "enlacer", "enlever", "enleves", "ennemis", 
			"ennuyer", "enoncer", "enormes", "enquite", "enrayer", "enrichi", 
			"enrique", "enr�ler", "ensuite", "entamee", "entamer", "entendu", 
			"entente", "enterre", "en-tite", "entiere", "entiers", "entites", 
			"entorse", "entoure", "entoure", "entrain", "entrant", "entrave", 
			"entrees", "entrent", "entrera", "entuber", "enumere", "envahie", 
			"envahir", "envieux", "environ", "envolee", "envoyee", "envoyer", 
			"envoyes", "epaisse", "epargne", "epargne", "epatant", "epauler", 
			"epaules", "epicier", "epinard", "epineux", "epingle", "episode", 
			"epointe", "eponger", "epoques", "epouser", "epouses", "epreuve", 
			"eprouve", "eprouve", "epuiser", "epuises", "equipee", "equiper", 
			"equipes", "equipes", "erafler", "ereinte", "ergoter", "erosion", 
			"erreurs", "escadre", "escarpe", "esclave", "escorte", "escorte", 
			"escrime", "espacer", "espaces", "espagne", "especes", "esperer", 
			"espoirs", "esprits", "essayer", "essence", "essonne", "essorer", 
			"essuyer", "estaing", "estampe", "estimee", "estimer", "estimes", 
			"estival", "estomac", "estonie", "estrade", "etablie", "etablir", 
			"etablis", "etablit", "etagere", "etaient", "etalage", "etamage", 
			"etanche", "etendre", "etendue", "eternel", "ethique", "etienne", 
			"etoiles", "etonner", "etonnes", "etourdi", "etrange", "etrenne", 
			"etrille", "etrique", "etroite", "etroits", "etudiee", "etudier", 
			"etudies", "evacuee", "evacuer", "evacues", "evaluee", "evaluer", 
			"evalues", "evasion", "eveille", "evelyne", "eviques", "evident", 
			"evincer", "evitant", "evoluer", "evoquee", "evoquer", "evoques", 
			"exactes", "exagere", "exalter", "examens", "examine", "examine", 
			"excaver", "exceder", "excepte", "exciter", "exclame", "exclure", 
			"excuser", "excuses", "execrer", "execute", "exegese", "exemple", 
			"exercee", "exercer", "exhaler", "exhiber", "exhorte", "exhumer", 
			"exigent", "exister", "experte", "experts", "expirer", "exploit", 
			"explose", "exporte", "exposee", "exposer", "exposes", "express", 
			"exprime", "exprime", "expulse", "externe", "extrait", "extrime", 
			"exulter", "eyadema", "facetie", "f�cheux", "faciles", "facteur", 
			"faction", "facture", "faculte", "faibles", "faoence", "failles", 
			"faillir", "faisait", "faisant", "faisons", "falaise", "fallait", 
			"falloir", "fameuse", "famille", "fanfare", "fant�me", "fardeau", 
			"fascine", "fassent", "fatigue", "fatigue", "fatuite", "faucher", 
			"fausser", "fausses", "faveurs", "favoris", "fayoter", "federal", 
			"feindre", "feinter", "felonie", "felonne", "feminin", "fenouil", 
			"fermees", "ferment", "fermete", "fermier", "fernand", "ferrand", 
			"ferrant", "ferrari", "ferrees", "ferreux", "fertile", "fervent", 
			"ferveur", "feuille", "fevrier", "fiables", "fiancer", "ficelle", 
			"fichier", "fiction", "fideles", "fifties", "figuier", "figurer", 
			"figures", "filiale", "filiere", "filtrer", "finales", "finance", 
			"finance", "finesse", "fiscale", "fiscaux", "fischer", "fissure", 
			"flairer", "flambee", "flamber", "flammes", "flatter", "flechir", 
			"fleurer", "fleurir", "fleuron", "fleuves", "flirter", "floride", 
			"florins", "flotter", "flux de", "fol�tre", "foncier", "fondant", 
			"fondees", "fondent", "forcene", "forceps", "forfait", "formees", 
			"formels", "forment", "formule", "formule", "fortuit", "fortune", 
			"fortune", "fossile", "fouille", "fouiner", "foulard", "foulure", 
			"fourche", "fournee", "fournie", "fournil", "fournir", "fournis", 
			"fournit", "fourrer", "fourres", "foutoir", "fragile", "fraiche", 
			"fraiser", "franche", "franchi", "francis", "frangin", "franque", 
			"frappee", "frapper", "frappes", "fraudes", "frayeur", "freezer", 
			"fregate", "freiner", "fresnes", "fresque", "freteur", "friable", 
			"frileux", "frimeur", "frisson", "frivole", "fromage", "froment", 
			"froncer", "frotter", "frottis", "frousse", "frustre", "fugitif", 
			"fumeuse", "funebre", "funeste", "fureter", "furieux", "fusions", 
			"futures", "gabriel", "gadgets", "gageure", "gagnage", "gagnait", 
			"gagnant", "gagnent", "gagnera", "galaxie", "galerie", "galette", 
			"galland", "gallois", "galopin", "galurin", "gamelle", "garanti", 
			"gar�ons", "gardait", "gardant", "gardent", "gardera", "gardien", 
			"garnier", "garonne", "gaucher", "gaulois", "gaumont", "gautier", 
			"geantes", "geminer", "general", "gineuse", "genisse", "gentils", 
			"georgie", "gerhard", "germain", "gestapo", "gestion", "ghettos", 
			"gigoter", "gilbert", "gironde", "giscard", "glacial", "glacier", 
			"glander", "glasgow", "glisser", "globale", "globaux", "glouton", 
			"glucide", "gobelet", "gobelin", "godasse", "godiche", "godille", 
			"goinfre", "gonfler", "goudron", "gouffre", "goutter", "gouttes", 
			"gracier", "gradins", "graisse", "grammes", "grandes", "grandir", 
			"granule", "grasses", "grasset", "gratter", "gratuit", "gravier", 
			"gravite", "gravure", "grecque", "greffer", "greffes", "gregory", 
			"grenade", "grenier", "griffes", "griller", "grilles", "grillon", 
			"grimace", "grimper", "grincer", "gronder", "grosses", "grossir", 
			"grouper", "groupes", "guerres", "guetter", "guibert", "guichet", 
			"guitare", "g�nther", "gustave", "gypaete", "habitat", "habiter", 
			"habitue", "h�bleur", "haillon", "haineux", "haleine", "haleter", 
			"haltere", "hammett", "hanovre", "hantise", "haricot", "harvard", 
			"hasards", "hausser", "hausses", "hautain", "hauteur", "hectare", 
			"heiberg", "helvete", "herault", "herbage", "hercule", "heresie", 
			"heriter", "hermann", "heroone", "hersage", "hersant", "hesiter", 
			"heureux", "heurter", "hidjabs", "hindoue", "hirsute", "homelie", 
			"hommage", "hongrie", "honnite", "honneur", "honorer", "honteux", 
			"h�pital", "horaire", "horizon", "horloge", "horreur", "hostile", 
			"houille", "houleux", "housses", "huileux", "huitres", "hulotte", 
			"hululer", "humaine", "humains", "humbles", "humecte", "huppert", 
			"hussein", "hussite", "hygiene", "iceberg", "ici peu", "ici-bas", 
			"idiotie", "ignoble", "ignorer", "iliescu", "illegal", "imagine", 
			"imagine", "immense", "immigre", "immoler", "immonde", "immoral", 
			"impasse", "impiete", "importe", "importe", "imposee", "imposer", 
			"imposes", "imprevu", "imprime", "imputer", "inactif", "inanime", 
			"incarne", "incarne", "inciter", "incivil", "incline", "inclure", 
			"incombe", "inconnu", "inculpe", "inculte", "incurie", "indecis", 
			"indiana", "indices", "indiens", "indigne", "indique", "indique", 
			"indivis", "induire", "inedite", "inedits", "inegale", "ineptie", 
			"inertie", "inexact", "infamie", "infecte", "infeode", "infichu", 
			"infinie", "infirme", "inflige", "influer", "infonde", "informe", 
			"infoutu", "inhaler", "inhiber", "inhumer", "initial", "initier", 
			"inities", "injures", "injuste", "inonder", "inopine", "inquiet", 
			"inscrit", "insecte", "insense", "inserer", "insigne", "insiste", 
			"insiste", "inspire", "inspire", "instant", "insulte", "intacte", 
			"integre", "integre", "intense", "interit", "interim", "interne", 
			"interne", "intimes", "intruse", "inutile", "invente", "invente", 
			"inverse", "investi", "invitee", "inviter", "invites", "invoque", 
			"invoque", "irakien", "iranien", "irlande", "ironise", "ironise", 
			"irriter", "isolees", "italien", "ivrogne", "jachere", "jackson", 
			"jacques", "jadeite", "jaillir", "jambons", "janvier", "jardins", 
			"jaseuse", "javelot", "jesuite", "jet eau", "jettent", "jogging", 
			"johnson", "joindre", "joueurs", "journal", "journee", "joyeuse", 
			"jubiler", "jugeait", "jugeant", "juillet", "jullian", "jumelle", 
			"jupiter", "juriste", "justice", "kadhafi", "karajan", "kennedy", 
			"kiosque", "konzern", "kremlin", "kreuzer", "kundera", "lacerer", 
			"l�chete", "lacoste", "lacroix", "lacunes", "laffont", "laocite", 
			"laideur", "laignel", "laineux", "lainier", "laoques", "laissee", 
			"laisser", "laisses", "laissez", "laiteux", "laitier", "lalonde", 
			"lambert", "lambris", "lamelle", "lampyre", "lancees", "lancent", 
			"lanceur", "langage", "langues", "languir", "laniere", "laquais", 
			"largeur", "lassant", "lateral", "laureat", "laurent", "lavette", 
			"laxatif", "laxisme", "layette", "leaders", "leasing", "leclerc", 
			"lecteur", "lecture", "legales", "legende", "legeres", "legumes", 
			"leipzig", "lenteur", "leopold", "leotard", "lesiner", "lesotho", 
			"lessive", "lettres", "leurrer", "lexical", "lexique", "lezarde", 
			"liaison", "liberal", "liberee", "liberer", "liberes", "liberia", 
			"liberte", "libyens", "licence", "lignage", "lignees", "ligoter", 
			"lima�on", "limitee", "limiter", "limites", "limites", "limoger", 
			"limoges", "limpide", "lingual", "liquide", "lisible", "lisiere", 
			"livrant", "livrees", "livrent", "livreur", "locales", "logique", 
			"loisirs", "lombard", "londres", "longues", "longuet", "loquace", 
			"lorenzo", "lorient", "lorsque", "loterie", "louange", "loupiot", 
			"lourdes", "loyaute", "lubbers", "luciole", "lugubre", "luisant", 
			"lumiere", "lunette", "lustres", "lutteur", "luxueux", "lyceens", 
			"lyrique", "lyrisme", "macerer", "machine", "madrier", "magasin", 
			"maghreb", "magique", "mahomet", "maigres", "maigret", "maigrir", 
			"maillet", "maillon", "maillot", "maintes", "mairies", "maisons", 
			"maitres", "majeste", "majeure", "majeurs", "majorer", "malades", 
			"maladie", "malaise", "malaise", "malheur", "malotru", "malraux", 
			"malsain", "maltais", "malvenu", "manager", "managua", "manches", 
			"mandats", "mandela", "manfred", "maniere", "maniere", "manille", 
			"manquer", "manteau", "manuels", "marasme", "marceau", "marcher", 
			"marches", "marches", "mariage", "mariner", "marines", "marmite", 
			"marmots", "marotte", "marquee", "marquer", "marques", "marques", 
			"marquis", "marrant", "marteau", "martial", "martine", "martini", 
			"martyre", "martyrs", "masquer", "masques", "masques", "massifs", 
			"massive", "matches", "matelas", "matelot", "mathieu", "matiere", 
			"matinal", "matinee", "matrice", "maudire", "maugham", "maurice", 
			"mauvais", "maximal", "maximum", "maxwell", "mecenat", "mecenes", 
			"mechant", "meconnu", "medecin", "medical", "medicis", "mediter", 
			"meeting", "mefiant", "megoter", "melange", "melodie", "membres", 
			"memento", "memoire", "menacee", "menacer", "menaces", "menaces", 
			"menager", "menages", "mendier", "menotte", "mensuel", "mentale", 
			"mentaux", "menteur", "mention", "meprise", "mercure", "merguez", 
			"meriter", "merites", "merrain", "mesquin", "message", "mesuree", 
			"mesurer", "mesures", "metayer", "methode", "metiers", "metrage", 
			"mettait", "mettant", "mettent", "metteur", "mettons", "meubler", 
			"meubles", "meunier", "meurent", "meurthe", "meurtre", "mexique", 
			"michael", "michele", "microbe", "miennes", "miettes", "mignard", 
			"milices", "milieux", "militer", "millier", "million", "minable", 
			"minerai", "mineurs", "miniere", "minimal", "minimum", "minitel", 
			"minutes", "minutie", "mioches", "miracle", "miroirs", "missile", 
			"mission", "missive", "mistral", "mitaine", "mitoyen", "moabite", 
			"mobiles", "mochete", "modeler", "modeles", "moderee", "moderer", 
			"moderes", "moderne", "modeste", "modifie", "modifie", "mohamed", 
			"moindre", "moineau", "moisson", "molaire", "moldave", "moliere", 
			"molotov", "moments", "monacal", "monceau", "mondain", "mondial", 
			"monique", "monnaie", "monstre", "montage", "montait", "montana", 
			"montant", "montees", "montent", "monteur", "montoir", "montree", 
			"montrer", "montres", "monture", "moqueur", "morales", "morceau", 
			"mordant", "morsure", "mortier", "moselle", "mosquee", "motards", 
			"moteurs", "motions", "motivee", "motiver", "motives", "motrice", 
			"mouette", "mouille", "moulins", "mouloud", "moutard", "mouvoir", 
			"moyenne", "murdoch", "murmure", "muscles", "musical", "musique", 
			"mutiler", "mutisme", "myanmar", "mystere", "naguere", "naovete", 
			"namibie", "narcose", "nations", "naturel", "navales", "navette", 
			"navigue", "navires", "nazisme", "nefaste", "negatif", "neglige", 
			"negocie", "negocie", "neiertz", "nerveux", "nervure", "nettete", 
			"nettoye", "neuilly", "neutron", "nichons", "nicolas", "nippone", 
			"nippons", "niveaux", "niveler", "nixdorf", "nomades", "nombril", 
			"nominal", "nomines", "nomment", "nonante", "noriega", "normale", 
			"normand", "normaux", "norvege", "notable", "notaire", "notions", 
			"notoire", "nourrie", "nourrir", "nourrit", "nouveau", "nuances", 
			"nudiste", "nullite", "numeral", "numeros", "nunuche", "nuptial", 
			"obesite", "obligee", "obliger", "obliges", "oblique", "obscene", 
			"obscure", "obseder", "observe", "observe", "obstine", "obtenir", 
			"obtenue", "obtenus", "obtient", "occiput", "occulte", "occupee", 
			"occuper", "occupes", "octante", "octobre", "odorant", "�illere", 
			"offense", "offerte", "offerts", "offices", "offrait", "offrant", 
			"offrent", "ogresse", "oiseaux", "oleoduc", "olivier", "ombilic", 
			"omettre", "ondoyer", "onduler", "onereux", "onguent", "onzieme", 
			"opacite", "operant", "operees", "opinion", "opposee", "opposer", 
			"opposes", "options", "optique", "opulent", "orageux", "oraison", 
			"oranger", "orateur", "ordinal", "ordonne", "ordonne", "ordures", 
			"oreille", "organes", "orgelet", "orgueil", "oriente", "orifice", 
			"origine", "orleans", "orniere", "orpheon", "osselet", "ottoman", 
			"oubliee", "oublier", "oublies", "ouragan", "outrage", "ouverte", 
			"ouverts", "ouvrage", "ouvrait", "ouvrant", "ouvrent", "ouvrier", 
			"ouvrira", "oxygene", "pactole", "paginer", "paletot", "palette", 
			"pallier", "palmier", "paluche", "panacee", "panache", "panique", 
			"panneau", "papiers", "papoter", "paprika", "paquets", "paradis", 
			"parapet", "parasol", "pareils", "parente", "parente", "parents", 
			"paresse", "parfait", "parfois", "parfume", "parfums", "paribas", 
			"parites", "parjure", "parking", "parlait", "parlant", "parlent", 
			"parlera", "parlons", "parodie", "paroles", "parquet", "parrain", 
			"partage", "partage", "partant", "partent", "partial", "partiel", 
			"parties", "partout", "parvenu", "passage", "passait", "passant", 
			"passees", "passent", "passera", "passion", "passons", "pasteur", 
			"patates", "patelin", "patente", "patient", "patiner", "patrice", 
			"patrick", "patrons", "paulhan", "pauvres", "payante", "payerne", 
			"paysage", "paysans", "pecheur", "picheur", "peigner", "peindre", 
			"peintre", "pelisse", "peloter", "peloton", "pelouse", "peltier", 
			"penales", "penalty", "pencher", "pendant", "pendule", "penetre", 
			"penetre", "penible", "peniche", "pensait", "pensant", "pensees", 
			"pensent", "penseur", "pension", "pensons", "penurie", "percher", 
			"per�oit", "perdait", "perdant", "perdent", "perdrix", "perdues", 
			"perfide", "periode", "periple", "perrier", "pervers", "pesetas", 
			"petites", "petoche", "petrole", "peugeot", "peuplee", "peupler", 
			"peuples", "peureux", "peuvent", "phaeton", "pharaon", "philipe", 
			"philips", "phraser", "phrases", "picasso", "picoler", "picorer", 
			"picoter", "pierres", "pierrot", "pietons", "piliers", "pillage", 
			"piloter", "pilotes", "pilules", "pinceau", "piocher", "piquant", 
			"piquets", "pirates", "piscine", "pitance", "pivoine", "placard", 
			"placees", "placent", "placide", "plafond", "plagier", "plaider", 
			"plainte", "plaisir", "planche", "planete", "planque", "planter", 
			"plantes", "plantes", "plaques", "platane", "plateau", "platini", 
			"pl�tras", "pl�trer", "pleiade", "pleines", "pleurer", "plisser", 
			"plongee", "plonger", "plonges", "plovdiv", "plupart", "pluriel", 
			"pluvial", "pochard", "pochoir", "pogroms", "poignee", "poignet", 
			"poin�on", "poindre", "pointer", "pointes", "poireau", "poirier", 
			"poisson", "poivron", "poivrot", "polaire", "polices", "polluer", 
			"pologne", "poltron", "pommier", "pompeux", "pompier", "poperen", 
			"popotin", "portait", "portant", "portees", "portent", "portera", 
			"porteur", "portier", "portion", "positif", "possede", "postale", 
			"posture", "potence", "poterie", "potiner", "potiron", "poudres", 
			"poulain", "poulenc", "poulets", "pourpre", "pourrir", "pourvus", 
			"poussee", "pousser", "pousses", "poussin", "pouvais", "pouvait", 
			"pouvant", "pouvoir", "pouvons", "prairie", "preavis", "precede",           
			"precede", "pricher", "precise", "precise", "precoce", "predire", 
			"preface", "prefere", "prefere", "prefets", "prefixe", "prejuge", 
			"prelude", "premier", "prenait", "prenant", "prendra", "prendre", 
			"preneur", "prenons", "prepare", "prepare", "presage", "present", 
			"preside", "preside", "presque", "presser", "presses", "presses", 
			"preston", "presume", "pretend", "pritent", "preuves", "prevalu", 
			"prevaut", "prevenu", "prevoir", "prevoit", "prevues", "prieres", 
			"prieure", "primeur", "princes", "prisons", "privees", "probite", 
			"procede", "procede", "proches", "procure", "procure", "prodige", 
			"produit", "profane", "profile", "profils", "profite", "profite", 
			"profits", "profond", "progres", "prohibe", "projete", "projets", 
			"promene", "promise", "pr�nant", "propage", "propice", "propose", 
			"propose", "propres", "prorata", "protege", "protege", "prouver", 
			"prudent", "pruneau", "prunier", "publics", "publiee", "publier", 
			"publies", "pucelle", "pudique", "puisque", "punaise", "pupille", 
			"pustule", "qualite", "quatuor", "quelles", "quelque", "queneau", 
			"quentin", "quilles", "quimper", "quinine", "quitter", "quoique", 
			"raboter", "rachats", "rachete", "rachete", "raciale", "racines", 
			"racisme", "raciste", "raconte", "raconte", "radical", "radieux", 
			"radiner", "raffine", "raifort", "railler", "raisons", "rajoute", 
			"ralenti", "rallier", "ramasse", "ramenee", "ramener", "rancard", 
			"ranc�ur", "rangees", "ranimer", "rapha�l", "rapides", "rappele", 
			"rapport", "rapsode", "rarefie", "rassure", "rassure", "ratifie", 
			"raturer", "ravager", "ravages", "ravaler", "raviner", "raviver", 
			"raymond", "rayonne", "reactif", "realise", "realise", "realite", 
			"rebelle", "rebuter", "recaler", "receler", "recense", "recente", 
			"recents", "recette", "recevra", "rechaud", "rechute", "recital", 
			"reciter", "reclame", "reclame", "recolte", "reconnu", "records", 
			"recours", "recreer", "recreer", "recrues", "recrute", "recrute", 
			"recteur", "recueil", "reculer", "recuser", "redigee", "rediger", 
	};
	
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
