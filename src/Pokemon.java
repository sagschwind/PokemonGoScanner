/**
 * Created by Steven on 7/17/16.
 */
public class Pokemon {
    String pokemonName, type_1, type_2, pokemonParentName, familyPokemonName;
    int familyID, candyToEvolve, pokemonID, pokemonParentID, evolutionID;

    public Pokemon(String pokemonName_, String type_1_, String type_2_, String pokemonParentName_, String familyPokemonName_,
                   int familyID_, int candyToEvolve_, int pokemonID_, int pokemonParentID_, int evolutionID_){

        pokemonName = pokemonName_;
        type_1 = type_1_;
        type_2 = type_2_;
        pokemonParentName = pokemonParentName_;
        familyPokemonName = familyPokemonName_;

        familyID = familyID_;
        candyToEvolve = candyToEvolve_;
        pokemonID = pokemonID_;
        pokemonParentID = pokemonParentID_;
        evolutionID = evolutionID_;
    }

    public String toString(){
        String str = "ID: " + pokemonID + " - " + pokemonName + "\n";
        str += "Type_1: " + type_1 + "\n";

        if(!type_2.equals("n/a")){
            str += "Type_2: " + type_2 + "\n";
        }

        if(evolutionID != -1) {
            str += "Evolution_ID: " + evolutionID + "\n";
        }

        if(candyToEvolve != -1) {
            str += "Candies_To_Evolve: " + candyToEvolve + "\n";
        }

        if((pokemonParentID != -1 && !pokemonParentName.equals("n/a")) ||
                (familyID != -1 && !familyPokemonName.equals("n/a"))) {

            str += "\n";

            if (pokemonParentID != -1 && !pokemonParentName.equals("n/a")) {
                str += "Pokemon's_Parent:" + pokemonParentID + " - " + pokemonParentName + "\n";
            }

            if (familyID != -1 && !familyPokemonName.equals("n/a")) {
                str += "Family: " +  familyID + " - " + familyPokemonName + "\n";
            }
        }

        str += "-------------------------------------------------\n";

        return str;
    }
}
