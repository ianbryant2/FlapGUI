# AI Learns Flappy GUI

Description
-----------

This project uses javafx to create a simple GUI for the AI Learns Flappybird project. It will run a modified version of the project that implements a protocol that allows the passage of information between the process running the project and the GUI.

Future Features/Improvements
----------------------------

(Going from most important to least)

1. Do not require the user to press the enter button when entering information into the GUI

1. Add the ability to evaluate own weights

1. Do not allow multiple processes to run at once

Setup (Tested on Windows with Java 17.09 and Maven 3.9.5)
--------------------------------------------------------

```bash
git clone https://github.com/ianbryant2/FlapGUI
```

or download the zip and extract

How To Use
----------

Run:

```bash
mvn javafx:run -f "path\to\pom.xml"
```

- Make not to click start multiple times as it would cause multiple processes to start

- Make sure to press enter when entering data into GUI for it to be included when starting the process
