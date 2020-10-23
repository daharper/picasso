package commands

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

    override fun execute() = visit(Pixel(x, y))

    private fun visit(pixel: Pixel) {
        val target = pixel.getPen()

        pixel drawWith pen

        if (pixel upIs target) {
            visit(pixel.up())
        }

        if (pixel leftIs target) {
            visit(pixel.left())
        }

        if (pixel rightIs target) {
            visit(pixel.right())
        }

        if (pixel downIs target) {
            visit(pixel.down())
        }
    }
}