package core

data class Pixel(val x: Int, val y:Int) {

    private fun isSame(pen: Char) = getPen() == pen

    fun getPen() = Canvas.getPen(x, y)

    fun setPen(pen: Char) = Canvas.setPen(x, y, pen)

    fun isLeft(pen: Char): Boolean {
        return x != 1 && left().isSame(pen)
    }

    fun isRight(pen: Char): Boolean {
        return x != Canvas.getWidth() && right().isSame(pen)
    }

    fun isUp(pen: Char): Boolean {
        return y != 1 && up().isSame(pen)
    }

    fun isDown(pen: Char): Boolean {
        return y != Canvas.getHeight() && down().isSame(pen)
    }

    fun left() = Pixel(x - 1, y)

    fun right() = Pixel(x + 1, y)

    fun up() = Pixel(x, y - 1)

    fun down() = Pixel(x, y + 1)
}