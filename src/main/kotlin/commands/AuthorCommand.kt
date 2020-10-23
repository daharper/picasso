package commands

import core.CommandManager
import core.Input

class AuthorCommand(input: Input) : Command(input, false) {

    override fun execute() {
        val commands = listOf(
                "C 40 13",
                "W 1 1 David Harper",
                "W 1 2 Developer",
                "L 1 3 14 3 _",
                "L 14 1 14 3 |",
                "T 32 1 27 4 37 4",
                "P 29 5 |",
                "P 29 6 |",
                "P 35 5 |",
                "P 35 6 |",
                "P 31 5 O",
                "P 33 5 O",
                "P 32 6 -",
                "b 32 2 x",
                "L 26 7 38 7",
                "L 31 7 28 9",
                "L 33 7 36 9",
                "W 1 6 + Eligible to work",
                "W 1 7 + Available now",
                "W 1 8 + Locally based",
                "L 1 11 40 11 _",
                "W 1 12 email: david@beyondvelocity.com.au",
                "W 1 13 blog:  https://beyondvelocity.blog",
        )

        CommandManager.replay(commands)
    }
}