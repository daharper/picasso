package commands

import core.Input

class QuitCommand(input: Input) : Command(input, false) {

    override fun execute() {
        println("thank you for trying Picasso")
    }
}