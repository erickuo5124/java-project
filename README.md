# Fight COVID-19

## Overview
This project is a game designed to raise awareness about the importance of taking preventive measures against COVID-19. Players must use knowledge and resources to defend against the virus and protect their community. The game is inspired by the popular game "Plants vs. Zombies."

## Game Rules
In the face of the COVID-19 pandemic, players must be prepared to take action. Players can collect knowledge from books, use masks to defend against the virus, and use alcohol to eliminate it. The game emphasizes the importance of knowledge, responsibility, and taking action in the fight against COVID-19.

## User Interface
The game field consists of a 3x10 grid. Players can place various objects on the grid to defend against the virus.
![](https://i.imgur.com/H9FEpo6.jpg)

![](https://i.imgur.com/ymmQIl8.jpg)
![](https://i.imgur.com/XNu4fUB.jpg)
![](https://i.imgur.com/NnqzLSD.jpg)

## Characters
### Home Base
The home base represents the player's community. Players must protect the home base from the virus.

### Preventive Measures (Plants)
Players can place various preventive measures on the grid to defend against the virus. Each preventive measure has different attributes, such as health points (HP), attack points (ATK), cost, and speed.

| Name | HP | ATK | Cost |Speed| Description |
| - | - | - | - | - | - |
| Book ![](https://i.imgur.com/wxOQNri.gif)| 30 | 0 | 50 |0| Collects knowledge. ![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/sun.png?raw=true)(yield:30/6秒)|
| Alcohol ![](https://i.imgur.com/apmPAp3.gif)|50|10|100|1|Shoots alcohol droplets (Bullet) ![](https://i.imgur.com/YLtkTos.png) to eliminate the virus.|
|mask ![](https://i.imgur.com/yl2pK8Z.gif)|100|0|50|0|Acts as a barrier against the virus.|
|Thermometer ![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/plants/freezepeashooter.gif?raw=true)|50|10|150|1|Slows down the virus.![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/freezepea.png?raw=true)|
|QR Code ![](https://i.imgur.com/KKcUKc4.png)![](https://i.imgur.com/c6ybIKH.png)|10|$\infty$|150|0|Eliminates viruses within a certain range.|

### Virus (Zombies)
The virus represents the enemy in the game. There are different types of viruses with varying attributes, such as health points (HP), attack points (ATK), and speed.

- Normal Virus
- Strong Virus
- Teleporting Virus

| Name | HP | ATK |speed| 
| - | - | - | - |
|Normal Virus![](https://i.imgur.com/o0Sw5V8.gif)|40|10|4|
|Strong Virus![](https://i.imgur.com/0kll6yh.gif)|100|10|4|
|Teleporting Virus ![](https://i.imgur.com/aiznaTT.png)|50|10|Waits 8 seconds and then teleports to the front line|

## Technical Details
The game is implemented in Java and uses a 2D array to manage objects on the game field. The game has multiple timers to handle various game events, such as generating sunlight, spawning viruses, detecting collisions, and updating the game field.

![](https://i.imgur.com/walouxp.png)


### Object Management
The game uses three separate 2D arrays to manage the objects displayed on the game field. Each array corresponds to a specific type of object: plants, viruses, and projectiles. The game field is represented as a 3x10 grid, and each cell in the grid can hold one object.

- `plant`: A 3x10 array that holds the plant objects placed by the player. Each cell can contain one plant, such as a Book, Alcohol, Mask, Thermometer, or QR Code.
- `virus`: A 3x10 array that holds the virus objects that spawn on the right side of the game field. Each cell can contain one virus, such as a Normal Virus, Strong Virus, or Teleporting Virus.
- `bullet`: A 3x10 array that holds the projectile objects fired by certain plants. Each cell can contain one projectile, such as an alcohol droplet.
The game's user interface (UI) reads these arrays to display the corresponding objects on the game field.

### Timers
The game uses four timers to handle various game events:

- `suntimer`: This timer runs every 5 seconds and adds 10 units of sunlight to the player's resources. Sunlight is used to place plants on the game field.
- `virustimer`: This timer runs every 5 seconds and spawns a virus on the rightmost side of the game field. The virus then moves towards the left side of the game field.
- `detectiontimer`: This timer runs every second and checks for collisions between objects. It handles events such as viruses attacking plants, projectiles hitting viruses, and viruses reaching the leftmost side of the game field.
- `repainttimer`: This timer runs every second and updates the three object arrays to reflect the current state of the game.

### Object Overlap
Due to the use of 2D arrays, overlapping objects of the same type are not recorded separately. However, the game handles overlapping objects by stacking their attributes. For example, if two viruses occupy the same cell, one virus inherits the other's health points (HP) and attack points (ATK).

## reference
[plants vs zombies](https://github.com/arminkz/PlantsVsZombies)
