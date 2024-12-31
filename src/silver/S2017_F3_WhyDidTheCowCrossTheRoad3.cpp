#include <bits/stdc++.h>
using namespace std;

const int max_n = 100;
int n, k, r;

set<int> grid[max_n][max_n]; // directions that you can't go in from a point
int visited[max_n][max_n]; // 0 if unvisited, component # if visited
bool cows[max_n][max_n];

int comp_cnt[max_n*max_n]; // 1 indexed
int cur_comp;

void floodfill(int r, int c) {
    if (r<0 || c<0 || r>=n || c>=n) return;
    if (!visited[r][c]==0) return;

    if (cows[r][c]) {
        comp_cnt[cur_comp]+=1;
    }

    visited[r][c] = cur_comp;

    if (!grid[r][c].count(1)>0) floodfill(r-1, c);
    if (!grid[r][c].count(2)>0) floodfill(r, c+1);
    if (!grid[r][c].count(3)>0) floodfill(r+1, c);
    if (!grid[r][c].count(4)>0) floodfill(r, c-1);
}

int main() {
    freopen("countcross.in", "r", stdin);
    freopen("countcross.out", "w", stdout);
    
    cin >> n >> k >> r;
    cur_comp = 1;

    for (int i = 0; i < r; i++) {
        int r, c, rd, cd;
        cin >> r >> c >> rd >> cd;
        --r, --c, --rd, --cd;
        if (r == rd) {
            if (c<cd) {
                grid[r][c].insert(2);
                grid[rd][cd].insert(4);
            } else {
                grid[r][c].insert(4);
                grid[rd][cd].insert(2);
            }
        } else {
            if (r<rd) {
                grid[r][c].insert(3);
                grid[rd][cd].insert(1);
            } else {
                grid[r][c].insert(1);
                grid[rd][cd].insert(3);
            }
        }
    }

    for (int i = 0; i<k; i++) {
        int r, c;
        cin >> r >> c;
        --r, --c;
        cows[r][c] = true;
    }

    for (int r = 0; r<n; r++) {
        for (int c = 0; c<n; c++) {
            if (visited[r][c]==0) {
                floodfill(r, c);
                ++cur_comp;
            }
        }
    }
    int pairs = 0;
    for (int i = 1; i<cur_comp; i++) {
        for (int j = 1; j<i; j++) {
            pairs += comp_cnt[i]*comp_cnt[j];
        }
    }
    cout << pairs << endl;
    return 0;
}