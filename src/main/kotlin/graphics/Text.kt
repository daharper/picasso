package graphics

object Text {

    fun draw(start: Pixel, text: String) {
        var i = start.x

        for (c in text) {
            if (i > Canvas.getWidth()) break
            Canvas.drawPixel(i++, start.y, c)
        }
    }
}