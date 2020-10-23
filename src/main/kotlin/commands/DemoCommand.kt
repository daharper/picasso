package commands

import core.CommandManager
import core.Input

class DemoCommand(input: Input) : Command(input, false) {

    override fun execute() {
        val commands = listOf(
            "c 20 4",
            "L 1 2 6 2",
            "L 6 3 6 4",
            "R 14 1 18 3",
            "B 10 3 o"
        )

        CommandManager.replay(commands)
    }
}