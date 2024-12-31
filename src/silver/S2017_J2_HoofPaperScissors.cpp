#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    int best = 0;

    vector<int> moves;
    vector<int> count = {0, 0, 0};

    for (int i = 0; i<n; i++) {
        string m;
        cin >> m;

        if (m=="H") {
            moves.push_back(0);
            count[0]++;
        } else if (m=="P") {
            moves.push_back(1);
            count[1]++;
        } else if (m=="S") {
            moves.push_back(2);
            count[2]++;
        }
    }

    vector<vector<int>> prefix;
    vector<vector<int>> suffix;

    for (int i = 0; i<3; i++) {
        vector<int> a;
        a.push_back(0);
        prefix.push_back(a);

        vector<int> b;
        b.push_back(count[(i+2)%3]);
        suffix.push_back(b);
    }

    for (int i = 1; i<=n; i++) {
        for (int j = 0; j<3; j++) {
            prefix[j].push_back(prefix[j][i-1]);
            suffix[j].push_back(suffix[j][i-1]);
        }
        prefix[(moves[i-1]+2)%3][i]++;
        suffix[(moves[i-1]+2)%3][i]--;
    }

    for (int i = 0; i<=n; i++) {
        best = max(best, prefix[0][i]+suffix[1][i]);
        best = max(best, prefix[0][i]+suffix[2][i]);
        best = max(best, prefix[1][i]+suffix[0][i]);
        best = max(best, prefix[1][i]+suffix[2][i]);
        best = max(best, prefix[2][i]+suffix[0][i]);
        best = max(best, prefix[2][i]+suffix[1][i]);
    }
    best = max(best, count[0]);
    best = max(best, count[1]);
    best = max(best, count[2]);

    cout << best << endl;
    // x P P H P S S
    // 0 0 0 0 0 1 2
    // 2 2 2 2 2 1 0
}