package commands

import core.Canvas
import core.Input
import core.Pixel

class FillCommand(input: Input) : Command(input) {

    private var x = 0
    private var y = 0
    private var pen = 'c'

    init {
        input.require(3, "Invalid command, try: B 3 1 o")

        x = getX(0)
        y = getY(1)

        pen = getPen(2)
    }

    override fun execute() {
        val pixel = Canvas.getPixel(x, y)
        visit(pixel)
    }

    private fun visit(pixel: Pixel) {
        val target = pixel.getPen()

        pixel.setPen(pen)

        if (pixel.isUp(target)) {
            visit(pixel.up())
        }

        if (pixel.isLeft(target)) {
            visit(pixel.left())
        }

        if (pixel.isRight(target)) {
            visit(pixel.right())
        }

        if (pixel.isDown(target)) {
            visit(pixel.down())
        }
    }
}