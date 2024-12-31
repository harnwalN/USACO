#include <bits/stdc++.h>
using namespace std;

int B(string sub) {
    int count = 0;
    int num = 0;
    string bessie = "bessie";
    for (auto c : sub) {
        if (c == bessie[num]) {
            num++;
        }
        if (num == bessie.length()) {
            count ++;
            num = 0;
        }
    }
    return count;
}

int main() {
    string s; cin >> s;
    cout << B(s) << endl;
    return 0;
}