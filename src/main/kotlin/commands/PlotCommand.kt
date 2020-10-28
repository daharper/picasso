package commands

import graphics.Canvas
import core.Input
import graphics.Pixel

class PlotCommand(input: Input) : Command(input) {

    private var x1 = 0
    private var y1 = 0
    private var pen = ' '

    init {
        input.require(3, "Invalid command, try: P 1 2 x")

        x1 = getX(0)
        y1 = getY(1)

        pen = getPen(2)
    }

    override fun execute() {
        Pixel(x1, y1) drawWith pen
    }
}