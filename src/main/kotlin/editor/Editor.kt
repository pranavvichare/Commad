package editor

import commands.*
import java.awt.FlowLayout
import java.awt.datatransfer.Clipboard
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class Editor {

    lateinit var textField : JTextArea
    lateinit var clipboard : String
    private var history : CommandHistory = CommandHistory()

    fun init(){
        var frame : JFrame = JFrame("Text editor (type & use buttons, Luke!)")
        var content : JPanel = JPanel()
        frame.setContentPane(content)
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        content.setLayout(BoxLayout(content, BoxLayout.Y_AXIS))
        textField = JTextArea()
        textField.setLineWrap(true)
        content.add(textField)
        var buttons : JPanel = JPanel(FlowLayout(FlowLayout.CENTER))
        var ctrlC : JButton = JButton("ctrl + C")
        var ctrlX : JButton = JButton("ctrl + X")
        var ctrlV : JButton = JButton("ctrl + V")
        var ctrlZ : JButton = JButton("ctrl + Z")
        var editor : Editor = this
        ctrlC.addActionListener(ActionListener {
            fun actionPerformed(e : ActionEvent){
                executeCommand(CopyCommand(editor))
            }
        })
        ctrlX.addActionListener(ActionListener {
            fun actionPerformed(e : ActionEvent){
                executeCommand(CutCommand(editor))
            }
        })
        ctrlV.addActionListener(ActionListener {
            fun actionPerformed(e : ActionEvent){
                executeCommand(PasteCommand(editor))
            }
        })
        ctrlZ.addActionListener(ActionListener {
            fun actionPerformed(e : ActionEvent){
                undo()
            }
        })
        buttons.add(ctrlC)
        buttons.add(ctrlX)
        buttons.add(ctrlV)
        buttons.add(ctrlZ)
        content.add(buttons)
        frame.setSize(450, 200)
        frame.setLocationRelativeTo(null)
        frame.setVisible(true)
    }

    private fun executeCommand(command: Command){
        if(command.execute()){
            history.push(command)
        }
    }

    private fun undo(){
        if(history.isEmpty()) return

        var command : Command = history.pop()
        if(command != null){
            command.undo()
        }
    }
}