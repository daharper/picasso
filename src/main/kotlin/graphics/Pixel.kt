package graphics

data class Pixel(val x: Int, val y:Int) {

    private fun isSame(pen: Char) = getPen() == pen

    fun getPen() = Canvas.getPen(x, y)

    infix fun drawWith(pen: Char) = Canvas.drawPixel(x, y, pen)

    infix fun leftIs(pen: Char): Boolean {
        return x != 1 && left().isSame(pen)
    }

    infix fun rightIs(pen: Char): Boolean {
        return x != Canvas.getWidth() && right().isSame(pen)
    }

    infix fun upIs(pen: Char): Boolean {
        return y != 1 && up().isSame(pen)
    }

    infix fun downIs(pen: Char): Boolean {
        return y != Canvas.getHeight() && down().isSame(pen)
    }

    fun left() = Pixel(x - 1, y)

    fun right() = Pixel(x + 1, y)

    fun up() = Pixel(x, y - 1)

    fun down() = Pixel(x, y + 1)
}