#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t; cin >> t;

    for (int ti = 0; ti<t; ti++) {
        int n; cin >> n;
        vector<int> a(n);
        vector<int> sa(n);
        for (int i = 0; i<n; i++) {
            int ai; cin >> ai;
            a[i] = ai;
            sa[i] = ai;
        }
        bool printed = false;
        sort(sa.begin(), sa.end(), greater<int>());

        int good = 0;
        for (int i = 0; i<n; i++) {
            if (sa[i] == a[i]) {
                if (good>0) {
                    cout <<" "<< a[i];
                    printed = true;
                } else {
                    cout << a[i];
                    printed = true;
                }
                good++;
            } else {
                break;
            }
        }
        if (good == n) {
            cout << "\n";
            continue;
        }
        vector<int> rev;
        int cur_max = -1;
        bool moved = false;

        for (int i = n-1; i>=good; i--) {
            if (a[i] == sa[good] && !moved) {
                moved = true;
                if (good>0) {
                    cout <<" "<< a[i];
                    printed = true;
                } else {
                    cout << a[i];
                    printed = true;
                }
            } else if (a[i]>=cur_max) {
                rev.push_back(a[i]);
                cur_max = a[i];
            }
        }

        for (int i = rev.size()-1; i>=0; i--) {
            if (printed) {
                cout << " " << rev[i];
            } else {
                cout << rev[i];
            }
        }
        cout << "\n";
    }
}