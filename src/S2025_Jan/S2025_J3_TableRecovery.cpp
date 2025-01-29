#include <bits/stdc++.h>
using namespace std;

int grid[1000][1000];
int cur[1000][1000];

struct Number {
    int a;
    Number(int val) {
        a = val;
    }
};
bool operator<(const Number &a,  const Number &b) {
    return a.a > b.a;
}

vector<priority_queue<Number>> occ; // # occurences to pq of best index available
int assignment[1001];
int occurences[1001];

int main() {
    int n;
    cin >> n;

    for (int r = 0; r<n; r++) {
        for (int c = 0; c<n; c++) {
            cin >> cur[r][c];
            occurences[cur[r][c]]++;
        }
    }

    // set up occ
    priority_queue<Number> _fill;
    occ.push_back(_fill);
    for (int n_occ = 1; n_occ<=n; n_occ++) {
        priority_queue<Number> pq;
        pq.push(n_occ+1);
        pq.push((n*2)-n_occ+1);
        occ.push_back(pq);
    }

    for (int r = 0; r<n; r++) {
        for (int c = 0; c<n; c++) {
            int old = cur[r][c];
            if (assignment[old]!=0) {
                cout << assignment[old];
            } else {
                assignment[old] = occ[occurences[old]].top().a;
                occ[occurences[old]].pop();
                cout << assignment[old];
            }
            if (c<n-1) cout << " ";
            else cout << "\n";
        }
    }
}