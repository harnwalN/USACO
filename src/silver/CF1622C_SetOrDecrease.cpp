#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    int t; cin >> t;

    for (int ti = 0; ti<t; ti++) {
        int n, target;
        cin >> n >> target;

        ll total = 0;

        vector<int> a(n);
        for (int i = 0 ; i<n; i++) {
            cin >> a[i];
            total+=a[i];
        }

        sort(a.begin(), a.end(), greater<int>());
        ll difference = max(total-target, (ll) 0);
        if (n==1) {
            cout << difference << endl;
            continue;
        }
        int smallest = a[n-1];

        vector<ll> prefix_top;
        prefix_top.push_back(0);
        for (int i = 1; i<n+1; i++) {
            prefix_top.push_back(prefix_top[i-1]+a[i-1]);
        }

        ll best_steps = difference;
        for (int u = 1; u<n-1; u++) {
            best_steps = min(best_steps, 
            (((difference-prefix_top[u])+(smallest*u)+u)/(u+1))+u);
        }

        cout << best_steps << endl;
    }
    return 0;
}