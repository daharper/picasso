package core

data class Input(val command: String = "", val args: List<String> = listOf()) {

    fun require(count: Int, error: String) {
        if (args.size != count) {
            throw Exception(error)
        }
    }

    fun getInt(index: Int) = args[index].toIntOrNull() ?: 0

    fun getChar(index: Int) = args[index][0]

    override fun toString(): String = (command + " " + args.joinToString { it }).trimEnd()
}