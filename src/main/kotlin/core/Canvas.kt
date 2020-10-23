package core

import kotlin.math.abs

object Canvas {

    const val minWidth = 4
    const val maxWidth = 40
    const val minHeight = 4
    const val maxHeight = 40

    private var width: Int = 0
    private var height: Int = 0
    private var data: CharArray = CharArray(0)

    fun initialize(width: Int, height: Int) {
        this.height = height
        this.width = width
        this.data = "".padEnd(height * width).toCharArray()
    }

    fun getWidth() = width

    fun getHeight() = height

    fun getPen(x: Int, y: Int) = data[getIndex(x, y)]

    fun drawPixel(x: Int, y: Int, pen: Char) {
        data[getIndex(x, y)] = pen
    }

    fun drawText(x: Int, y: Int, text: String) {
        var i = x

        for (c in text) {
            if (i > width) break
            drawPixel(i++, y, c)
        }
    }

    fun drawHorizontalLine(start: Pixel, end: Pixel, pen: Char) {
        var x1 = start.x
        var x2 = end.x

        if (x2 <= x1) {
            x1 = x2.also { x2 = x1 }
        }

        for (x in x1..x2) {
            drawPixel(x, start.y, pen)
        }
    }

    fun drawVerticalLine(start: Pixel, end: Pixel, pen: Char) {
        var y1 = start.y
        var y2 = end.y

        if (y2 < y1) {
            y2 = y1.also { y1 = y2 }
        }

        for (y in y1..y2) {
            drawPixel(start.x, y, pen)
        }
    }

    fun drawDiagonalLine(start: Pixel, end:Pixel, pen: Char) {
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
                drawPixel(x, y++, pen)

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
            drawPixel(x, y, pen)

            x += xOffset

            if (i % step == 0 && y < y2) {
                ++y
            }
        }
    }

    private fun getIndex(x: Int, y: Int): Int {
        return (y - 1) * width + x - 1
    }
}