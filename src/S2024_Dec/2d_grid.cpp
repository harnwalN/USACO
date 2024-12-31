#include <bits/stdc++.h>
using namespace std;

struct Change {
    int r;
    int c;
    int t;
};

vector<Change> changes;
vector<vector<int>> grid;
vector<vector<int>> u; // 2 = usable, 1 = unusable, 0 = unvisited, -1 = visited

int use_fill(int r, int c) {
    if (u[r][c] == 2) {
        return 2;
    } else if (u[r][c] == 1) {
        return 1;
    } else if (u[r][c] == -1) {
        return -1;
    } else {
        u[r][c] =-1;
        if (grid[r][c] == 1) {
            u[r][c] = use_fill(r-1, c);
        } else if (grid[r][c] == 2) {
            u[r][c] = use_fill(r, c+1);
        } else if (grid[r][c] == 3) {
            u[r][c] = use_fill(r+1, c);
        } else if (grid[r][c] == 4) {
            u[r][c] = use_fill(r, c-1);
        }
    }
    
}

int main() {
    int n; int k; 
    cin >> n >> k;
    for (int i = 0; i<n; i++) {
        vector<int> a;
        for (int i = 0; i<n; i++) {
            a.push_back(0);
        }
        grid.push_back(a);
        u.push_back(a);
    } // start all values with 0 - unassigned


    for (int q = 0; q < k; q++) {
        int r; int c; int t;
        string ty;
        cin >> r >> c >> ty;

        if (ty == "R") {
            t = 2;
        } else if (ty == "U") {
            t = 1;
        } else if (ty == "D") {
            t = 3;
        } else if (ty == "L") {
            t = 4;
        } // set up directions as numbers

        grid[r][c] = t;

        Change ch;
        ch.r = r; ch.c = c; ch.t = t;
        changes.push_back(ch);
    }

    for (int r = 0; r<n; r++) {
        // do borders
        if (r==0) {
            // top row
            for (int c = 0; c<n; c++) {
                if (grid[r][c] == 0 || grid[r][c] == 1) {
                    u[r][c] = 2;
                }
            }
        } else if (r == n-1) { // bottom row
            for (int c = 0; c<n; c++) {
                if (grid[r][c] == 0 || grid[r][c] == 3) {
                    u[r][c] = 2;
                }
            }
        } else {
            if (grid[r][0] == 0 || grid[r][0] == 4) { // left col
                u[r][0] = 2;
            }
            if (grid[r][n-1] == 0 || grid[r][n-1] == 2) { // right col
                u[r][n-1] = 2;
            }
        }
    }
    for (int r = 0; r<n; r++) {
        for (int c = 0; c<n; c++) {
            grid[r][c] = use_fill(r, c);
        }
    }
}