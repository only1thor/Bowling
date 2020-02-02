public class Bowling
{
    public static void main(String[] args) {
        //have some valid sequences here. 
        String lineOfScores[] = {
            "X X X X X X X X X X X X",
            "11 11 11 11 x 22 22 22 22 x x x",
            "1/ 2- x 32 9- x 32 21",
            "1/ 18 x 11 1- 32 32 32 32 32-"};

        // Create an empty "line" object here
        LineClass gameObject = new LineClass();

        // Test the cases defined in "lineOfScores".
        for(String line : lineOfScores)
        {
            // Print current line:
            System.out.println("\n" + line);
            // Load current line. 
            gameObject.loadGameData(line);
            // Output the scores. 
            System.out.println("Score is:" + gameObject.getScore());
        }
    }
}
