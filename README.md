# Fragments of Reality

## Overview

**Fragments of Reality** is a 2D pixel-art narrative puzzle-adventure game developed using **Java** and **LibGDX**.

The player awakens inside a mysterious world with no memories of who they are. Their mind has shattered into five fragmented memory rooms, each representing an important part of their forgotten past. To escape this world, players must explore every room, solve memory-based riddles, recover the lost Memory Fragments, and restore their identity.

Every decision matters. Correct answers restore memories, while incorrect answers summon dangerous Phantoms that attack the player and reduce their life.

---

## Story

You awaken in a strange world with no recollection of your past. At the center lies the **Memory Nexus**, the last remaining connection to your forgotten identity.

Five mysterious rooms surround the Nexus, each containing fragments of your memories hidden behind puzzles and riddles. Every recovered fragment slowly rebuilds your identity, while every mistake brings the darkness closer.

Will you remember who you are before your life runs out?

---

## Features

- 2D pixel-art adventure
- Narrative-driven gameplay
- Five unique memory rooms
- Puzzle and riddle mechanics
- Memory Fragment collection system
- Life and Memory progress tracking
- Phantom enemy system
- Camera-follow player movement
- Multiple game states (Win/Lose)

---

## Gameplay

The player begins in the **Memory Nexus**, the central hub connecting all five memory rooms.

Each room contains:

- A unique environment
- A memory-based puzzle
- A hidden Memory Fragment

### Correct Answer

- Unlocks the room
- Reveals the Memory Fragment
- Increases Memory by **20%**

### Wrong Answer

- Summons a Phantom
- Player loses Life
- The puzzle must be attempted again

Collecting all five fragments restores the protagonist's memories and unlocks the true ending.

---

## Controls

| Key | Action |
|------|--------|
| W | Move Up |
| A | Move Left |
| S | Move Down |
| D | Move Right |
| Arrow Keys | Move |
| E | Interact / Enter Rooms |
| ESC | Pause (Future Feature) |

---

## Game Objectives

- Explore all five memory rooms
- Solve every puzzle
- Recover all Memory Fragments
- Restore Memory to **100%**
- Avoid Phantom attacks
- Escape the shattered world

---

## Winning Condition

The player wins after collecting all five Memory Fragments, restoring **100% Memory**, and completing every memory room.

---

## Losing Condition

The player loses if their **Life Percentage reaches 0%** before all Memory Fragments are collected.

---

## Technologies Used

- Java
- LibGDX
- Gradle
- IntelliJ IDEA
- Tiled Map Editor
- Pixel Art Assets

---

## Project Structure

```
core/
│
├── entities/
│   ├── Player.java
│   ├── Phantom.java
│   └── MemoryFragment.java
│
├── managers/
│   ├── MemoryManager.java
│   ├── DialogueManager.java
│   └── CollisionSystem.java
│
├── screens/
│   ├── MenuScreen.java
│   ├── PlayScreen.java
│   ├── RoomScreen.java
│   └── EndingScreen.java
│
├── assets/
│   ├── maps/
│   ├── ui/
│   ├── player/
│   └── audio/
```

---

## Installation

Clone the repository:

```bash
git clone https://github.com/Yanele22/Fragments-of-Reality.git
```

Open the project in **IntelliJ IDEA**.

Run:

```
gradlew lwjgl3:run
```

or run the **Lwjgl3Launcher** class directly from IntelliJ.

---

## Future Improvements

- Save and Load System
- Animated NPCs
- Improved AI for Phantoms
- Sound Effects and Background Music
- Inventory System
- Dialogue Choices
- Cutscenes
- Multiple Endings
- Controller Support

---

## Team

Developed by:

- **Yanele Bhengu**
- **Ludwick Molebale**
- **Boitumelo Rachoshi**
- **Neo Phukubye**
- Campus Games Day Team

---

## Acknowledgements

Special thanks to:

- LibGDX
- Tiled Map Editor
- OpenGameArt
- Itch.io Asset Creators
- Campus Games Day

---

## License

This project was created for educational purposes as part of the **Campus Games Day** challenge.

© 2026 Fragments of Reality Team
