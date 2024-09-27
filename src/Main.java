public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String parentheses){
        int count = 0;

        for (int i = 0; i < parentheses.length(); i++ ) {
            char c = parentheses.charAt(i);
            if (c == '('){
                count++;
            } else if (c == ')'){
                count--;
            }
            if (count < 0){
                return false;
            } else if (count > 0){
                return false;
            }
        }

        return true;
    }

    // 2. reverseInteger

    public static String reverseInteger(int number) {
        String strNumber = Integer.toString(number);

        boolean isNegative = strNumber.charAt(0) == '-';

        StringBuilder reversed = new StringBuilder();
        if (isNegative) {
            reversed.append('-');
            strNumber = strNumber.substring(1);
        }

        for (int i = strNumber.length() - 1; i >= 0; i--) {
            reversed.append(strNumber.charAt(i));
        }

        return reversed.toString();
    }
    // 3. encryptThis
    public static String encryptThis(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        String[] words = message.split(" ");

        for (String word : words) {
            if (word.length() > 1) {
                char[] chars = word.toCharArray();
                char temp = chars[1];
                chars[1] = chars[chars.length - 1];
                chars[chars.length - 1] = temp;

                String encryptedWord = (int) chars[0] + new String(chars, 1, chars.length - 1);
                encryptedMessage.append(encryptedWord).append(" ");
            } else if (word.length() == 1) {
                encryptedMessage.append((int) word.charAt(0)).append(" ");
            } else {
                encryptedMessage.append(" ");
            }
        }

        return encryptedMessage.toString().trim();
    }
    // 4. decipherThis
    public static String decipherThis(String message) {
        StringBuilder decipheredMessage = new StringBuilder();
        String[] words = message.split(" ");

        for (String word : words) {
            if (word.isEmpty()) {
                decipheredMessage.append(" ");
                continue;
            }

            // Get the first letter and replace it with its character code
            char firstLetter = word.charAt(0);
            StringBuilder decodedWord = new StringBuilder(String.valueOf((int) firstLetter));

            // Handle the second and last letters
            if (word.length() > 1) {
                char secondLetter = word.charAt(1);
                char lastLetter = word.charAt(word.length() - 1);

                // Append the second letter
                decodedWord.append(secondLetter);

                // Append the middle part of the word (if any)
                if (word.length() > 2) {
                    decodedWord.append(word, 2, word.length() - 1);
                }

                // Append the last letter
                decodedWord.append(lastLetter);
            }

            // Replace the last letter with the second letter
            if (word.length() > 1) {
                decodedWord.setCharAt(decodedWord.length() - 1, word.charAt(1));
            }

            decipheredMessage.append(decodedWord).append(" ");
        }

        // Remove the trailing space
        return decipheredMessage.toString().trim();
    }


}