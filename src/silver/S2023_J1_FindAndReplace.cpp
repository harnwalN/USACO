#include <bits/stdc++.h>
using namespace std;

struct Node {
    string child;
    int lpn = -1; // loop number
};

map<char, Node> letters;
int loop[60] = {0};
int count = 0;

void dfs(Node node, int lopn) {
    if (node.lpn !=-1) {
        if (node.lpn == lopn) {
            loop[lopn]++;
        } else {

        }
    }
}

void solve(string aword, string bword) {
    for (int i = 0; i < aword.length(); i++) {
        Node a;
        a.child = bword[0];
        letters[aword[i]] = a;
    }
    int loop_num = 1;
    for (auto el : letters) {
        if (el.second.lpn != -1) {continue;}
        dfs(el.second, loop_num);
    }
}

int main() {
    int t;
    cin >> t;
    for (int i = 0; i<t; i++) {
        string a_string, b_string;
        cin >> a_string;
        cin >> b_string;
        solve(a_string, b_string);
        memset(loop, 0, sizeof(loop));
        letters.clear();
        count = 0;
    }
    return 0;
}