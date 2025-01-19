#include <bits/stdc++.h>
using namespace std;

int main() {
    // Uses Floyd's Algorithm
    int trash;
    string more_trash;

    cout << "next " << 0 << " " << 1 << endl;
    cin >> trash;
    for (int i = 0; i<trash; i++) {
        cin >> more_trash;
    }

    cout << "next " << 1 << endl;
    cin >> trash;
    for (int i = 0; i<trash; i++) {
        cin >> more_trash;
    }
    
    while (trash!=2) {
        cout << "next " << 0 << " " << 1 << endl;
        cin >> trash;
        for (int i = 0; i<trash; i++) {
            cin >> more_trash;
        }

        cout << "next " << 1 << endl;
        cin >> trash;
        for (int i = 0; i<trash; i++) {
            cin >> more_trash;
        }
    }

    while (trash!=1) {
        cout << "next " << 0 << " " << 1 << " " << 2 << " " << 3 << " " << 4 << " " << 5 << " " << 6 << " " << 7 << " " << 8 << " " << 9 << endl;
        cin >> trash;
        for (int i = 0; i<trash; i++) {
            cin >> more_trash;
        }
    }

    cout << "done" << endl;
}