package graphics

object Fill {

    var pen: Char = 'o'

    fun execute(start: Pixel, pen: Char) {
        this.pen = pen
        visit(start)
    }

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