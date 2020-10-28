package commands

import graphics.Canvas
import core.Input

/**
 * Base class for all commands, provides helper methods to simplify argument
 * extraction and verification.
 *
 * If the command is storable, it will be kept in the command history - some
 * some commands like load/save/undo add no value to canvas drawing.
 *
 * All commands must implement the execute method.
 */
abstract class Command(val input: Input, val isStorable: Boolean = true) {

    fun require(count: Int, error: String) = input.require(count, error)

    fun requireMin(count: Int, error: String) = input.requireMin(count, error)

    fun argCount() = input.argCount()

    fun asInt(index: Int) = input.getInt(index)

    fun getX(index: Int): Int {
        val x = input.getInt(index)

        if (x < 1 || x > Canvas.getWidth()) {
            throw Exception("argument is out of range, must be between 1 and ${Canvas.getWidth()}")
        }

        return x
    }

    fun getY(index: Int): Int {
        val y = input.getInt(index)

        if (y < 1 || y > Canvas.getHeight()) {
            throw Exception("argument is out of range, must be between 1 and ${Canvas.getHeight()}")
        }

        return y
    }

    fun getPen(index: Int): Char {
        return input.getChar(index)
    }

    fun getString(index: Int): String {
        return input.getString(index)
    }

    fun getText(index: Int) = input.getText(index)

    override fun toString(): String = input.toString()

    abstract fun execute()
}


