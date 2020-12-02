package Work_4;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChatFrame extends JFrame implements ActionListener {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JTextArea mess = new JTextArea();
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    public ChatFrame() {
        setTitle("Chat");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mess.setEditable(false);
        mess.setLineWrap(true);
        btnSend.addActionListener(this);
        tfMessage.addActionListener(this);

        JPanel panelBot = new JPanel(new BorderLayout());
        panelBot.add(tfMessage, BorderLayout.CENTER);
        panelBot.add(btnSend, BorderLayout.EAST);
        JScrollPane scrollLog = new JScrollPane(mess);
        add(scrollLog, BorderLayout.CENTER);
        JPanel panelTop = new JPanel(new GridLayout(2, 3));
        add(panelTop, BorderLayout.NORTH);
        add(panelBot, BorderLayout.EAST);
        add(tfMessage, BorderLayout.SOUTH);
        add(btnSend, BorderLayout.EAST);

        JMenu menu = new JMenu("Menu");
        JMenuItem itm = new JMenuItem("on program");
        menu.add(itm);
        itm.addActionListener(this);

        itm = new JMenuItem("Close");
        itm.addActionListener(e -> System.exit(0));
        menu.add(itm);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if (src == btnSend || src == tfMessage) {
            postMessage();
        }
    }

    private void postMessage() {
        var msg = tfMessage.getText();
        if ("".equals(msg)) return;
        tfMessage.setText(null);
        tfMessage.requestFocusInWindow();
        putLog(msg);
    }

    private void putLog(String msg) {
        if ("".equals(msg)) return;
        SwingUtilities.invokeLater(() -> {
            mess.append(msg + "\n");
            mess.setCaretPosition(mess.getDocument().getLength());
        });
    }
}



