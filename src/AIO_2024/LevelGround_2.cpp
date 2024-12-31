#include <bits/stdc++.h>

using namespace std;

int main() {
    freopen("groundin.txt", "r", stdin);
    freopen("groundout.txt", "w", stdout);
    int n;
    cin >> n;
    vector<int> alt;
    for (int i = 0; i<n; i++) {
        int a;
        cin >> a;
        alt.push_back(a);
    }

    int left = 0, right = 0;
    int max_intense = 0;
    while (right<n) {
        if (alt[left] == alt[right]) {
            max_intense = max((right-left+1) * alt[left], max_intense);
            right++;
        } else {
            left = right;
        }
    }

    cout << max_intense << endl;
}