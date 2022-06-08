package treasures_hunt.util.display;

import treasures_hunt.util.file.InputReader;

public class DisplayTreasureHuntGame {

    // A private constructor, which means that the class cannot be instantiated.
    private DisplayTreasureHuntGame(){
        throw new IllegalStateException();
    }

    /**
     * It displays the introduction of the program
     */
    public static void displayIntro(){
        System.out.println("**************************************");
        System.out.println("Bienvenue dans la carte aux trésors !");
        System.out.println("**************************************");
        System.out.println("Voici la liste des aventures présentes dans le dossier ressources :");
        InputReader.displayFilesInDirectoryResources();
        System.out.println("---------------------------------------");
        System.out.println("Saisis le nom du fichier de chasse aux trésors souhaité :");
    }

    /**
     * This function displays the end of the treasure hunt
     */
    public static void displayOutro(){
        System.out.println("**************************************");
        System.out.println("Fin de la chasse aux trésors !");
        System.out.println("**************************************");
    }

}
