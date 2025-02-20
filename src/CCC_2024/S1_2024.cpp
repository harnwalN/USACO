#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    vector<int> h(n);
    for (int i =0 ; i<n; i++) {
        cin >> h[i];
    }

    int ans = 0;
    int diff = n/2;
    for (int i = 0; i<n/2; i++) {
        if (h[i] == h[i+diff]) {
            ans++;
        }
    }
    cout << ans*2 << endl;
}