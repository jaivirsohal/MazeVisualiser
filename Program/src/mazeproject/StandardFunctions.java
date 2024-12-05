package mazeproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StandardFunctions {

    public String[] loadDetails(String fileName) throws IOException {
        try {
            //initialise variables
            String line;
            int lineNum = 0;

            //get line num
            try ( //load file and read the content for getting line number
                    BufferedReader numReader = new BufferedReader(
                            new FileReader(fileName))) {
                //get line num
                while (numReader.readLine() != null) {
                    lineNum++;
                }
                //close num reader
                numReader.close();
            }

            //declare details array with line num and intialse temp index
            String[] details = new String[lineNum];
            int index = 0;

            //iterate through file and access content
            try ( //load file and read the content for array writing
                    BufferedReader br = new BufferedReader(
                            new FileReader(fileName))) {
                //iterate through file and access content
                while ((line = br.readLine()) != null) {
                    //stop if empty
                    if (line.isEmpty()) {
                        break;
                    }
                    //add data to array
                    details[index] = line;
                    index += 1;
                }
                //close reader
            }
            //return array
            return details;
        } catch (FileNotFoundException e) {
            //if no file, there are no details
            String[] blankArr = {" , "};
            return blankArr;
        }
    }

    public void writeToFile(String string, String fileName)
            throws FileNotFoundException, IOException {
        //write to file and then close the file
        try ( //open file to write to
                BufferedWriter writer = new BufferedWriter(new FileWriter(
                        fileName, true))) {
            //write to file and then close the file
            writer.write(string + "\n");
        }
    }
    
    public int[] reverseArr(int[] arr) {
        //create new array to reverse
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - i - 1];
        }
        //deep copy reversed array
        arr = Arrays.copyOf(reversedArr,reversedArr.length);
        return arr;
    }
}