package graphics

object Rectangle {

    fun draw(start: Pixel, end:Pixel, pen: Char) {
        var x1 = start.x
        var y1 = start.y
        var x2 = end.x
        var y2 = end.y

        if (y1 > y2) {
            y1 = y2.also {y2 = y1}
        }

        if (x1 > x2) {
            x1 = x2.also {x2 = x1}
        }

        Line.drawHorizontalLine(Pixel(x1, y1), Pixel(x2, y1), pen)
        Line.drawHorizontalLine(Pixel(x1, y2), Pixel(x2, y2), pen)
        Line.drawVerticalLine(Pixel(x1, y1), Pixel(x1, y2), pen)
        Line.drawVerticalLine(Pixel(x2, y1), Pixel(x2, y2), pen)
    }
}