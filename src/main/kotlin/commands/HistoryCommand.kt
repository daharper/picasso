package commands

import core.CommandManager
import core.Input

class HistoryCommand(input: Input) : Command(input, false) {

    override fun execute() {
        val history = CommandManager.getHistory()

        println()

        for (command in history) {
            println(command.toString())
        }

    }
}