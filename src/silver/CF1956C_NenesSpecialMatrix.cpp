#include <bits/stdc++.h>
using namespace std;

void solve() {
    int l; cin >> l;
    for (int i = l; i>0; i--) {
        cout << 1 << " " << i << " ";
        for (int j = 1; j<=l; j++) {
            cout << j;
            if (j<l) {
                cout << " ";
            }
        }
        cout << "\n";
        cout << 2 << " " << i << " ";
        for (int j = 1; j<=l; j++) {
            cout << j;
            if (j<l) {
                cout << " ";
            }
        }
        cout << "\n";
    }
}

int main() {
    int tc; cin >> tc;
    for (int i = 0; i<tc; i++) {
        solve();
    }
    return 0;
}
