# JFX-Games
Need a gift for your girlfriend/boyfriend and you are a developer? Maybe this can be usefull for you.<br>
I made a little gift for my gf and now I share the project, if you want do a little gift try to configure and build this

<br><br>
___

## What you need
Java 8 or superior, gradle 5 or superior and a little bit of pacience for the developer.<br>
Java 8 or superior or a wrapper for that (Like Laucher4J) and some fun for the final user.

## What is
This project is a little gift included some games in JFX, every time that you win a section you can see a reward

## Configure

#### Info section
Edit class **InfoController** and set in *infoLabel* object for info text area, set here your lovely message.<br>
There are a small cheat for enable all rewards, for change password "secret" with your new password.<br>
In the execution you can put the password in a small label in top of the panel

#### Rock-paper-scissors game (Sasso carta forbici)
This section is in italian, sorry, you can change the labels in class **SCFController** and the labels in file **SCF.fxml**<br>
FYI
- Sasso --> Rock
- Carta --> Paper
- Forbici --> Scissors

#### Memory Game
Here you need to create the images for the pairs, create 8 images with incremental name (1.jpg, 2.jpg, 3.jpg, 4.jpg ...) the size will be 400x400.<br>
Use your personal lovely images. Set it under: */resources/memory*

#### Blackjack
Here you need to create the cards using **number** or **j** or **q** or **k** - followed by suit (**c** for clubs, **d** for diamonds, **h** for hearts and **s** for spade) *Be carefull* the ace is **a** and the 10 is **t**.<br>
*Ex. ac.gif - as.gif - 2c.gif - 2d.gif  etc...*<br>
You can easly find the cards already done in [this project](https://github.com/NeelAPatel/Blackjack/tree/bf23ede5c81c3209d4cb3f70a94b90ebf6077bc2/Blackjack/Resources "NeelAPatel Blackjack")<br>
Put the images in */resources/blackjack/cards*<br>

#### Rewards
Last thing is config the reward images, under */resources/rewards* create 3 new jpg images (Reward1.jpg, Reward2.jpg and Reward3.jpg).<br>
Here put your lovely images, or an image with some lovely text or anything else...

## Build
Done the configuration? Well now you can build with gradle or using your IDE exporting a runnable JAR, put it in a USB device and you have strange, but particular gift

Bye

