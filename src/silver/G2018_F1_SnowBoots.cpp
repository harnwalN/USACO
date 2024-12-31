#include <bits/stdc++.h>
using namespace std;

vector<int> depth;
vector<vector<int>> boots;

int main() {
    freopen("snowboots.in", "r", stdin);
    freopen("snowboots.out", "w", stdout);
    int n, b;
    cin >> n >> b;

    for (int i = 0; i<n; i++) {
        int f;
        cin >> f;
        depth.push_back(f);
    }
    for (int i = 0; i<b; i++) {
        vector<int> v;
        int s, d;
        cin >> s >> d;
        v.push_back(s);
        v.push_back(d);
        boots.push_back(v);
    }
    for (auto b : boots) {
        int dep = b[0];
        int step = b[1];

        int last_valid = 0;
        bool worked = true;
        for (int i = 1; i<n; i++) {
            if (dep>=depth[i]) {
                last_valid = i;
            } else if (i-last_valid>=step) {
                cout << 0 << "\n";
                worked = false;
                break;
            }
        }
        if (worked) {
            cout << 1 << "\n";
        }
    }
}