#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("tspin.txt", "r", stdin);
    freopen("tspout.txt", "w", stdout);

    int n;
    cin >> n;
    vector<int> mins;
    vector<int> maxs;

    for (int i = 0; i<n; i++) {
        int s;
        cin >> s;
        mins.push_back(s);
    }
    for (int i = 0; i<n; i++) {
        int s;
        cin >> s;
        maxs.push_back(s);
    }

    int sold = mins[0];
    for (int i = 1; i<n; i++) {
        int mi = mins[i];
        int ma = maxs[i];

        if (sold<=ma) {
            sold = max(sold, mi);
        } else {
            cout << "NO" << endl;
            return 0;
        }
    }
    cout << "YES" << endl;
}