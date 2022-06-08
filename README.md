Projet Carbon IT - Carte aux trésors
par Steven QUIOT
-------------------------------------------
<b>Sujet</b>

Ce projet vise à réaliser un programme permettant de lire et interpréter des instructions fournies dans un fichier d'entrée dans le dossier "ressource/hunts".
Au lancement,l'utilisateur se voit lister les "chasses possibles", il n'a plus qu'à inscrire le nom du fichier souhaité.
En découle alors la génération d'une chasse aux trésors avec tous les éléments nécessaires à son déroulement (si aucune exception n'a été relevée lors de la génération du jeu) :
- La carte
- Les éléments topographiques de la carte
- Les trésors
- Le ou les chasseurs de trésors

Chaque fin de partie fournit un résultat retranscrivant l'état de la carte après la chasse aux trésors ainsi que la quantité de trésors récoltés par nos aventuriers.
Ce résultat est écrit dans un fichier de résultat au sein du dossier "ressources/results".

-------------------------------------------
<b>Lancement du programme</b>

Le projet peut être cloné dans un IDE et être exécuté via le "Main".
Un message d'introduction s'affiche dans la console afin d'accompagner l'utilisateur à la saisie
du nom de fichier de chasse aux trésors souhaité.

Suite à cela, le fichier est lu et interprété afin de générer une partie de chasse aux trésors.
Le résultat est affiché dans la console, mais aussi inscrit dans un fichier texte dans le répertoire "resources/results".

Des exceptions peuvent être relevées au cours de l'exécution, pouvant faire part d'un fichier d'instructions non valide,
d'une génération de map erronée, d'un placement d'élément invalide ou hors map, etc.

L'ajout de "chasse aux trésors" autrement dit de fichier d'instructions se fait dans le dossier "resources/hunts".

Le projet pourrait aussi être build si besoin via maven : "mvn clean install". 
Il ne resterait alors plus qu'à exécuter le fichier JAR généré dans le dossier <i>Target</i> du projet : java -jar <nom-du-jar>

Cependant par manque de temps, je n'ai pas pu fignoler la partie saisie d'utilisateur pour rendre la saisie de fichiers ergonomique.
Ainsi, mieux vaut lancer le programme avec le "Main" depuis votre IDE et en ajoutant les fichiers à tester dans le dossier "resources/hunts", car celle-ci est adaptée pour ce dossier.

-------------------------------------------
<b>Structure</b>

<b>Main.java</b> : Fonction main de l'application.
    
<b>model</b> : Modèles des objets créés lors de l'exécution du programme
    
<b>exception</b> : Contient diverses exceptions pouvant être relevées lors de l'initialisation de nos objets et l'exécution de notre programme
    
<b>resources</b> : Contient le dossier de nos fichiers d'instructions de chasses aux trésors ("/hunts"), ainsi qu'un dossier recevant les résultats
après une chasse aux trésors ("results").
    
<b>service</b> : Contient les fonctions dédiées au fonctionnement et au cycle de vie des objets de la chasse aux trésors
    
<b>util</b> : Contient des classes utilitaires permettant notamment le traitement de nos fichiers ou de certaines données.

-------------------------------------------
<u>Pourraient être ajoutés ou améliorés :</u>

    - Affichage de toutes les étapes de la chasse aux trésors dans la console ou dans le fichier de résultat.
    - Affichage visuelle de la map résultante (?)
    - Gestion du programme par lignes de commandes plus poussées et plus "user-friendly", et un accompagnement continu de l'utilisateur.
    - Gestion des exceptions étendant une exception globale liée au programme afin d'éviter des "throws <exception>,..." à rallonge.
    - Rajouter certains tests que je n'ai pas eu le temps de faire
-------------------------------
Java 11 - JUnit 5 - Maven 4 - IntelliJ
