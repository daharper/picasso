package commands

import core.Canvas
import core.Input

abstract class Command(val input: Input) {

    fun require(count: Int, error: String) = input.require(count, error)

    fun requireMin(count: Int, error: String) = input.requireMin(count, error)

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

    fun getText(index: Int) = input.getText(index)

    abstract fun execute()
}


