package commands

import editor.Editor

class CopyCommand : Command {

    constructor(editor: Editor) : super(editor) {
        super.editor
    }

    override fun execute(): Boolean {
        editor.clipboard = editor.textField.getSelectedText()
        return false
    }
}