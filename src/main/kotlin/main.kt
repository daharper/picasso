import commands.*
import core.*

fun main() {
    var cmd = CommandManager.execute(HelpCommand())

    while (cmd !is QuitCommand) {
        try {
            Renderer.execute()

            val input = InputProcessor.readInput()

            cmd = CommandManager.execute(input)
        }
        catch (e: Exception){
            println(e.message)
        }
    }
}