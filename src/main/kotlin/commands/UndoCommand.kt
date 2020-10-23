package commands

import core.CommandManager
import core.Input

class UndoCommand(input: Input) : Command(input, false) {

    override fun execute() {
        CommandManager.undo()
    }
}