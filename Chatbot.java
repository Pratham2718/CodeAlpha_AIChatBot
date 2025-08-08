import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Chatbot {

    // A map to store predefined rules (keywords to responses)
    private Map<String, String> responses;
    private Random random;

    // Default fallback response when no match is found
    private final String[] DEFAULT_RESPONSES = {
            "I'm sorry, I don't understand that. Can you please rephrase?",
            "I'm not sure I follow. Could you try asking in a different way?",
            "That's a bit beyond my current knowledge. Try asking something else!",
            "Hmm, I can't find an answer for that. Maybe we can talk about something else?"
    };

    public Chatbot() {
        random = new Random();
        responses = new HashMap<>();
        populateResponses();
    }

    /**
     * Populates the chatbot's knowledge base with predefined questions and answers.
     */
    private void populateResponses() {
        // Greetings and farewells
        responses.put("hello", "Hi there! How can I help you today?");
        responses.put("hi", "Hello! What can I do for you?");
        responses.put("hey", "Hey! How's it going?");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("thank you", "You're welcome!");
        responses.put("thanks", "No problem!");

        // Common questions
        responses.put("how are you", "I'm a bot, so I don't have feelings, but I'm ready to assist you!");
        responses.put("your name", "I am a simple chatbot created to help you.");
        responses.put("what can you do", "I can answer some basic questions and have a simple conversation.");
        responses.put("help", "I can provide information on various topics. Just ask!");

        // Fun and random questions
        responses.put("joke", "Why don't scientists trust atoms? Because they make up everything!");
        responses.put("weather", "I can't check the weather, but I can tell you it's always sunny in here!");
        responses.put("age", "I don't have an age, I was just created recently.");
        responses.put("favorite color", "As a chatbot, I don't have a favorite color, but I do like the color of binary code!");
        responses.put("food", "I don't eat, but I do process a lot of data! Yum!");

        // Internship-specific FAQs
        responses.put("office hours", "Our office hours are Monday to Friday, 9 AM to 5 PM.");
        responses.put("contact number", "You can reach us at +91 8052293611.");
        responses.put("email", "Our email address is services@codealpha.tech.");
        responses.put("website", "Our website is www.codealpha.tech.");
        responses.put("internship details", "Please refer to the internship document for detailed information.");
        responses.put("submission form", "The submission form will be shared in your WhatsApp group.");
    }

    /**
     * Processes the user's input and generates a response based on keywords.
     *
     * @param userInput The text input from the user.
     * @return The chatbot's response.
     */
    public String getResponse(String userInput) {
        String processedInput = userInput.toLowerCase();

        // Simple keyword matching
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            if (processedInput.contains(entry.getKey())) {
                return entry.getValue(); // Return the predefined response
            }
        }

        // If no keyword is matched, return a random default response
        return DEFAULT_RESPONSES[random.nextInt(DEFAULT_RESPONSES.length)];
    }
}