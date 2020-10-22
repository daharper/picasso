package commands

import core.Canvas
import core.Input

class RectangleCommand(input: Input) : Command(input) {

    private val pen = 'x'

    private var x1 = 0;
    private var x2 = 0;
    private var y1 = 0;
    private var y2 = 0;

    init {
        require(4, "Invalid command, try: R 1 1 10 10")

        x1 = getX(0)
        y1 = getY(1)
        x2 = getX(2)
        y2 = getY(3)

        if (y1 > y2) {
            y1 = y2.also {y2 = y1}
        }

        if (x1 > x2) {
            x1 = x2.also {x2 = x1}
        }
    }

    override fun execute() {
        Canvas.drawHorizontalLine(x1, x2, y1, pen)
        Canvas.drawHorizontalLine(x1, x2, y2, pen)
        Canvas.drawVerticalLine(y1, y2, x1, pen)
        Canvas.drawVerticalLine(y1, y2, x2, pen)
    }
}