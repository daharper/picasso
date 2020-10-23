package commands

import core.Canvas
import core.Input
import core.Pixel

class TriangleCommand(input: Input) : Command(input) {

    private var pen = 'x'

    private var x1 = 0
    private var x2 = 0
    private var y1 = 0
    private var y2 = 0
    private var x3 = 0
    private var y3 = 0

    init {
        requireMin(6, "Invalid command, try: T 1 1 1 10 5 5")

        x1 = getX(0)
        y1 = getY(1)
        x2 = getX(2)
        y2 = getY(3)
        x3 = getX(4)
        y3 = getY(5)

        if (argCount() == 7) {
            pen = getPen(6)
        }
    }

    override fun execute() {
        Canvas.drawDiagonalLine(Pixel(x1, y1), Pixel(x2, y2), pen)
        Canvas.drawDiagonalLine(Pixel(x2, y2), Pixel(x3, y3), pen)
        Canvas.drawDiagonalLine(Pixel(x3, y3), Pixel(x1, y1), pen)
    }
}