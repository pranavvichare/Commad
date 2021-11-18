package commands

import editor.Editor

class CutCommand : Command {

    constructor(editor : Editor) : super(editor) {
        super.editor
    }

    override fun execute(): Boolean {
        if (editor.textField.getSelectedText().isEmpty()) return false

        backup()
        var source : String = editor.textField.getText()
        editor.clipboard = editor.textField.getSelectedText()
        editor.textField.setText(cutString(source))
        return true
    }

    private fun cutString(source : String) : String{
        var start : String = source.substring(0 , editor.textField.getSelectionStart())
        var end : String = source.substring(editor.textField.getSelectionEnd())
        return start + end
    }
}