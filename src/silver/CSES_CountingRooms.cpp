#include <bits/stdc++.h>
using namespace std;

int grid[1001][1001];
bool visited[1001][1001];
int n_rooms;
int n, m;

void floodfill(int r, int c) {
    if (r<0 || c<0 || r>=n || c>=m) return;
    else if (grid[r][c] == 0 || visited[r][c]) return;
    else {
        visited[r][c] = true;
        floodfill(r-1, c);
        floodfill(r+1, c);
        floodfill(r, c-1);
        floodfill(r, c+1);
    }
}

int main() {
    cin >> n >> m;

    n_rooms = 0;

    // Set up grid
    for (int i = 0; i<n; i++) {
        string line; cin >> line;
        for (int j = 0; j<m; j++) {
            // 1 is floor, 0 is wall
            if (line.substr(j, 1) == "#") {
                grid[i][j] = 0;
            } else {
                grid[i][j] = 1;
            }
        }
    }

    for (int i = 0; i<n; i++) {
        for (int j = 0; j<m; j++) {
            if (!visited[i][j] && grid[i][j] !=0) {
                n_rooms++;
                floodfill(i, j);
            }
        }
    }
    
    cout << n_rooms << endl;
}