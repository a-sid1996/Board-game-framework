# Board-game-framework
Project for SOEN 6441
## Contributors
* Krunal Jagani
* Siddhant Arora
* Harsh Vaghani
* Jatan Gohel

## Download and Installation
1. Clone and Open the Project in any Java IDE (eg: Eclipse, IntelliJ IDEA, etc.)
2.Before Running the project, ensure you have all the dependencies of the project configured.
3. To find the jars of the dependies, please go to `resoureces` directory
4. Run `MainMenuScreen.java` to execute the game framework
5. One can follow the GUI to create, edit or load map. Sample maps are in the `controller` directory named `FinalMapFile.json` and `FinalMapFile - Copy.json`
6. Game-specific phases (Monopoly)
  * Startup Initialization
  * Player objects initialization
  * Banker object initialization
  * Initial money distribution
  * Player position setup
  * Reinforcement
  * Fortification
  * Tournament Mode - To play the auto Strategy patterned game (`Agressive Player`, `Conservative Player`, `Cheater Player`, `Random Player`)
7. All the test cases are in the `test` directory. Please make sure `JUnit` is added as dependency to run the test suite.

## Working with this GitHub repository

1. Cloning locally,
 * Go to terminal
 * Choose directory to save file (use cd to change directory, dir "windows" OR  ls "Mac OS" to show what is in folder
 * Use ```git clone https://github.com/a-sid1996/Board-game-framework.git```

After doing some code....
* Go to terminal
* Locate folder for which clone was made
* Use ```git status``` to check how many files differ/changed
* Use ```git init``` to check which repo u r at
* Use ```git branch``` to know which branch u r at, DONT USE MASTER to add files
* Use ```git push origin master``` if u want to update your codes to what exists and you haven't done any coding yet since cloning!
* Else, follow the following process to add files, commit , push into git and Pull Request to be merged!

Then follow the process in the terminal local directory

1. Create new branch locally
  * Branch name should be named as ```feature-name``` followed by a condensed version of the task name
  * Use ```git checkout -b branch_name``` to create branch locally

2. Commit changes to branch
  * ```git add name_of_file_to_add``` to add file (* for all files)
  * ```git commit -m "commit_message"``` to commit changes
  * ```commit_message``` should start with the task number in square brackets

3. Push changes to branch
  * ```push remote origin branch_name```
  * ```git push origin```

4. Pull request
  * When the task is finished, open a pull request on the branch
  * Set someone as a reviewer
  * Once the review is complete, merge into dev.
  
  

2. Mention steps on how to create a new map, save and load an existing map. Include any sample maps (one correct and one incorrect map) in your project. 
3. Mention all the game-specific phases. (For teams not implementing RISK)
4. Mention any other details that you think might be useful for me to test all the requirements for example- test cases etc. (Note: While executing, your game should not crash in the middle so any relevant information is helpful)
