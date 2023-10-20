## Atom Robotics Java Methods Repository (for viewers)

This repository is going to be used for storing and editing the methods (same thing as a function) we create as learn Java and program our robot. This can also be used for other folders related to programming for the team as well. 


# The `src` Folder (for viewers)
The src folder has been broken down to represent the 3 focuses of the programming team: Autonomous control, computer vision (through april tags), and teleOp control.

Check `src` > `Autonomous Control` > `on_bot_automous.java` to see the methods that will be used on the actual robot during the autonomous period. current_methods_ftcsim.java is the file for current methods created while practicing in FTC SIM. 
original_practice_methods_ftcsim.java are the original functions that were created in FTC SIM but are no longer used on the robot. This file is for debugging and comparison primarily.

Computer vision and april tag code can be found in the `Vision with April Tags` folder. Similarly, an "original" file has been created for debugging.

TeleOp code can be found in the `TeleOp Control` file. This also has an accompanying "original" file for debugging.

> Last updated 10/19/23


# Folder Structure (for editors, repository viewers can ignore)

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies (currently unused, may be used in the future if libraries are needed)

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

# Dependency Management (for editors)

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
