#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

ll search(ll a, ll b, ll c, ll d) {
    if (c<a || d<b) {
        return LLONG_MAX-1;
    }
    if (a == c && b == d) {
        return 0;
    }
    if (b == d) {
        if ((c-a)%d == 0) {
            return (c-a)/d;
        }
        else {
            return LLONG_MAX-1;
        }
    }
    if (a == c) {
        if ((d-b)%c == 0) {
            return (d-b)/c;
        }
        else {
            return LLONG_MAX-1;
        }
    }
    ll e = min(LLONG_MAX-1, search(a, b, c-d, d)+1);
    ll f = min(LLONG_MAX-1, search(a, b, c, d-c)+1);

    return min(e, f);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t; cin >> t;

    for (int ti = 0; ti<t; ti++)  {
        ll a, b, c, d;
        cin >> a >> b >> c >> d;

        if (a==c && b==d) {
            cout << 0 << "\n";
            continue;
        }

        ll ans = min(search(a, b, c-d, d)+1, search(a, b, c, d-c)+1);

        if (ans == LLONG_MAX) {
            cout << -1 << "\n";
            continue;
        }
        cout << ans << "\n";
    }
}