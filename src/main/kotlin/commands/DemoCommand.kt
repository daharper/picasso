package commands

import core.Input

class DemoCommand(input: Input) : Command(input) {

    override fun execute() {
        CanvasCommand(Input("C", listOf("20" ,"4"))).execute()
        LineCommand(Input("L", listOf("1", "2", "6", "2"))).execute()
        LineCommand(Input("L", listOf("6", "3", "6", "4"))).execute()
        RectangleCommand(Input("R", listOf("14", "1", "18", "3"))).execute()
        FillCommand(Input("B", listOf("10", "3", "o"))).execute()
    }
}