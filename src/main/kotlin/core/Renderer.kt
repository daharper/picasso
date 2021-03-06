package core

import graphics.Canvas

object Renderer {

    fun execute() {
        println()
        drawHorizontalBorder(Canvas)
        println()

        for (y in 1..Canvas.getHeight()) {
            print("|")
            for (x in 1..Canvas.getWidth()) {
                print(Canvas.getPen(x, y))
            }
            println("|")
        }

        drawHorizontalBorder(Canvas)
        println()
        println()
    }

    private fun drawHorizontalBorder(canvas: Canvas) {
        val width = canvas.getWidth() + 2

        for (x in 1..width) {
            print("-")
        }
    }
}