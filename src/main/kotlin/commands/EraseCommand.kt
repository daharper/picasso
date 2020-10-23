package commands

import core.CommandManager
import core.Input

class EraseCommand(input: Input) : Command(input, false) {

    override fun execute() {
        CommandManager.clear()
    }
}