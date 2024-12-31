#include <bits/stdc++.h>

using namespace std;

class Node {
    public:
        int pointed_from = 0;
        int cost = 0;
        Node* next = nullptr;

        Node () {
            this-> next = nullptr;
        }
        Node (Node* next) {
            this->next = next;
        }
    
};

int main() {
    int n; cin >> n;
    vector<vector<int>> grid;
    Node tree[n][n];
    for (int i = 0; i<n; i++) {
        vector<int> v;

        string dir;
        int c;
        cin >> dir >> c;
        for (int s = 0; s<n; s++) {
            if (dir.substr(s, 1)=="R") {
                v.push_back(1);
            } else {
                v.push_back(0);
            }
        }
        v.push_back(c);
        grid.push_back(v);
    }
    vector<int> waud;
    for (int i = 0; i<n; i++) {
        int c;
        cin >> c;
        waud.push_back(c);
    }
    grid.push_back(waud);

}