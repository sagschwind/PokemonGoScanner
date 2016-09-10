# PokemonGoScanner
This program was created to read through the first [PokemonGo data dump](GAME_MASTER_v0_1.txt) and transform it into [readable list](PokemonGo_List.txt).

Each of the Pokedex entries consists of the ID number, name, types, the ID of the Pokemon that they evolve into, number of candies to evolve and the family ID number.

This program was created before I knew about JavaScript Object Notation (JSON), so it has very rudimentary JSON parsing using Java string methods. For example it seraches for keywords with String.indexOf() and String.substring() methods instead of using the Dictionaries, Arrays and other data formats. 

\* For more proper JSON parsing, look at my [PSUGymWatcher](https://github.com/sagschwind/PSUGymWatcher) application in the [ViewController.swift](https://github.com/sagschwind/PSUGymWatcher/blob/master/PSUGymWatcher/ViewController.swift#L83) file starting on line 83. 
