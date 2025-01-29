#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    int t; cin >> t;
    for (int ti = 0; ti<t; ti++) {
        // each test case

        ll n, m;
        cin >> n >> m;

        vector<ll> a;
        for (int i = 0; i<n; i++) {
            ll ai; cin >> ai;
            a.push_back(ai%m);
        }
        ll best = 999999999;
        
        for (int i = 0; i<m; i++) {
            ll cur = 0;
            for (int j = 0; j<n; j++) {
                cur+=min(abs(a[j]-i), abs(m-(a[j]-i)));
            }
            best = min(best, cur);
        }
        cout << best << endl;
    }
    return 0;
}