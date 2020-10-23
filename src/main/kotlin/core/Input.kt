package core

data class Input(val command: String = "", val args: List<String> = listOf()) {

    companion object {
        fun create(text: String): Input {
            val tokens = text.trim().split(" ")
            val command = tokens[0].toUpperCase()

            return if (tokens.size == 1)
                Input(command)
            else
                Input(command, tokens.slice(1 until tokens.size))
        }
    }

    fun require(count: Int, error: String) {
        if (args.size != count) {
            throw Exception(error)
        }
    }

    fun requireMin(count: Int, error: String) {
        if (args.size < count) {
            throw Exception(error)
        }
    }

    fun argCount() = args.size

    fun getInt(index: Int) = args[index].toIntOrNull() ?: 0

    fun getChar(index: Int) = args[index][0]

    fun getString(index: Int) = args[index]

    fun getText(index: Int) = args.subList(index, args.size).joinToString(" ") { it }.trimEnd()

    override fun toString(): String = (command + " " + args.joinToString(" ") { it }).trimEnd()
}