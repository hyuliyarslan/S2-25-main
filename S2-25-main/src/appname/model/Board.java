package appname.model;

public class Board {
    private boolean isNextToTile = true;
    private final int  max_rows = 11;
    private final int max_columns = 11;
    private boolean finished = false;
    private Colors mainBoard[][] = new Colors[max_rows][max_columns];
    private Colors firstBackup[][] = new Colors[max_rows][max_columns];
    private Colors secondBackup[][] = new Colors[max_rows][max_columns];
    private int counter = 0,countBackups = 0;
    private Colors color;
    private int amountTiles = 0;
    private Player player = new Player();
    private int amountConnectedNeeded;
    private int amountConnected = 0;
    private int countNoTilesNext = 1;
    private int checkRow, checkColumn;
    private int amountPlayers;
    private Colors winnerColor;
    private int[] tilesCount = new int[2];
    private boolean isLastRow = false;
    private int countTiles = 0;
    private boolean last = false;
    private boolean canDoBackup = true;



    public int getAmountPlayers() {
        return amountPlayers;
    }

    public void setAmountPlayers(int amountPlayers) {
        this.amountPlayers = amountPlayers;
    }


    public void startGame (int amountPlayers)
    {
        setAmountPlayers(amountPlayers);
        setAmountConnectedNeeded();
        createMainBoard();
    }
    public Board()
    {

    }
    public int getAmountConnectedNeeded() {
        return amountConnectedNeeded;
    }
    public void setAmountConnectedNeeded() {
        if (getAmountPlayers() > 2)
        {
            this.amountConnectedNeeded = 4;
            this.amountTiles = 6;

        }
        if (getAmountPlayers() == 2) {
            this.amountConnectedNeeded = 5;
            this.amountTiles = 12;
        }

    }
    public void createMainBoard()
    {

        for (int y = 0; y <= 5;y++)
        {
            for (int x = 0; x <= 5+y;x++)
            {
                mainBoard[y][x] = Colors.NONE;
            }
        }

        for (int y = 6; y <= 10;y++)
        {
            for (int x = 0; x <= 9 - counter;x++)
            {
                mainBoard[y][x] = Colors.NONE;

            }
            counter++;
        }
    }
    public void checkTiles() // CHECK BOTH SIDES OF TILES AND REMOVE SMALLEST
    {
        createBackupSecond();
        for (int i = 0; i<= 1;i++) {
            for (checkRow = 0; checkRow < max_rows; checkRow++) {
                for (checkColumn = 0;checkColumn < max_columns; checkColumn++) {
                    if (checkEnums("Check")) // check if current column & row = any color.
                    {
                        isNextToTile = true;
                        while (isNextToTile) { // stops whenever they're not next to tile anymore.
                            switch (countNoTilesNext) {
                                case 1:
                                    if (checkEnums("checkRowRight"))
                                    {
                                        //     check = 1;
                                        // countTiles++;

                                    }
                                    else {
                                        last = true;
                                    }
                                    break;
                                case 2:
                                    if (checkEnums("checkRowLeft")) {
                                        //isLastRowRow = true;
                                        mainBoard[checkRow][checkColumn + 1] = Colors.NONE;
                                        countTiles++;
                                        break;
                                    }
                                    else {
                                        mainBoard[checkRow][checkColumn ] = Colors.NONE;
                                        countTiles++;
                                        isLastRow = true;

                                    }
                                case 3:
                                    if (checkEnums("checkDiaDownLeft")) {
                                        // check = 2;
                                        // countTiles++;
                                        break;
                                    }

                                case 4:
                                    if (checkEnums("checkDiaDownRight")) {
                                        // countTiles++;
                                        break;
                                    }

                            }
                            if (isLastRow) {
                                if (lastTileInArea()) {
                                    isNextToTile = false;
                                    checkColumn = 12;
                                    checkRow = 12;
                                }
                                isLastRow = false;
                            }
                            if (last) {
                                countNoTilesNext = 2;
                                last = false;
                            }
                            else {
                                countNoTilesNext = 1;
                                //    lastChecks[counter3] = check;
                                //    check = 0;
                                //    counter3++;
                            }
                        }
                        countBackups++;
                        if (countBackups == 1) {
                            createBackupFirst();
                        }
                        if (countBackups == 2) {
                            canDoBackup = false;
                            createBackupSecond();
                        }
                        checkRow = max_rows + 1;
                        checkColumn = max_columns + 1;

                    }


                }
            }
            System.out.println(countTiles);
            tilesCount[i] = countTiles;
            countTiles = 0;
        }
        if (tilesCount[0] < tilesCount[1])
        {
            setBackupToNormalFirst();
        }
        if (tilesCount[0] > tilesCount[1])
        {
            setBackupToNormalSecond();
        }
        countBackups = 0;

    }


