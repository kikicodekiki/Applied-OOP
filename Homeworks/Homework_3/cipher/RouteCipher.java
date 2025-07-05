package Homeworks.Homework_3.cipher;

public class RouteCipher {

    public RouteCipher(int key) {
        setKey(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        // no additional restrictions provided
        this.key = key;
    }

    public String encrypt(String plainText) {
        char[] plainTextChars = plainText.toCharArray();

        int columns = Math.abs(key);
        int rows = (int) Math.ceil((double) plainTextChars.length / columns);
        char[][] grid = new char[rows][columns];

        // fill the grid row by row
        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (index < plainTextChars.length) {
                    grid[r][c] = plainTextChars[index++];
                } else {
                    grid[r][c] = 'X'; // fill extra spaces with 'X'
                }
            }
        }

        // encrypt using spiral (StackOverflow style <3)
        char[] encryptedChars = new char[rows * columns];
        if (key > 0) {
            spiralTopLeft(grid, encryptedChars);
        } else {
            spiralBottomRight(grid, encryptedChars);
        }

        return new String(encryptedChars);
    }

    public String decrypt(String cipherText) {
        char[] cipherTextChars = cipherText.toCharArray();

        int columns = Math.abs(key);
        int rows = (int) Math.ceil((double) cipherTextChars.length / columns);
        char[][] grid = new char[rows][columns];

        // fill the grid in spiral order
        if (key > 0) {
            fillSpiralTopLeft(grid, cipherTextChars);
        } else {
            fillSpiralBottomRight(grid, cipherTextChars);
        }

        // read the grid row by row to get the plaintext
        char[] decryptedChars = new char[rows * columns];
        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                decryptedChars[index++] = grid[r][c];
            }
        }

        return new String(decryptedChars);
    }

    private void spiralTopLeft(char[][] grid, char[] result) {
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        int index = 0;

        while (top <= bottom && left <= right) {
            // first column from the remaining columns
            for (int i = top; i <= bottom; ++i) {
                result[index++] = grid[i][left];
            }
            left++;

            // bottom row from the remaining rows
            for (int i = left; i <= right; ++i) {
                result[index++] = grid[bottom][i];
            }
            bottom--;

            //  last column from the remaining columns
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    result[index++] = grid[i][right];
                }
                right--;
            }

            // top row from the remaining
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    result[index++] = grid[top][i];
                }
                top++;
            }
        }
    }

    private void spiralBottomRight(char[][] grid, char[] result) {
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        int index = 0;

        while (top <= bottom && left <= right) {
            // last column upwards
            for (int i = bottom; i >= top; --i) {
                result[index++] = grid[i][right];
            }
            right--;

            // top row from r to l
            for (int i = right; i >= left; --i) {
                result[index++] = grid[top][i];
            }
            top++;

            //first column downwards
            if (left <= right) {
                for (int i = top; i <= bottom; ++i) {
                    result[index++] = grid[i][left];
                }
                left++;
            }

            // bottom row from left to right
            if (top <= bottom) {
                for (int i = left; i <= right; ++i) {
                    result[index++] = grid[bottom][i];
                }
                bottom--;
            }
        }
    }

    private void fillSpiralTopLeft(char[][] grid, char[] data) {
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        int index = 0;

        while (top <= bottom && left <= right) {
            for (int i = top; i <= bottom; ++i) {
                grid[i][left] = data[index++];
            }
            left++;

            for (int i = left; i <= right; ++i) {
                grid[bottom][i] = data[index++];
            }
            bottom--;

            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    grid[i][right] = data[index++];
                }
                right--;
            }

            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    grid[top][i] = data[index++];
                }
                top++;
            }
        }
    }

    private void fillSpiralBottomRight(char[][] grid, char[] data) {
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        int index = 0;

        while (top <= bottom && left <= right) {
            for (int i = bottom; i >= top; --i) {
                grid[i][right] = data[index++];
            }
            right--;

            for (int i = right; i >= left; --i) {
                grid[top][i] = data[index++];
            }
            top++;

            if (left <= right) {
                for (int i = top; i <= bottom; ++i) {
                    grid[i][left] = data[index++];
                }
                left++;
            }

            if (top <= bottom) {
                for (int i = left; i <= right; ++i) {
                    grid[bottom][i] = data[index++];
                }
                bottom--;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("RouteCipher [key=%d]", key);
    }

    private int key;

}
