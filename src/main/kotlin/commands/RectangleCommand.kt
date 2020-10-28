package commands

import core.Input
import graphics.Pixel
import graphics.Line
import graphics.Rectangle

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
    }

    override fun execute() {
        Rectangle.draw(Pixel(x1, y1), Pixel(x2, y2), pen)
    }
}