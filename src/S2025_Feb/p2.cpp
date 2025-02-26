#include <bits/stdc++.h>

using namespace std;

struct Word {
    int parent;
    int  connected;
    int level;
    bool leaf = true;

    Word(int p, int c, int l) {
        parent = p;
        connected = c;
        level = l;
    }
};

vector<Word> tree;
int leaves = 0;

void sub1(int p) {
    tree[p].connected-=1;
    if (tree[p].parent !=-1 && tree[p].connected==0) {
        sub1(tree[p].parent);
    } else {
        return;
    }
}

int findnewp(int q) {
    if (tree[q].connected>1 || q==-1) {
        return q;
    }
    return findnewp(tree[q].parent);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n; cin >> n;

    tree.push_back(Word(-1, 0, 0));
    leaves+=1;

    for (int i = 1; i<=n; i++) {
        int parent; cin >> parent;
        tree.push_back(Word(parent, 0, tree[parent].level+1));
        tree[parent].connected+=1;
        if (tree[parent].leaf) {
            tree[parent].leaf = false;
        } else {
            leaves+=1;
        }
        
    }

    for (int qi = 0; qi<leaves; qi++) {
        int q; cin >> q;

        // check w parent
        int p = tree[q].parent;
        Word par = tree[p];

        if (tree[p].connected > 1) {
            cout << tree[q].level << "\n";
            sub1(p);
        } else {
            tree[q].parent = findnewp(q);
            Word cur = tree[q];
            if (tree[q].parent == -1) {
                cout << 0 << "\n";
            } else {
                cout << tree[tree[q].parent].level+1 << "\n";
                tree[tree[q].parent].connected-=1;
            }
            par = tree[tree[q].parent];
        }
    }
}