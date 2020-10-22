package core

object InputProcessor {

    fun readInput(): Input {
        var text = ""

        while (text.isBlank()) {
            print("enter command: ")
            text = readLine() ?: continue
        }

        val tokens = text.trim().split(" ")
        val command = tokens[0].toUpperCase()

        return if (tokens.size == 1)
                    Input(command)
               else
                    Input(command, tokens.slice(1 until tokens.size))
    }
}