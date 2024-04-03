# TCP-IP-Communicated-Pong-Game
## Table of contents
* [General info](#general-info)
* [Features](#features)
* [Dependencies](#dependencies)
* [Usage](#usage)
* [Possible future improvements](#possible-future-improvements)

## General info
This is a simple implementation of the classic Pong game written in Java. The game utilizes websockets for communication, Java JFrame for the GUI, inheritance for game elements, multithreading for concurrent processing, and serialization for game state persistence.

## Features
* Classic Pong gameplay with two paddles and a ball
* Real-time multiplayer functionality using websockets
* User-friendly GUI built with Java JFrame
* Object-oriented design with inheritance for game elements
* Multithreading to handle concurrent game logic and rendering
* Serialization for saving and loading game state

## Dependencies
* Java Development Kit (JDK)
* Java Websocket Library
* Java Swing Library (javax.swing.JFrame)
* Threads (java.lang.Thread)

## Usage
Use the up and down arrow keys or W and S to control the paddle. The goal is to bounce the ball past your opponent's paddle to score points. The game ends when one player reaches the maximum score limit (9).

## Possible future improvements
* Implement additional game features such as power-ups or different game modes.
* Enhance the GUI with better graphics and animations.
* Optimize network communication for smoother multiplayer experience.
* Add support for customization options like paddle colors or ball speed.
