import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotGUI extends JFrame implements ActionListener {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private Chatbot chatbot;

    public ChatbotGUI() {
        // Set up the JFrame (main window)
        setTitle("Simple AI Chatbot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        // Initialize the Chatbot logic
        chatbot = new Chatbot();

        // --- GUI Components ---
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        inputField = new JTextField();
        inputField.addActionListener(this);

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        // --- Layout Management ---
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(5, 5));
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Display initial message from the bot
        appendMessage("Chatbot: Hello! I'm a simple bot. Ask me anything!", false);

        setVisible(true);
    }

    /**
     * Appends a message to the chat area.
     */
    private void appendMessage(String message, boolean isUser) {
        String prefix = isUser ? "You: " : "Chatbot: ";
        chatArea.append(prefix + message + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    /**
     * Handles actions from the input field (Enter key) and send button (click).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton || e.getSource() == inputField) {
            String userMessage = inputField.getText().trim();
            if (!userMessage.isEmpty()) {
                appendMessage(userMessage, true);
                inputField.setText("");

                String botResponse = chatbot.getResponse(userMessage);
                appendMessage(botResponse, false);
            }
        }
    }
}