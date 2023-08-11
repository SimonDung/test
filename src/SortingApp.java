import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class SortingApp extends JFrame {
    private JTextArea outputTextArea;

    public SortingApp() {
        setTitle("Sorting Application");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton generateButton = new JButton("Generate and Sort");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateAndSort();
            }
        });
        mainPanel.add(generateButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void generateAndSort() {
        List<String> randomStrings = new ArrayList<>();
        Random random = new Random();
        long startTime;
        long endTime;

        for (int i = 0; i < 1000; i++) {
            int length = random.nextInt(5) + 1;
            StringBuilder randomString = new StringBuilder();
            for (int j = 0; j < length; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a');
                if (random.nextBoolean()) {
                    randomChar = Character.toUpperCase(randomChar);
                }
                randomString.append(randomChar);
            }
            randomStrings.add(randomString.toString());
        }

        outputTextArea.setText("Random Strings:\n" + randomStrings.toString() + "\n\n");

        // Sort the list using different sorting algorithms
        List<String> sortedStrings = new ArrayList<>(randomStrings);
        startTime = System.currentTimeMillis();
        Collections.sort(sortedStrings); // Java's built-in sorting (MergeSort)
        endTime = System.currentTimeMillis();
        outputTextArea.append("Sorted using Java's built-in sorting:\n" + sortedStrings.toString() + "\n");
        outputTextArea.append("Time taken:" + (endTime - startTime) + " milliseconds\n\n");

        List<String> bubbleSorted = new ArrayList<>(randomStrings);
        startTime = System.currentTimeMillis();
        SortingAlgo.bubbleSort(bubbleSorted); // Bubble Sort
        endTime = System.currentTimeMillis();
        outputTextArea.append("Sorted using Bubble Sort:\n" + bubbleSorted.toString() + "\n");
        outputTextArea.append("Time taken:" + (endTime - startTime) + " milliseconds\n\n");

        List<String> selectionSorted = new ArrayList<>(randomStrings);
        startTime = System.currentTimeMillis();
        SortingAlgo.selectionSort(selectionSorted); // Selection Sort
        endTime = System.currentTimeMillis();
        outputTextArea.append("Sorted using Selection Sort:\n" + selectionSorted.toString() + "\n");
        outputTextArea.append("Time taken:" + (endTime - startTime) + " milliseconds\n\n");

        List<String> insertionSorted = new ArrayList<>(randomStrings);
        startTime = System.currentTimeMillis();
        SortingAlgo.insertionSort(insertionSorted); // Insertion Sort
        endTime = System.currentTimeMillis();
        outputTextArea.append("Sorted using Insertion Sort:\n" + insertionSorted.toString() + "\n");
        outputTextArea.append("Time taken:" + (endTime - startTime) + " milliseconds\n\n");

        List<String> quickSorted = new ArrayList<>(randomStrings);
        startTime = System.currentTimeMillis();
        SortingAlgo.quickSort(quickSorted, 0, quickSorted.size() - 1); // Quick Sort
        endTime = System.currentTimeMillis();
        outputTextArea.append("Sorted using Quick Sort:\n" + quickSorted.toString() + "\n");
        outputTextArea.append("Time taken:" + (endTime - startTime) + " milliseconds\n\n");
    }
}
