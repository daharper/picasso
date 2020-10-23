package commands

import core.Canvas
import core.Input

class WriteCommand(input: Input) : Command(input) {

    private var x1 = 0
    private var y1 = 0
    private var text = ""

    init {
        requireMin(3, "Invalid command, try: W 1 1 Hello World!")

        x1 = getX(0)
        y1 = getY(1)

        text = getText(2)

        if (x1 + text.length > Canvas.maxWidth) {
            text = text.substring(-x1)
        }
    }

    override fun execute() {
        if (text.isNotEmpty()) {
            Canvas.drawText(x1, y1, text)
        }
    }
}