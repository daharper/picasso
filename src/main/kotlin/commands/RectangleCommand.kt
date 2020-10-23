package commands

import core.Canvas
import core.Input
import core.Pixel

class RectangleCommand(input: Input) : Command(input) {

    private var pen = 'x'

    private var x1 = 0
    private var x2 = 0
    private var y1 = 0
    private var y2 = 0

    init {
        requireMin(4, "Invalid command, try: R 1 1 10 10")

        x1 = getX(0)
        y1 = getY(1)
        x2 = getX(2)
        y2 = getY(3)

        if (argCount() == 5) {
            pen = getPen(4)
        }

        if (y1 > y2) {
            y1 = y2.also {y2 = y1}
        }

        if (x1 > x2) {
            x1 = x2.also {x2 = x1}
        }
    }

    override fun execute() {
        Canvas.drawHorizontalLine(Pixel(x1, y1), Pixel(x2, y1), pen)
        Canvas.drawHorizontalLine(Pixel(x1, y2), Pixel(x2, y2), pen)
        Canvas.drawVerticalLine(Pixel(x1, y1), Pixel(x1, y2), pen)
        Canvas.drawVerticalLine(Pixel(x2, y1), Pixel(x2, y2), pen)
    }
}