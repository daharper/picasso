package commands

import core.CommandManager
import core.Input
import java.io.File

class LoadCommand(input: Input) : Command(input, false) {

    var filename: String = ""

    init {
        require(1, "invalid command, please try: O picasso.txt")

        filename = getString(0)
    }

    override fun execute() {
        val commands = File(filename).readLines()
        CommandManager.replay(commands)
    }
}