    public boolean isConnected(){ // CHECK FI WINNERS
        //Get position of each tile
        for (int colors = 0; colors <= 5; colors++) {
            switch (colors) {
                case 0:
                    color = Colors.RED;
                    break;
                case 1:
                    color = Colors.GREEN;
                    break;
                case 2:
                    color = Colors.BLUE;
                    break;
                case 3:
                    color = Colors.PURPLE;
                    break;
                case 4:
                    color = Colors.YELLOW;
                    break;
                case 5:
                    color = Colors.ORANGE;
                    break;
            } // check for each color


            for (int y = 0; y <= max_rows - 1; y++) {
                for (int x = 0; x <= max_columns - 1; x++) {
                    if (mainBoard[y][x] == color) {
                        for (int a = 0; a <= 3; a++) {
                            switch (a)
                            {
                                case 1: // RIGHT
                                    for (int z = 0; z <= amountConnectedNeeded; z++)
                                    {
                                        if (x + z <= max_columns - 1) {
                                            if (mainBoard[y][x + z] == color) {
                                                amountConnected++;
                                            }
                                        }
                                    }
                                    break;

                                case 2: // DOWN LEFT WORKS USE THIS EXAMPLE
                                    for (int z = 0; z <= amountConnectedNeeded; z++)
                                    {
                                        if (y + z <= max_rows - 1) {
                                            if (mainBoard[y + z][x] == color) {
                                                amountConnected++;

                                            }
                                        }
                                    }
                                    break;

                                case 3: // DOWN RIGHT
                                    for (int z = 0; z <= amountConnectedNeeded; z++)
                                    {
                                        if (x + z <= max_columns - 1 && y + z <= max_columns - 1) {
                                            if (mainBoard[y + z][x + z] == color) {
                                                amountConnected++;
                                            }
                                        }
                                    }
                                    break;
                            }

                            if (amountConnected >= getAmountConnectedNeeded()) // countNoTilesNext
                            {
                                finished = true;
                                y = 100;
                                x = 100;
                                a = 100;
                                colors = 6;
                            }
                            amountConnected = 0;


                        } // for loop (in if )

                    } // if mainBoard = color
                }
            } // for loop (after switch)
        } // for loop for EACH color we check if they won or not.

        if (finished)
        {
            setWinnerColor(color);
            return true;
        }
        else {
            return false;
        }
    }

