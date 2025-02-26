# Ecosystem Simulator

___
## Overview
This Java application is a basic ecosystem simulator. This program allows the user to create or delete the plants and animals of their choosing when running the simulation. When simulating, the program will use methods unique to the different creatures to simulate its turn, then continue to the next. This program utilizes object-oriented principles and error handling techniques to ensure smooth simulations every time!

___
## Table of Contents
- [Features](#features)
- [Code Structure](#code-structure)
- [Tech Stack](#tech-stack)
- [License](#license)
- [Future Enhancements](#future-enhancements)
- [Author](#author)
---
## Features
- **Creature Manipulation**: When starting the program, the user has the option to create entities by providing the name, type if entity, and what the entity eats, or the user can delete entities. Once ready, the simulation will begin with what the user implements!

- **Listing Creatures**: When starting the program, the user has the ability to list the entities that will be in the simulation to help determine whether they want more or less entities or if they are ready to begin the cycle!
- **Simulation**: When the user begins the simulation, the program will iterate through an array list of the entities, allowing each separate entity to complete their actions before continuing on to the next. When the simulation ends, there will be a list of entities that died during the past simulation cycle.
---
## Code Structure
**Ecosystem Simulation**

├── **Main.java**          # Class that represents the main screen, directing the user inputs

├── **Ecosystem.java**     # Class that makes utilizes user inputs and marks the beginning and end of the simulation

├── **Entity.java**        # Abstract Class shared by Animal and Plant Classes implementing their separate interaction methods

├── **Animal.java**        # Class inheriting the Entity Class that stores Animal specific methods 

├── **Plant.java**        # Class inheriting the Entity Class that stores Plant specific methods

---
## Tech Stack
- ![Amazon Corretto](https://img.shields.io/badge/Amazon_Corretto-blue?style=for-the-badge&logo=amazon-aws&logoColor=white)
- ![Java Version](https://img.shields.io/badge/Java-11-blue)
- ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
---
## License
- ![License](https://img.shields.io/badge/License-MIT-green)
- Copyright &copy; 2025 Breckin Lukehart. **All rights reserved.**
---
## Future Enhancements
1. Different creature types that interact differently.
2. More diverse actions and utilizing creature variables differently.
3. Support for saving and loading creature data to/from a file.
---
## Author
<img src="https://github.com/Breckin1027.png" alt="Profile Picture" width="100" />

___
**Breckin Lukehart**

- **Breckin's GitHub Profile**: [Breckin1027](https://github.com/Breckin1027)
- **Breckin's Email**: [brluke01@wsc.edu](mailto:brluke01@wsc.edu)

[⬆️ Return to Top](#overview)
