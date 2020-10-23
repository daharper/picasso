package commands

import core.Input

class HelpCommand(input: Input? = null) : Command(input ?: Input(), false) {

    override fun execute() {
        println("Welcome to Picasso, available commands:")
        println()
        println("A                  - Displays developer contact information")
        println("C 20 4             - Create a new canvas 20 (width) 4 (height)")
        println("D                  - Demonstrates the execution of the requirements")
        println("E                  - Erase the command history")
        println("B 10 10 o          - Bucket fill with o starting at 10 (x) 10 (y)")
        println("H                  - shows a history of commands applied to the canvas")
        println("L 1 1 10 10 x      - Draw a line from 1,1 to 10, 10 (x: pen is optional)")
        println("O picasso.txt      - Reads commands from file picasso.txt")
        println("P 1 1 o            - Plots the point o at 1,1")
        println("Q                  - Quit the application")
        println("R 1 1 10 10 x      - Draw a rectangle from 1,1, to 10,10 (x: pen is optional)")
        println("S picasso.txt      - Saves the command history to the file picasso.txt")
        println("T 1 1 1 10 5 5 x   - Draw a triangle with points 1,1 and 1,10 and 5,5 (x: pen is optional)")
        println("U                  - Undo the last command")
        println("W 1 1 Hello World! - Write text at point 1,1")
        println("?                  - displays this help")
    }
}