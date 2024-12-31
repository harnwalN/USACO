#include <bits/stdc++.h>
using namespace std;

vector<int> a;

int main() {
    int n; cin >> n;

    for (int i = 0; i<n; i++) {
        int ai; cin >> ai;
        a.push_back(ai-1);
        cout << "R";
    }
    a.push_back(0);
    int index = n-1;
    bool dir = false; // true is right, false is left
    while (a[0]!=0) {
        if (dir) {
            // Going Right
            if (a[index+1]>0) {
                index+=1;
                a[index]-=1;
                cout << "R";
            } else {
                dir = false;
            }
        } else {
            // Going Left
            if (a[index]>1 || a[index+1]==0) {
                a[index]-=1;
                index-=1;
                cout << "L";
            } else {
                dir = true;
            }
        }
    }
    cout << endl;
    return 0;
}