#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    cin >> t;
    for (int tc = 0; tc < t; tc++) {
        int n; cin >> n;
        vector<int> a;
        for (int i = 0 ;i<n; i++) {
            int ai; cin >> ai;
            a.push_back(ai);
        }

        if (n == 4) {
            int mx = max(max(a[0], a[1]), max(a[2], a[3]));
            cout << a[0] + a[1] + a[2] + a[3] - mx << " " << mx << endl;
        } else {
            cout << ((n/2)-2)*a[0] << " " << a[0]*((n/2)+2) << endl;
        }
    }
}