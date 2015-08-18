# FSA
This is the Java Code for testing Finite State Automata.

```
java -jar fsa.jar <transition table csv file> <string to be checked for d-recognize>
```

## How To Run
1. Download the fsa.jar file from this link: <http://1drv.ms/1EAw2EP>
2. Open Terminal or Command Prompt
3. Go to the directory where you put the fsa.jar file
4. Before you run using java -jar fsa.jar command, you need to create a csv file that describes the transition table to be used by FSA. Transition Table csv file must have the following format, `Origin State,Next State,Value` (where Origin State and Next State is greater than or equals to 0. -1 is used as the ending state as exception.). You can find the sample csv file from this link: <http://1drv.ms/1hm0LRq>
5. Run the following command in the Terminal or Command Prompt 
```
java -jar fsa.jar sheep_fsa_transition_table.csv baa!
```
