package commands

import core.Input
import graphics.Fill
import graphics.Pixel

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

    override fun execute() = Fill.execute(Pixel(x, y), pen)
}