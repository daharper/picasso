import commands.*
import core.*

fun main() {
    var cmd = CommandManager.execute(HelpCommand())

    while (cmd !is QuitCommand) {
        Renderer.execute()

        val input = InputProcessor.readInput()

        try {
            cmd = CommandManager.execute(input)
        }
        catch (e: Exception){
            println(e.message)
        }
    }
}