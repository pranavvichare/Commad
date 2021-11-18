package commands

import java.util.*

class CommandHistory {

    private var history : Stack<Command> = Stack()

    fun push(c : Command){
        history.push(c)
    }

    fun pop() : Command {
        return history.pop()
    }

    fun isEmpty() : Boolean {
        return history.isEmpty()
    }
}