package commands

import core.Canvas
import core.Input
import kotlin.math.abs

class LineCommand(input: Input) : Command(input) {

    private val pen = 'x'

    private var x1 = 0;
    private var x2 = 0;
    private var y1 = 0;
    private var y2 = 0;

    init {
        input.require(4, "Invalid command, try: L 1 2 6 2")

        x1 = getX(0)
        y1 = getY(1)
        x2 = getX(2)
        y2 = getY(3)
    }

    override fun execute() {
        if (x1 == x2) {
            drawVerticalLine()
        } else if (y1 == y2) {
            drawHorizontalLine()
        } else {
            drawDiagonalLine()
        }
    }

    private fun drawHorizontalLine() {
        if (x2 <= x1) {
            x1 = x2.also { x2 = x1 }
        }
        Canvas.drawHorizontalLine(x1, x2, y1, pen)
    }

    private fun drawVerticalLine() {
        if (y2 < y1) {
            y2 = y1.also { y1 = y2 }
        }
        Canvas.drawVerticalLine(y1, y2, x1, pen)
    }

    private fun drawDiagonalLine() {
        if (y1 >= y2) {
            y2 = y1.also { y1 = y2 }
            x2 = x1.also { x1 = x2 }
        }

        val yPixelCount = y2 - y1 + 1
        val xPixelCount = abs(x2 - x1) + 1

        val xOffset = if (x2 > x1) 1 else -1

        var x = x1;
        var y = y1;

        // if the line is more vertical, we'll draw by enumerating all the Y points
        if (yPixelCount >= xPixelCount) {
            println ("vertical")

            val step = yPixelCount / xPixelCount
            println(step)

            for (i in 1..yPixelCount) {
                Canvas.setPen(x, y++, pen)

                if (i % step == 0) {
                    if ((xOffset == -1 && x > x2) || (xOffset == 1 && x < x2)) {
                        x += xOffset
                    }
                }
            }
            // ok, we're done here
            return
        }

        // line is more horizontal, we'll draw by enumerating all the X points
        val step = xPixelCount / yPixelCount;

        for (i in 1..xPixelCount) {
            Canvas.setPen(x, y, pen)

            x += xOffset;

            if (i % step == 0 && y < y2) {
                ++y;
            }
        }
    }
}