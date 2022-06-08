package treasures_hunt.service;

import treasures_hunt.exception.EmptyLinesInstructionsException;
import treasures_hunt.exception.GenerateMapException;
import treasures_hunt.exception.GenerateTreasureHunterException;
import treasures_hunt.exception.OutOfValidTileMapException;
import treasures_hunt.model.GameTreasureHunt;
import treasures_hunt.model.Position;
import treasures_hunt.model.map.Tile;
import treasures_hunt.model.map.TileMountain;
import treasures_hunt.model.map.TreasureMap;
import treasures_hunt.model.treasurehunter.TreasureHunter;
import treasures_hunt.util.display.DisplayTreasureHuntGame;
import treasures_hunt.util.file.InputReader;
import treasures_hunt.util.file.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class GameHuntService {

    // A private constructor, which means that the class cannot be instantiated.
    private GameHuntService(){
        throw new IllegalStateException();
    }

    private static final String WRONG_SIZE_INSTRUCTION = "Size of instruction is not valid.";

    /**
     * It takes a list of strings, generates a map of tiles, creates a treasure map, and fills the treasure map with the
     * instructions from the list of strings
     *
     * @param lines a list of strings, each string is a line of the instructions.
     * @return A GameTreasureHunt object
     */
    public static GameTreasureHunt initGameTreasureHunt(List<String> lines) throws GenerateMapException, EmptyLinesInstructionsException, OutOfValidTileMapException, GenerateTreasureHunterException {
        Tile[][] mapTiles = TreasureMapService.generateMapTiles(lines);
        TreasureMap tMap = new TreasureMap(mapTiles);
        return fillTreasureMap(tMap,lines.subList(1,lines.size()));
    }


    /**
     * It takes a TreasureMap and a list of instructions, and returns a GameTreasureHunt
     *
     * @param tMap the TreasureMap object that will be filled with the instructions
     * @param lines a list of strings, each string is an instruction
     * @return A GameTreasureHunt object
     */
    public static GameTreasureHunt fillTreasureMap(TreasureMap tMap, List<String> lines) throws GenerateMapException, OutOfValidTileMapException, GenerateTreasureHunterException {
        List<TreasureHunter> hunters = new ArrayList<>();
        for (String line : lines) {
            String[] instructionLine = line.split(" - ");
            switch (instructionLine[0]) {
                case "C":
                    throw new GenerateMapException("Map is already defined !");
                case "M":
                    if(instructionLine.length == 3){
                        Position posM = new Position(Integer.parseInt(instructionLine[1]),Integer.parseInt(instructionLine[2]));
                        tMap.setTile(new TileMountain(posM));
                    }else{
                        throw new GenerateMapException(WRONG_SIZE_INSTRUCTION);
                    }
                    break;
                case "T":
                    if(instructionLine.length == 4){
                        Position posT = new Position(Integer.parseInt(instructionLine[1]),Integer.parseInt(instructionLine[2]));
                        tMap.getTile(posT).setTreasures(Integer.parseInt(instructionLine[3]));
                    }else{
                        throw new GenerateMapException(WRONG_SIZE_INSTRUCTION);
                    }
                    break;
                case "A":
                    TreasureHunter hunter = TreasureHunterService.createTreasureHunter(instructionLine);
                    if(tMap.positionIsOutOfBounds(hunter.getPosition())
                        || tMap.getTile(hunter.getPosition()).isUnreachable()){
                        throw new OutOfValidTileMapException("Treasure hunter is set outside the map or on a unreachable tile.");
                    }
                    hunters.add(hunter);
                    tMap.getTile(hunter.getPosition()).setHunterPresent(hunter);
                    break;
                default: // Line is ignored because type of line is not recognized.
                    break;
            }

        }
        return new GameTreasureHunt(tMap,hunters);
    }

    /**
     * The function `runGameTreasureHunt()` reads a file, creates a map, plays a game and write the results.
     */
    public static void runGameTreasureHunt() throws IOException, GenerateMapException, EmptyLinesInstructionsException, OutOfValidTileMapException, GenerateTreasureHunterException {
        DisplayTreasureHuntGame.displayIntro();
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        List<String> fileLines = InputReader.readInputFile("src/main/resources/hunts/" + fileName);
        GameTreasureHunt game = GameHuntService.initGameTreasureHunt(fileLines);
        game.huntersRunInstructions();
        if(game.isGameIsFinished()){
            OutputWriter.writeOutputFile(Collections.singletonList(game.results()),"src/main/resources/results/","results_"+fileName);
            System.out.println("Results : \n" + game.results() + "\nRetrouvez le résultat sous fichier texte dans le dossier resources/results.");
        }
        DisplayTreasureHuntGame.displayOutro();
    }
}
