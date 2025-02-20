#include <bits/stdc++.h>
using namespace std;

int main() {
    int t, n; cin >> t >> n;

    for (int ti = 0; ti<t; ti++) {
        int counts[55] = {0};
        bool pass = true;
        string word; cin >> word;
        for (int i = 0 ; i<n; i++) {
            counts[word[i]-'a']++;
        }

        bool last_heavy = counts[word[0]]>1;
        for (int i = 1; i<n; i++) {
            bool cur_heavy = counts[word[i]-'a']>1;
            if (last_heavy == cur_heavy) {
                pass = false;
                break;
            }
            last_heavy = cur_heavy;
        }
        if (pass) cout << "T" << "\n";
        else cout << "F" << "\n";
    }
    return 0;
}