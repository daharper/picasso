package graphics

import kotlin.math.abs

object Line {

    fun draw(start: Pixel, end: Pixel, pen: Char) {
        when {
            start.x == end.x -> drawVerticalLine(start, end, pen)
            start.y == end.y -> drawHorizontalLine(start, end, pen)
            else -> drawDiagonalLine(start, end, pen)
        }
    }

    fun drawHorizontalLine(start: Pixel, end: Pixel, pen: Char) {
        var x1 = start.x
        var x2 = end.x

        if (x2 <= x1) {
            x1 = x2.also { x2 = x1 }
        }

        for (x in x1..x2) {
            Canvas.drawPixel(x, start.y, pen)
        }
    }

    fun drawVerticalLine(start: Pixel, end: Pixel, pen: Char) {
        var y1 = start.y
        var y2 = end.y

        if (y2 < y1) {
            y2 = y1.also { y1 = y2 }
        }

        for (y in y1..y2) {
            Canvas.drawPixel(start.x, y, pen)
        }
    }

    fun drawDiagonalLine(start: Pixel, end: Pixel, pen: Char) {
        var x1 = start.x
        var y1 = start.y
        var x2 = end.x
        var y2 = end.y

        if (y1 >= y2) {
            y2 = y1.also { y1 = y2 }
            x2 = x1.also { x1 = x2 }
        }

        val yPixelCount = y2 - y1 + 1
        val xPixelCount = abs(x2 - x1) + 1

        val xOffset = if (x2 > x1) 1 else -1

        var x = x1
        var y = y1

        // if the line is more vertical, we'll draw by enumerating all the Y points
        if (yPixelCount >= xPixelCount) {

            val step = yPixelCount / xPixelCount

            for (i in 1..yPixelCount) {
                Canvas.drawPixel(x, y++, pen)

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
        val step = xPixelCount / yPixelCount

        for (i in 1..xPixelCount) {
            Canvas.drawPixel(x, y, pen)

            x += xOffset

            if (i % step == 0 && y < y2) {
                ++y
            }
        }
    }
}