package commands

import core.Input

class InvalidCommand(input: Input) : Command(input) {

    override fun execute() {
        println("invalid command, please try again")
    }
}