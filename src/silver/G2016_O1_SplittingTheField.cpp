#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<pair<int, int>> points;

    pair<int,int> bl;
    pair<int,int> tr;

    for (int i = 0; i<n; i++) {
        int x, y;
        cin >> x >> y;
        points.push_back(make_pair(x, y));
        if (i = 0) {
            bl = make_pair(x, y);
            tr = make_pair(x, y);
        }
        if (x<bl.first) {
            bl.first = x;
        }
        if (y<bl.second) {
            bl.second = y;
        }
        if (x>tr.first) {
            tr.first = x;
        }
        if (y>tr.second) {
            tr.second = y;
        }
    }


}