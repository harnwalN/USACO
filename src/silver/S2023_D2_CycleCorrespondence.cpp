#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    // one indexed
    map<int, int> a;
    map<int, int> b;
    map<int, int> b_rev;
    vector<int> check;
    vector<int> check_rev;

    for (int i = 0; i<k; i++) {
        int x;
        cin >> x;
        a[x] = i+1;
        check.push_back(0);
        check_rev.push_back(0);
    }
    for (int i = 0; i<k; i++) {
        int x;
        cin >> x;
        b[x] = i+1;
        b_rev[x] = k-i;
    }

    int extra = 0;
    
    for (int node = 1; node<=n; node++) {
        if (a.count(node) == 0 || b.count(node) == 0) {
            if (a.count(node)==0 && b.count(node)==0) {
                extra+=1;
                continue;
            } else {
                continue;
            }
        }

        int offs = b[node]-a[node];
        if (offs<0) {
            offs = k+offs;
        }
        check[offs]++;

        int offs_rev = b_rev[node]-a[node];
        if (offs_rev<0) {
            offs_rev = k+offs_rev;
        }
        check_rev[offs_rev]++;
    }
    int best = 0;

    for (auto el : check) {
        best = max(best, el);
    }
    for (auto el : check_rev) {
        best = max(best, el);
    }
    cout << best+extra << endl;
}