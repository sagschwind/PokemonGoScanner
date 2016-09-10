/**
 * Created by Steven on 7/17/16.
 * Purpose of this program is to turn GAME_MASTER_v0_1.txt into an easily readable file
 * Developed in IntelliJ IDEA
 */


import java.io.*;
import java.util.Scanner;

public class PokemonGoScanner {

    public static void main(String[] args){
        Pokemon[] pokemon;
        String contents = "";

        try {
            contents = readFile();
        }
        catch (IOException x){
        }

        pokemon = findPokemon(contents);

        try {
            PrintWriter writer = new PrintWriter("PokemonGo_List.txt", "UTF-8");
             //will overwrite the file named above
            for (int i = 0; i < pokemon.length; i++){
                writer.print(pokemon[i]);
            }
            writer.close();
        }
        catch(UnsupportedEncodingException x){
        }
        catch (FileNotFoundException x){
        }

        /*
        for (int i = 0; i < pokemon.length; i++){
            System.out.print(pokemon[i]);
        }
        */
    }

    static String readFile() throws IOException {
        String text = "";
        Scanner scanner;
        try {
            scanner = new Scanner(new File("GAME_MASTER_v0_1.txt"));
            text = scanner.useDelimiter("\\A").next();
        }
        catch (IOException x){}
        //System.out.println(text);
        return text;
    }

    private static Pokemon[] findPokemon(String content) {
        Pokemon[] pokemon = new Pokemon[151];
        String pokemonName, type_1, type_2, pokemonParentName, familyPokemonName;
        int familyID, candyToEvolve, pokemonID, pokemonParentID, evolutionID;

        int pokemonCount = 1;

            while (pokemonCount <= 151 && content.length() > 1) {
                pokemonName = "";
                type_1 = "";
                type_2 = "";
                pokemonParentName = "";
                familyPokemonName = "";
                familyID = -1;
                candyToEvolve = -1;
                pokemonID = pokemonCount;
                pokemonParentID = -1;
                evolutionID = -1;

                System.out.println(pokemonID);
                System.out.print(content);
                content = content.substring(content.indexOf("Pokemon {")+2);

                //get pokemon name
                content = content.substring(content.indexOf("_POKEMON_")+9);
                pokemonName = content.substring(0,content.indexOf("\n"));
                    //System.out.println(pokemonName + " _print_");

                //first pokemon type
                content = content.substring(content.indexOf("Type1: POKEMON_TYPE_") + 20);
                type_1 = content.substring(0,content.indexOf("\n"));
                    //System.out.println(type_1 + " _print_");

                //second pokemon type
                if(content.indexOf("Type2: POKEMON_TYPE_") != -1 &&
                        content.indexOf("Type2: POKEMON_TYPE_") < content.indexOf("Pokemon {")){

                    content = content.substring(content.indexOf("Type2: POKEMON_TYPE_") + 20);
                    type_2 = content.substring(0,content.indexOf("\n"));
                }
                else type_2 = "n/a";
                    //System.out.println(type_2 + " _print_");

                //evolutionID
                if(content.indexOf("Evolution: \"\\") != -1 &&
                        content.indexOf("Evolution: \"\\") < content.indexOf("Pokemon {")) {

                    content = content.substring(content.indexOf("Evolution: \"\\") + 13);
                    try {
                        evolutionID = Integer.parseInt(content.substring(0, content.indexOf("\"")));
                    }
                    catch (NumberFormatException x){
                        System.out.println("\\t");
                    }
                }
                else evolutionID = -1;
                    //System.out.println(evolutionID + "_print_");

                //ParentID && Name
                if(content.indexOf("ParentId: V") != -1 &&
                        content.indexOf("ParentId: V") < content.indexOf("Pokemon {")) {

                    content = content.substring(content.indexOf("ParentId: V") + 11);
                    pokemonParentID = Integer.parseInt(content.substring(0,content.indexOf("_POKEMON")));

                    content = content.substring(content.indexOf("_POKEMON_") + 9);
                    pokemonParentName = content.substring(0,content.indexOf("\n"));
                }
                else {
                    pokemonParentID = -1;
                    pokemonParentName = "n/a";
                }
                    //System.out.println(pokemonParentID + " " + pokemonParentName + " _print_");

                //FamilyID && Name
                if(content.indexOf("FamilyId: ") != -1 &&
                        content.indexOf("FamilyId: ")< content.indexOf("Pokemon {")) {

                    if(content.indexOf("FamilyId: V") != -1 &&
                            content.indexOf("FamilyId: V") < content.indexOf("Pokemon {")) {

                        content = content.substring(content.indexOf("FamilyId: V") + 11);
                        familyID = Integer.parseInt(content.substring(0, content.indexOf("_FAMILY")));

                        content = content.substring(content.indexOf("_FAMILY_") + 8);
                        familyPokemonName = content.substring(0, content.indexOf("\n"));
                    }
                    else if(content.indexOf("FamilyId: ") != -1 &&
                            content.indexOf("FamilyId: ")< content.indexOf("Pokemon {")){

                        content = content.substring(content.indexOf("FamilyId: ") + 10);
                        familyID = Integer.parseInt(content.substring(0,content.indexOf("\n")));
                        familyPokemonName = "n/a";
                    }
                }
                else {
                    familyID = -1;
                    familyPokemonName = "n/a";
                }   //System.out.println(familyID + " " + familyPokemonName + "_print_");

                //CandyToEvolve
                if(content.indexOf("CandyToEvolve: ") != -1 &&
                        content.indexOf("CandyToEvolve: ") < content.indexOf("Pokemon {")) {

                    content = content.substring(content.indexOf("CandyToEvolve: ") + 15);
                    candyToEvolve = Integer.parseInt(content.substring(0,content.indexOf("\n")));
                }
                else candyToEvolve = -1;
                    //System.out.println(candyToEvolve + " _print_");

                pokemon[pokemonCount-1] = new Pokemon(pokemonName, type_1, type_2, pokemonParentName, familyPokemonName,
                        familyID, candyToEvolve, pokemonID, pokemonParentID, evolutionID);

                pokemonCount++;
            }

        return pokemon;
    }
}
