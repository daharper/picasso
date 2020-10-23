package commands

import core.Canvas
import core.Input

class CanvasCommand(input: Input) : Command(input) {

    private var height = 0
    private var width = 0

    init {
        require(2, "invalid command, try: C 20 4")

        width = asInt(0)
        height = asInt(1)

        if (width < Canvas.minWidth || width > Canvas.maxWidth) {
            throw Exception("invalid width, min:${Canvas.minWidth} max:${Canvas.maxWidth}")
        }

        if (height < Canvas.minHeight || height > Canvas.maxHeight) {
            throw Exception("invalid height, min: ${Canvas.minHeight} max: ${Canvas.maxHeight}")
        }
    }

    override fun execute() {
        Canvas.initialize(width, height)
    }

    companion object {
        fun default() = CanvasCommand(Input("C", listOf("20", "4")))
    }
}