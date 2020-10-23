package core

import commands.*

object CommandManager {
    private val history: MutableList<Command> = mutableListOf()

    init {
        execute(CanvasCommand.default())
    }

    fun execute(command: Command): Command {
        remember(command)
        command.execute()
        return command
    }

    fun execute(input: Input): Command {
        val command = createCommand(input)
        return execute(command)
    }

    fun getHistory(): ListIterator<Command> = history.listIterator()

    fun clear() {
        while (history.size > 1) {
            history.removeLast()
        }

        for (command in history) {
            command.execute()
        }
    }

    fun undo() {
        if (history.size > 1) {
            history.removeLast()

            for (command in history) {
                command.execute()
            }
        }
    }

    fun replay(commands: List<String>) {
        commands.forEach {
            val tokens = it.trim().split(" ")
            val command = tokens[0].toUpperCase()

            val input = if (tokens.size == 1)
                Input(command)
            else
                Input(command, tokens.slice(1 until tokens.size))

            execute(input)
        }
    }

    private fun remember(command: Command) {
        if (command.isStorable) {
            if (command is CanvasCommand) {
                history.clear()
            }
            history.add(command)
        }
    }

    private fun createCommand(input: Input) =
        when (input.command) {
            "A" -> AuthorCommand(input)
            "B" -> FillCommand(input)
            "C" -> CanvasCommand(input)
            "D" -> DemoCommand(input)
            "E" -> EraseCommand(input)
            "H" -> HistoryCommand(input)
            "L" -> LineCommand(input)
            "O" -> LoadCommand(input)
            "P" -> DotCommand(input)
            "Q" -> QuitCommand(input)
            "R" -> RectangleCommand(input)
            "S" -> SaveCommand(input)
            "T" -> TriangleCommand(input)
            "U" -> UndoCommand(input)
            "W" -> WriteCommand(input)
            "?" -> HelpCommand(input)
            else -> InvalidCommand(input)
    }
}