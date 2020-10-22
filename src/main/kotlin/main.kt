import commands.*
import core.*

fun main() {
    var cmd: Command = InvalidCommand(Input())

    while (cmd !is QuitCommand) {
        Renderer.execute()

        val input = InputProcessor.readInput()

        try {
            cmd = when (input.command) {
                "B" -> FillCommand(input)
                "C" -> CanvasCommand(input)
                "D" -> DemoCommand(input)
                "L" -> LineCommand(input)
                "Q" -> QuitCommand(input)
                "R" -> RectangleCommand(input)
                else -> InvalidCommand(input)
            }

            cmd.execute()
        }
        catch (e: Exception){
            println(e.message)
        }
    }
}