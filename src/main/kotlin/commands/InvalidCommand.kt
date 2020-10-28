package commands

import core.Input

class InvalidCommand(input: Input) : Command(input, false) {

    override fun execute() {
        println("invalid command, please try again (enter ? for help)")
    }
}