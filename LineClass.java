public class LineClass
{
    private char[] gameData;
    private int score = 0;

    private void calculateScore()
    {
        // some math to produce a sum. 
        // score should be set here. 
        int roundNumber = 0;
        for( int i=0; i < this.gameData.length; i++ )
        {
            if(roundNumber > 30)
            {
                break;
            }
            //char c = this.gameData[i];
            switch (this.gameData[i])
            {
                case ' ':
                    roundNumber++;
                    continue;
                case '/':
                    score += getVal(i) + getVal(i +1);
                case 'x':
                    score += 10;
                    int lookForward = 2;
                    int nextIndex = 1;
                    do
                    {
                        if(gameData[i + nextIndex] == ' ')
                        {
                            ++nextIndex;
                            continue;
                        }
                        else
                        {
                            score += getVal(i + nextIndex);
                            --lookForward;
                            ++nextIndex;
                        }
                    }while(lookForward > 1 );
                    break;
                default:
                score += getVal(i);
            }
            System.out.println(score);

        }

    }

    public int getVal(int indexOfChar)
    {
        switch (gameData[indexOfChar])
        {
            //
            case 'x':
            return 10;
            case '/':
            // Find the number of pins knocked dow on the spare throw. 
            return 10 - Character.getNumericValue(gameData[indexOfChar - 1]);
            case '-':
            return 0;
            default:
            return Character.getNumericValue(gameData[ indexOfChar ]);
        }
    }

    public void loadGameData(String s)
    {
        this.gameData = s.toCharArray();
        this.calculateScore();
    }

    public int getScore()
    {
        return score;
    }

   //TODO: ad a loadData method to avoid making multiple objects for each game.

    public LineClass(String scoreString)
    {
        loadGameData(scoreString);
    }

    public static void main(String[] args)
    {
        LineClass test = new LineClass("1/ 18 x 11 1- 32 32 32 32 32-"); //"1/ 2- x 32 9- x 32 21"
        System.out.println(test.getScore());
    }

}
