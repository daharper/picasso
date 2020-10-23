package commands

import core.Canvas
import core.Input
import core.Pixel

class LineCommand(input: Input) : Command(input) {

    private var pen = 'x'

    private var x1 = 0
    private var x2 = 0
    private var y1 = 0
    private var y2 = 0

    init {
        input.requireMin(4, "Invalid command, try: L 1 2 6 2")

        x1 = getX(0)
        y1 = getY(1)
        x2 = getX(2)
        y2 = getY(3)

        if (argCount() == 5) {
            pen = getPen(4)
        }
    }

    override fun execute() {
        when {
            x1 == x2 -> drawVerticalLine()
            y1 == y2 -> drawHorizontalLine()
            else -> drawDiagonalLine()
        }
    }

    private fun drawHorizontalLine() {
        Canvas.drawHorizontalLine(Pixel(x1, y1), Pixel(x2, y2), pen)
    }

    private fun drawVerticalLine() {
        Canvas.drawVerticalLine(Pixel(x1, y1), Pixel(x2, y2), pen)
    }

    private fun drawDiagonalLine() {
        Canvas.drawDiagonalLine(Pixel(x1, y1), Pixel(x2, y2), pen)
    }
}