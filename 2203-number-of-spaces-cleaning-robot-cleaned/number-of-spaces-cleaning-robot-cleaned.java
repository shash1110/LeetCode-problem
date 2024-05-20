class Solution {
    public int numberOfCleanRooms(int[][] room) {
        int m = room.length;
        int n = room[0].length;

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0; // Start facing right
        int x = 0, y = 0; // Start at the top-left corner
        
        Set<String> cleaned = new HashSet<>();
        cleaned.add(x + "," + y);

        // Track visited positions to detect loops
        Set<String> visitedPositions = new HashSet<>();
        visitedPositions.add(x + "," + y + "," + dirIndex);
        
        while (true) {
            int newX = x + directions[dirIndex][0];
            int newY = y + directions[dirIndex][1];
            
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || room[newX][newY] == 1) {
                // Turn 90 degrees clockwise
                dirIndex = (dirIndex + 1) % 4;
            } else {
                x = newX;
                y = newY;
                String position = x + "," + y;
                cleaned.add(position);
            }
            
            String state = x + "," + y + "," + dirIndex;
            if (!visitedPositions.add(state)) {
                break; // Detected a loop, break the loop
            }
        }
        
        return cleaned.size();
    }
}