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
			// Final Round, special case. 
            if(roundNumber > 8)
            {
				// If the last 2 throws are either a spare or strikes,
				// then add the bonus throw. 
				int tmp = getVal(i)+getVal(i+1);
				if(tmp > 9)
				{
					score += tmp + getVal(i+2);
				}
				else 
				{
					score += tmp;
				}
                break;
            }
            //char c = this.gameData[i];
            switch (this.gameData[i])
            {
                case ' ':
                    roundNumber++;
                    continue;
                case '/':
					score += getVal(i) + getVal(i +2);
					break;
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
                    }while(lookForward > 0 );
                    break;
                default:
                score += getVal(i);
            }
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
    {//									1  2  3  4  5  6  7  8  9 10
		LineClass test = new LineClass("11 11 11 11 x 22 22 22 22 xxx"); 
		//"1/ 2- x 32 9- x 32 21" "1/ 18 x 11 1- 32 32 32 32 32-"
        System.out.println(test.getScore());
    }

}
