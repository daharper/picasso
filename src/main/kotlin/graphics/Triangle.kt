package graphics

object Triangle {

    fun draw(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, pen: Char) {
        Line.drawDiagonalLine(Pixel(x1, y1), Pixel(x2, y2), pen)
        Line.drawDiagonalLine(Pixel(x2, y2), Pixel(x3, y3), pen)
        Line.drawDiagonalLine(Pixel(x3, y3), Pixel(x1, y1), pen)
    }
}