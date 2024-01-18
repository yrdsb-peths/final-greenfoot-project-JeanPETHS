# Final Greenfoot Project: Flag Seeker
This is a 2D animated game, in which you need to explore the world and figure out by yourselves how to **get to the red flag to win**! You are now the green character and have an initial health value of 6 (half of a heart = 1)! There are two worlds which have different themes.

*Arrays can be found as instance variables at the top of these classes: gameWorld1, gameWorld2, HealthValue, GlassBottle, HintCharacter.


Game World 1:
- Type: **Regular**
- Setting: **Forest**
- Level: **Easy**
- Hint: Follow the instructions & maybe also stand on the hint characters?

Game World 2:
- Type: **Exploring**
- Setting: **Food**
- Level: **Hard**
- Hint: No hint characters & **do not fall to the bottom of the world** (which means -2 in health value...)! Wait...what is that **ice-cream** and **glass bottle** for?

(Always try to use the *space* key to trigger something!!)

All instructions are in the game, but will be listed below again.

## Instructions
General rule: You will start with a green character. Your goal is to get to the red flag as fast as possible! Use *"a"* to move left, *"d"* to right, *"w"* to jump.
        
Green Character: the one that you can control
        
Health Value: represents how much HP is left; if HP=0, game over
        
Trap: reduce HP if touching & don't stay on it!!!

Key: use this to open locked boxes

Diamond: obtained by touching, can be used to revive or added to final score

Switch: touch this & press *space* to unlock the box under it with a key

Locked Box: has something in it

Unlocked Box: already opened

Cloud: moving at a constant speed & can carry characters

Jumper: pump character into the sky if stand on it

Ladder: hold *"w"* to climb & adjust your position by *"a"*/*"d"*

Flag: touch & win!!!

Hint Character: gives you a hint if stand on this

## Features
### Score
If not reach the flag: 0

If reach the flag:
1. Less **time** used: higher score!
2. **HP** is NOT full: reduce score by 10 for each lost health point.
3. Number of **diamonds**: one diamond counts as 60 points towards the score!!!

### Medals
There will be 3 types of medals:
1. Gold: above or equal to cut off score
2. Silver: above or equal to (cut off score-1000)
3. Bronze: above 0

And a snowman achievement: congratulations that you get **0**! Try it again, don't give up!!!

(Each game world will have its own medal cut off score based on its difficulty.)

### Mission
Keep safe, use the least amount of time, find diamonds, and reach the **flag**!!!

### Final Hints
- Step on traps & fall to the bottom of the world are the only 2 ways that will reduce health value (so far)!
- Game World 1: fairly simple because you have hint characters.
- Game World 2: this is all about exploring objects by yourself, this world is all about food! See what are some little *surprises* that would bring you something!
- The maximum score you can get for Game World 1 is 5860, for game World 2 is 9120. However, it is impossible to get the full score because that is based on the time used being 0 secs! If you want to know what is your true level, watch out for the medals (and probably the snowman?)!
- Be calm!

## Credits
- Assets: Kenney
- Sounds: Mixkit