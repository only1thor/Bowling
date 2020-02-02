public class LineClass
{
    private char[] gameData;
    private int score = 0;

    private void calculateScore()
    {
		// Find the total score.
        int roundNumber = 0; // a var to track number of rounds. 
        for( int i=0; i < this.gameData.length; i++ )
        {
			// Final Round, special case. 
            if(roundNumber > 8)
            {

				if(getVal(i)>9)
				{
					if(getVal(i+2)>9)
					{
						score += 20 + getVal(i + 4);
					}
					else
					{
						score += 10 + getVal(i+2)+getVal(i+3);
					}
				}
				else 
				{
					// If the last throw is a spare
					// then add the bonus throw. 
					int tmp = getVal(i)+getVal(i+1);
					if(tmp > 9)
					{
						score += tmp + getVal(i+2);
					}
					// If it's not a spare, then the game is over.
					else 
					{
						score += tmp;
					}

				}
                break;
			}
			
			// Find value of each trow. 
            switch (gameData[i])
            {
                case ' ':
                    roundNumber++;
                    continue;
                case '/':
					score += getVal(i) + getVal(i +2);
					break;
				case 'x':
				case 'X':
                    score += 10;
                    int lookForward = 2;
                    int nextIndex = 2;
                    do
                    {
                        if(gameData[i + nextIndex] != ' ')
                        {
                            score += getVal(i + nextIndex);
                            --lookForward;
						}
						++nextIndex;
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
			case 'X':
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
		this.score = 0;
        this.gameData = s.toCharArray();
        this.calculateScore();
    }

    public int getScore()
    {
        return score;
    }

    public LineClass(String scoreString)
    {
        loadGameData(scoreString);
	}
	
	public LineClass()
	{
		System.out.println("Empty line made.");
	}
/*
    public static void main(String[] args)
    {
		LineClass test = new LineClass("11 11 11 11 x 22 22 22 22 xxx"); 
		//"1/ 2- x 32 9- x 32 21" "1/ 18 x 11 1- 32 32 32 32 32-"
        System.out.println(test.getScore());
    }
*/
}