    public void createBackupFirst ()
    {

        for (int y = 0; y < max_rows; y++)
        {
            for (int x = 0; x < max_columns;x++)
            {
                firstBackup[y][x] = mainBoard[y][x];
            }
        }

    }
    public void setBackupToNormalFirst()
    {
        for (int y = 0; y < max_rows; y++)
        {
            for (int x = 0; x < max_columns;x++)
            {
                mainBoard[y][x] = firstBackup[y][x];
            }
        }
    }
    public void createBackupSecond ()
    {

        for (int y = 0; y < max_rows; y++)
        {
            for (int x = 0; x < max_columns;x++) {
                if (!(secondBackup[y][x] == Colors.NONE) && !(firstBackup[y][x] == Colors.NONE))
                { secondBackup[y][x] = Colors.NONE;}
                if (canDoBackup)
                    secondBackup[y][x] = mainBoard[y][x];
            }

        }

    }
    public void setBackupToNormalSecond()
    {
        for (int y = 0; y < max_rows; y++)
        {
            for (int x = 0; x < max_columns;x++)
            {
                mainBoard[y][x] = secondBackup[y][x];
            }
        }
    }
    public boolean checkEnums(String action) {

        if (action.equalsIgnoreCase("check")) {

            if ((!(mainBoard[checkRow][checkColumn] == Colors.NONE) == (!(mainBoard[checkRow][checkColumn] == null)))) {
                return true;
            }
            else {
                return false;
            }
        }
        if (action.equalsIgnoreCase( "checkRowRight")) {
            checkColumn++;

            if ((!(mainBoard[checkRow][checkColumn] == Colors.NONE) == (!(mainBoard[checkRow][checkColumn] == null)))) {

                return true;
            }

            else {
                checkColumn--;
                return false;
            }

        }
        if (action.equalsIgnoreCase( "checkRowLeft")) {
            checkColumn--;

            if ((!(mainBoard[checkRow][checkColumn] == Colors.NONE) == (!(mainBoard[checkRow][checkColumn] == null)))) {
                return true;
            }
            else {
                checkColumn++;
                return false;
            }
        }
        if (action.equalsIgnoreCase("checkDiaUpLeft")) {
            checkColumn--;
            checkRow--;
            if (!(mainBoard[checkRow][checkColumn] == Colors.NONE && !(mainBoard[checkRow][checkColumn] == null))) {
                return true;
            }

            else {
                checkColumn++;
                checkRow++;
                return false;
            }
        }
        if (action.equalsIgnoreCase("checkDiaUpRight")) {
            checkColumn++;
            checkRow--;
            if (!(mainBoard[checkRow][checkColumn] == Colors.NONE && !(mainBoard[checkRow][checkColumn] == null))) {
                return true;
            }

            else {
                checkColumn--;
                checkRow++;
                return false;
            }
        }
        if (action.equalsIgnoreCase("checkDiaDownLeft")) {
            checkRow++;
            if ((!(mainBoard[checkRow][checkColumn] == Colors.NONE) == (!(mainBoard[checkRow][checkColumn] == null)))) {
                return true;
            }

            else {
                checkRow--;
                return false;
            }
        }
        if (action.equalsIgnoreCase("checkDiaDownRight")) {
            checkColumn++;
            checkRow++;
            if ((!(mainBoard[checkRow][checkColumn] == Colors.NONE) == (!(mainBoard[checkRow][checkColumn] == null)))) {
                return true;
            }

            else {
                checkColumn--;
                checkRow--;
                return false;
            }
        }
        else {
            return false;
        }

    }

    public boolean lastTileInArea()
    {
        if (checkEnums("CheckRowLeft") || checkEnums("CheckRowRight") || checkEnums("CheckDiaDownRight") || checkEnums("CheckDiaLeft"))
        {
            return false;
        }
        else {
            return true;
        }
    }

    public Colors getWinnerColor() {
        return winnerColor;
    }

    public void setWinnerColor(Colors winnerColor) {
        this.winnerColor = winnerColor;
    }
    public Tile removeTile(int row, int col) {    return null;
    }

    public boolean isPlacedNextToTile(int x, int y)
    {
        // RIGHT, LEFT, TOP RIGHT, TOP LEFT,
        if (x >= 5 && (mainBoard[x][y+1] == Colors.NONE || mainBoard[x][y+1] == null) && (mainBoard[x][y-1] == Colors.NONE || mainBoard[x][y-1] == null) && (mainBoard[x-1][y] == Colors.NONE || mainBoard[x-1][y] == null) && (mainBoard[x+1][y] == Colors.NONE || mainBoard[x-1][y] == null) && (mainBoard[x-1][y+1] == Colors.NONE || mainBoard[x-1][y+1] == null)  && (mainBoard[x+1][y+1] == Colors.NONE || mainBoard[x+1][y+1] == null))
        {
            return true;
        }
        // TOP LEFT , BOTTOM RIGHT, TOP RIGHT, RIGHT, LEFT, BOTTOM LEFT
        if ((mainBoard[x+1][y] == Colors.NONE || mainBoard[x+1][y] == null) && (mainBoard[x-1][y] == Colors.NONE || mainBoard[x-1][y] == null)  && (mainBoard[x-1][y-1] == Colors.NONE || mainBoard[x-1][y-1] == null) && (mainBoard[x][y+1] == Colors.NONE || mainBoard[x][y+1] == null)  && (mainBoard[x][y-1] == Colors.NONE || mainBoard[x][y-1] == null)&& (mainBoard[x+1][y+1] == Colors.NONE || mainBoard[x+1][y+1] == null))
        {
            return true;
        }
        else {
            return false;
        }
    }


    public boolean placeTile(Colors color, int x, int y) {
        if (mainBoard[x][y] == Colors.NONE)
        {
            mainBoard[x][y] = color;
            return true;
        }
        else {
            return false;
        }
    }



}
//class
