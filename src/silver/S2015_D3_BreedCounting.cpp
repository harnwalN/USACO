#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("bcount.in", "r", stdin);
    freopen("bcount.out", "w", stdout);
    int n, q;
    cin >> n >> q;
    vector<vector<int>> prefix;
    // 1 H, 2 G, 3 J
    for (int i = 0; i<3; i++) {
        vector<int> a;
        a.push_back(0);
        prefix.push_back(a);
    }

    for (int i = 0; i<n; i++) {
        int b;
        cin >> b;
        for (int j = 0; j<3; j++) {
            prefix[j].push_back(prefix[j][i]);
            if (b-1 == j) {
                prefix[j][i+1]+=1;
            }
        }
    }

    for (int i = 0; i<q; i++) {
        int a, b;
        cin >> a >> b;
        
        for (int j = 0; j<3; j++) {
            cout << prefix[j][b]-prefix[j][a-1] << " ";
        }
        if (i==0 || i==1) {
            cout << "\n";
        } else {
            cout << endl;
        }
    }

    return 0;
}