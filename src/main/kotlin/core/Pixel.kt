package core

data class Pixel(val x: Int, val y:Int) {

    private fun isSame(pen: Char) = getPen() == pen

    fun getPen() = Canvas.getPen(x, y)
    fun setPen(pen: Char): Unit = Canvas.setPen(x, y, pen)

    fun isLeft(pen: Char) = !Canvas.isLeft(x) && left().isSame(pen)
    fun isRight(pen: Char) = !Canvas.isRight(x) && right().isSame(pen)
    fun isUp(pen: Char) = !Canvas.isTop(y) && up().isSame(pen)
    fun isDown(pen: Char) = !Canvas.isBottom(y) && down().isSame(pen)

    fun left() = Pixel(x - 1, y)
    fun right() = Pixel(x + 1, y)
    fun up() = Pixel(x, y - 1)
    fun down() = Pixel(x, y + 1)
}