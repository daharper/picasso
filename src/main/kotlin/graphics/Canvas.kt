package graphics

/**
 * This canvas is acted upon by other graphics primitives. The canvas is manipulated
 * using x,y co-ordinates beginning at (1,1) and ending at (width, height)
 */
object Canvas {

    const val minWidth = 4
    const val maxWidth = 40
    const val minHeight = 4
    const val maxHeight = 40

    private var width: Int = 0
    private var height: Int = 0

    // using flat memory for internal storage
    private var data: CharArray = CharArray(0)

    // maps the user based co-ordinates (1,1) to flat memory (0..n)
    private fun getIndex(x: Int, y: Int): Int {
        return (y - 1) * width + x - 1
    }

    fun initialize(width: Int, height: Int) {
        Canvas.height = height
        Canvas.width = width
        data = "".padEnd(height * width).toCharArray()
    }

    fun getWidth() = width
    fun getHeight() = height

    fun getPen(x: Int, y: Int) = data[getIndex(x, y)]

    fun drawPixel(x: Int, y: Int, pen: Char) {
        data[getIndex(x, y)] = pen
    }
}