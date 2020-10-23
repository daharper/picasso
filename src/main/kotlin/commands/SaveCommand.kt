package commands

import core.CommandManager
import core.Input
import java.io.File

class SaveCommand(input: Input) : Command(input, false) {

    private var filename: String = ""

    init {
        require(1, "invalid command, please try: S picasso.txt")

        filename = getString(0)
    }

    override fun execute() {
        val history = CommandManager.getHistory()

        File(filename).printWriter().use { out ->
            history.forEach {
                out.println(it.toString())
            }
        }
    }
}