(a)
About the Assignment:

I create a RoomViewPanel by creating the InnerRoom class.When user click mouse on a room, the picture of the room and things contained by that room will be shown in the RoomView Panel, so does an image of the player (a mushroom). The move of player will be the same as how the player moves in the game board (after use the Move Here button to move the player to a room, the mushroom player will appear in the RoomViewPanel). Items shown on the RoomViewPanel will disappear when it disappears from the game board. Information about the picture been used and other variables are still contained by Room objects and Item objects.

Theres 3 new widgets on the Control Panel. The combo box "Item Size" can change the size of items shown in the RoomView Panel. Choosing "Large" will make the item 1.5 times bigger than choosing "Regular". The 2 new buttons (↑ and ↓) can change the position of the mushroom player in the RoomViewPanel.

After the player killed the monster, the RoomViewPanel shows "YES YOU WIN".

Something more: 
i. This is the first time I import images to the game.
ii. Pause and Continue function: using the 2 new menu item "Pause" and "Continue", user can pause the game and start it again after been paused.

(b)How to use the program
To move the player, click a room and click "Move Here" button. To collect items, move the player to the room, click the item then click "Pick Up" button.A locked room can't be entered directly and the item in it can't be collected. Collect "Key" and the state of "Key" on the state panel will change into "true", click the locked room and click "Use Key" button, then player can go into the room and collect the "Gold" in it.The "Sword" can't be collected unless all "Gold" are collected. If we try to "Pick Up" sword before we have all gold, there will be a pop window.If we try to collect the "Monster", the health point (HP) of the player will decrease, which will be shown on the state panel. If HP = 0,  there will be a pop window says that the player is dead and we need a sword to fight against the monster . After we get the sword, enter the room of the monster and click "Use Sword" button, HP of the monster will decrease.The radio button on the control panel can lock or unlock the room.  Click the room you want to lock or unlock then choose a radio button.To change the player’s speed, click on player and use the combo box.And there's a working slider which can increase the player's HP.

About the 3 new widgets on the Control Panel and 2 new menu items in the drop-down menu, please see (a) About the Assignment.( c)Inheritance HierarchyParent class: Item.Subclass: Gold, Key, Sword, Monster.(d)Aggregation Hierarchy(A:B means A contains B)Main: Board, Game, ControlPanel, StatePanel, InnerRoom, PopWindow.Game: Board.Board: Room.Room: Item.(d) Collaboration relationships(A:B means A uses B to perform functions)Main: Board, Game, ControlPanel, StatePanel.Game: Board, InnerRoom.Board: Room, Item.ControlPanel: Game, Board, Room, Item.StatePanel: Game, Board, Item.PopWindow: Game, ControlPanel.
InnerRoom: Game(e)Encapsulation.Game: set and return the whole state of the game, when mouse click occurs or some button is pressed, the value will be set and get through Game.Board: receive the state of the selected room and position of player then return correspondingly variables.Room: the state of rooms is encapsulated in the Room class.