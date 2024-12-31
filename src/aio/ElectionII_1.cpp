#include <bits/stdc++.h>

using namespace std;

int main() {
    freopen("elecin.txt", "r", stdin);
    freopen("elecout.txt", "w", stdout);
    int n;
    cin >> n;
    int a=0, b=0, c=0;

    string votes;
    cin >> votes;

    for (int i = 0; i<n; i++) {
        string vote = votes.substr(i, 1);
        if (vote=="A") {
            a++;
        } else if (vote == "B") {
            b++;
        } else if (vote == "C") {
            c++;
        }
    }
    if (a>b && a>c) {
        cout << "A" << endl;
    } else if (b>a && b>c) {
        cout << "B" << endl;
    } else if (c>a && c>b) {
        cout << "C" << endl;
    } else {
        cout << "T" << endl;
    }
}