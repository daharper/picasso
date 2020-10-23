package commands

import core.Input

class HelpCommand(input: Input? = null) : Command(input ?: Input()) {

    override fun execute() {
        println("Welcome to Picasso, available commands:")
        println()
        println("C 20 4          - Create a new canvas 20 (width) 4 (height)")
        println("D               - Demonstrates the execution of the requirements")
        println("B 10 10 o       - Bucket fill with o starting at 10 (x) 10 (y)")
        println("L 1 1 10 10     - Draw a line from 1,1 to 10, 10")
        println("Q               - Quit the application")
        println("R 1 1 10 10     - Draw a rectangle from 1,1, to 10,10")
        println("T 1 1 1 10 5 5  - Draw a triangle with points 1,1 and 1,10 and 5,5")
    }
}