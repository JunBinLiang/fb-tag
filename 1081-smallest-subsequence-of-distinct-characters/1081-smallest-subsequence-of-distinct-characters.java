class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26]; // Assuming only lowercase English letters

        // Populate the last occurrence index for each character in the string
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Skip characters that are already in the result
            if (used[currentChar - 'a']) {
                continue;
            }

            // Pop characters from the stack if the current character is smaller and has a later occurrence
            while (!stack.isEmpty() && currentChar < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                used[stack.pop() - 'a'] = false;
            }

            stack.push(currentChar);
            used[currentChar - 'a'] = true;
        }

        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}