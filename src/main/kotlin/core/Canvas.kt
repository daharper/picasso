package core

object Canvas {

    const val minWidth = 4
    const val maxWidth = 40
    const val minHeight = 4
    const val maxHeight = 40

    private var width: Int = 0
    private var height: Int = 0
    private var data: CharArray = CharArray(0)

    init {
        initialize(10, 10)
    }

    fun initialize(width: Int, height: Int) {
        this.height = height
        this.width = width

        data = "".padEnd(height * width).toCharArray()
    }

    fun isEmpty() = data.isEmpty()

    fun getWidth() = width

    fun getHeight() = height

    fun getPixel(x: Int, y: Int) = Pixel(x, y)

    fun getPen(x: Int, y: Int) = data[getIndex(x, y)]

    fun setPen(x: Int, y: Int, pen: Char) {
        data[getIndex(x, y)] = pen
    }

    fun drawHorizontalLine(x1: Int, x2: Int, y: Int, pen: Char) {
        for (x in x1..x2) {
            setPen(x, y, pen)
        }
    }

    fun drawVerticalLine(y1: Int, y2: Int, x: Int, pen: Char) {
        for (y in y1..y2) {
            setPen(x, y, pen)
        }
    }

    private fun getIndex(x: Int, y: Int): Int {
        return (y - 1) * width + x - 1
    }
}