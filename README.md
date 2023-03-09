# Brick-Breaker

Brick breaker is a game where the player must break all of the bricks available in order to win. However, if the player didn't bounce the ball on time then he/she loses the game. This game receives 3 inputs from the user which are "Enter", left, and right keyboard key. The "Enter" key is pressed to start the game while the left/right keys are used to move the paddle.

It was built with Java programming language. It is consisted of 3 classes which are Main, Gameplay,and mapbrick. The main class is used for initializing the frame and launching the game, Gameplay is used to set the properties of the game (telling the game what to do), and the mapbrick class is used to set the level of the game. It implements the concept of 2D arrays and also utilizes methods. The 2D array here is used to map all of the bricks for the level for the game. 

Methods are used in Gameplay and mapbrick classes. 

Methods which are used in Gameplay class are:
- paint = draws the level of the brick breaker game
- actionPerformed = specifies the behavior of the game while being played (further description in the code)
- keyTyped = determines which key is typed with the keyboard
- keyReleased = determines which key is released (not pressed anymore)
- keyPressed = tells the game what to do if a certain key is pressed.
- moveRight = the paddle will move 20 pixels to the right
- moveLeft = the paddle will move 20 pixels to the left

Methods which are used in mapbrick class are:
- draw = draws he bricks inside the level
- setBrickVal = sets the value of the bricks in the level

The scene which is shown when the game is launched:
![Screenshot (463)](https://user-images.githubusercontent.com/89509753/224057810-f79f97e3-ecb5-44c4-a9c4-15fa174fa758.png)

Win scene when the player successfully break all of the bricks:
![Screenshot (459)](https://user-images.githubusercontent.com/89509753/224054628-4ce472b1-2dd9-4e2d-9a0a-c1ab232141dc.png)

Lost scene when the player failed to bounce the ball in order to break all of the bricks:
![Screenshot (461)](https://user-images.githubusercontent.com/89509753/224057115-b7dcbb05-8fdf-42ce-92ae-d74f7b089b51.png)

Gameplay:
https://user-images.githubusercontent.com/89509753/224060371-ed057c6e-e304-46aa-b6db-d9f4e0cc6a5b.mp4
