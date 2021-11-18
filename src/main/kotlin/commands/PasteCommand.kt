package commands

import editor.Editor

class PasteCommand : Command {

    constructor(editor: Editor) : super(editor) {
        super.editor
    }

    override fun execute(): Boolean {
        if(editor.clipboard == null || editor.clipboard.isEmpty()) return false

        backup()
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition())
        return false
    }
}