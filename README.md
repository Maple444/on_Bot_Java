# Atom Robotics Java Methods Repository (for viewers)

This repository is going to be used for storing and editing the methods we create as learn Java and program our robot. This can also be used for other folders related to programming for the team as well. 


## The `src` Folder (for viewers)
The src folder has been broken down to represent the 3 focuses of the programming team: Autonomous control, computer vision (through april tags), and teleOp control.

Check **src** > **Autonomous Control** > **on_bot_automous.java** to see the methods that will be used on the actual robot during the autonomous period. The most important file is `on_bot_autonomous.java`, which is the actual code used on the robot. This was created because of possible differences in the syntax between FTCSIM's simulated robot and the actual robot. `current_methods_ftcsim.java` is the file for current methods created while practicing in FTC SIM. `original_practice_methods_ftcsim.java` are the original methods that were created in FTC SIM but are no longer used on the robot. This file is for debugging and comparison primarily. 
`original_on_bot_autonomous.java` is a file containing the original autonomous code that functioned correctly (provided your robot is configured correctly). The main method declaration is not the correct method for FTC programming software, but the instantiations and methods can be copied directly into OnBot Java/Android Studio. This is what was done to original make it work, as the code was first written in Visual Studio Code and later transferred over to proper FTC programming software. Refer to on_bot_autonomous.java for working code, as this file is used as a reference for debugging.

Computer vision and april tag code can be found in the **Vision with April Tags** folder. Similarly, an "original" file has been created for debugging. A large amount of this code notably does not come from FTCSIM or our past knowledge of programming, and is instead entirely new. Bugs and malfunctions may be more common.

TeleOp code can be found in the **TeleOp Control** file. The main file we used at our last meet was `teleOp_Dpad.java`, and should be the primary reference for teleOp code. This also has an accompanying "original" file for debugging. 
There is also extra code written to make a tank drive robot. This code is untested at the moment. Note that there are 2 separate files for the left and right drives of the robot since we are currently using tank drive to move the robot. This was done in order to prevent confusion resulting from glitches and issues that can reportably occur when both the left and right drive methods are in the same file. Both methods have similar code, but serve different purposes. 

> Last updated 11/26/23


## Folder Structure (for editors, repository viewers can ignore)

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies (currently unused, may be used in the future if libraries are needed)

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management (for editors)

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
