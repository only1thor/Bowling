public class Bowling(void)
{
    //have some valid sequences here. 
    String lineOfScores = "X X X X X X X X X X X X";

    //TODO: write more tests cases.

    //create a "line" object here
    LineClass gameObject = new LineClass(lineOfScores);

    //output the scores. 
    System.out.println("Score is:" + gameObject.score());

    //TODO: load, and test more test cases.
}
