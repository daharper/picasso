package core

object InputProcessor {

    fun readInput(): Input {
        var text = ""

        while (text.isBlank()) {
            print("enter command: ")
            text = readLine() ?: continue
        }

        return Input.create(text)
    }
}