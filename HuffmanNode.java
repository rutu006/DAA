import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.*;
class HuffmanNode {
    int frequency;
    char character;
    HuffmanNode left;
    HuffmanNode right;
}

// Custom comparator for HuffmanNode
class HuffmanNodeComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;
    }
}

public class Huffman {
    // Function to print Huffman codes
    public static void printCodes(HuffmanNode root, String code) {
        if (root.left == null && root.right == null && Character.isLetter(root.character)) {
            System.out.println(root.character + " | " + code);
            return;
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Function to print the Huffman tree structure
    public static void printTree(HuffmanNode root, String indent, String branch) {
        if (root != null) {
            System.out.print(indent + branch);
            System.out.println(root.character);
            printTree(root.left, indent + "| ", "|-");
            printTree(root.right, indent +"  ", "|_");
        }
    }

    
    public static void main(String[] args) {
//        int n = 4;
//        char[] characters = { 'A', 'B', 'C', 'D' };
//        int[] frequencies = { 5, 1, 6, 3 };
        
        String inputString = "ABRACADABRA";
        
        // Count character frequencies
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {//imp not reminding
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        int n = frequencyMap.size();
        char[] characters = new char[n];
        int[] frequencies = new int[n];
        
        int index = 0;
        for (char c : frequencyMap.keySet()) {//.keySet()
            characters[index] = c;
            frequencies[index] = frequencyMap.get(c);
            index++;
        }

        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>(n, new HuffmanNodeComparator());//new HuffmanNodeComparator()

        for (int i = 0; i < n; i++) {
            HuffmanNode node = new HuffmanNode();
            node.character = characters[i];
            node.frequency = frequencies[i];
            node.left = null;
            node.right = null;
            minHeap.add(node);
        }

        HuffmanNode root = null;

        while (minHeap.size() > 1) {
            HuffmanNode x = minHeap.poll();
            HuffmanNode y = minHeap.poll();
            HuffmanNode f = new HuffmanNode();
            f.frequency = x.frequency + y.frequency;
            f.character = '-';//single quote for character
            f.left = x;
            f.right = y;
            root = f;
            minHeap.add(f);
        }

        System.out.println("Huffman Tree Structure:");
        printTree(root, "", "");

        System.out.println("\nCharacter | Huffman Code");
        System.out.println("-------------------------");
        printCodes(root, "");
        
        
     // Calculate Huffman codes (you should have this part in your code)
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        // Generate Huffman codes and store them in the huffmanCodes map

          }
}
