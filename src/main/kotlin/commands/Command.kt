package commands

import editor.Editor

abstract class Command {

    lateinit var editor: Editor
    private lateinit var backup : String

    constructor(editor: Editor){
        this.editor = editor
    }

    fun backup(){
        backup = editor.textField.getText()
    }

    fun undo(){
        editor.textField.setText(backup)
    }

    abstract fun execute() : Boolean
}