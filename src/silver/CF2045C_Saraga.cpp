#include <bits/stdc++.h>
using namespace std;

int main() {
    string s, t;
    cin >> s >> t;
    map<char, int> s_first;
    map<char, int> t_first;

    for (int i = 1; i<s.length(); i++) {
        char c = s[i];
        if (s_first.count(c)) {
            continue;
        } else {
            s_first[c] = i+1;
        }
    }
    for (int i = t.length()-2; i>=0; i--) {
        char c = t[i];
        if (t_first.count(c)) {
            continue;
        } else {
            t_first[c] = t.length()-i;
        }
    }
    int best = 999999;
    char c_best;
    string best_str;

    for (auto p : s_first) {
        char c = p.first;
        if (t_first.count(c)) {
            if (s_first[c]+t_first[c]<best) {
                best = s_first[c]+t_first[c];
                best_str = s.substr(0, s_first[c]) + t.substr(t.length()-t_first[c]+1, t_first[c]);
                c_best = c;
            }
        }
    }
    if (best == 999999) {
        cout << -1 << endl;
    } else {
        cout << best_str << endl;
    }
}