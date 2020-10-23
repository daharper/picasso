import commands.*
import core.*

fun main() {
    var cmd: Command = HelpCommand()
    cmd.execute()

    while (cmd !is QuitCommand) {
        Renderer.execute()

        val input = InputProcessor.readInput()

        try {
            cmd = when (input.command) {
                "B" -> FillCommand(input)
                "C" -> CanvasCommand(input)
                "D" -> DemoCommand(input)
                "H" -> HelpCommand(input)
                "L" -> LineCommand(input)
                "Q" -> QuitCommand(input)
                "R" -> RectangleCommand(input)
                "T" -> TriangleCommand(input)
                else -> InvalidCommand(input)
            }

            cmd.execute()
        }
        catch (e: Exception){
            println(e.message)
        }
    }
}