#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("diamond.in", "r", stdin);
    freopen("diamond.out", "w", stdout);

    long long n, k;
     cin >> n >> k;
    vector<int> diamonds;
    for (int i = 0; i<n; i++) {
        long long d;
        cin >> d;
        diamonds.push_back(d);
    }
    sort(diamonds.begin(), diamonds.end());
    if (n==0) {
        cout << 0 << endl;
        return 0;
    }
    if (k==0) {
        cout << min(n, (long long) 2) << endl;
        return 0;
    }

    long long left = 0, right = 1;
    long long out = 0;

    long long max_len = 0;
    long long best_left, best_right, leng;

    while (left<right && right<n) {
        long long l = diamonds[left], r = diamonds[right];
        if (r-l>k) {
            left++;
            if (left==right) {
                right++;
            }
        } else {
            leng = (right-left)+1;
            if (leng>max_len) {
                max_len = leng;
                best_left = left;
                best_right = right;
            }
            right++;
        }
    }

    out+=max_len;
    vector<int> diamonds_copy;
    for (int i = 0; i<n; i++) {
        if (i>=best_left && i<=best_right) {
            continue;
        } else {
            diamonds_copy.push_back(diamonds[i]);
        }
    }
    diamonds = diamonds_copy;

    max_len = min((long long) 1, n-out);
    left = 0;
    right = 1;
    while (left<right && right<n-out) {
        long long l = diamonds[left], r = diamonds[right];
        if (r-l>k) {
            left++;
            if (left==right) {
                right++;
            }
        } else {
            max_len = max(max_len, (right-left)+1);
            right++;
        }
    }

    out+=max_len;
    cout << out << endl;
}