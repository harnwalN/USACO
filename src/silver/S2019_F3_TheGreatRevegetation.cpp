#include <bits/stdc++.h>
using namespace std;

vector<int> same[100001];
vector<int> different[100001];
int visited[100001];
int n_components;
bool possible = true;

queue<int> bfs_q;

void BFS() {
    while (!bfs_q.empty() && possible) {
        int x = bfs_q.front(); bfs_q.pop();

        for (int sa : same[x]) {
            if (visited[sa] == visited[x]) continue;
            else if (visited[sa] == 0) {
                visited[sa] = visited[x];
                bfs_q.push(sa);
            } else {
                possible = false;
                return;
            }
        }

        for (int diff : different[x]) {
            if (visited[diff] == 3-visited[x]) continue;
            else if (visited[diff] == 0) {
                visited[diff] = 3-visited[x];
                bfs_q.push(diff);
            } else {
                possible = false;
                return;
            }
        }
    }
}

int main() {
    freopen("revegetate.in", "r", stdin);
    freopen("revegetate.out", "w", stdout);
    int n, m;
    cin >> n >> m;
    n_components = 0;

    // Set up graph for BFS

    for (int i = 0; i<m; i++) {
        string s;
        int a, b;
        cin >> s >> a >> b;
        --a, --b;
        if (s == "S") {
            same[a].push_back(b);
            same[b].push_back(a);
        } else if (s == "D") {
            different[a].push_back(b);
            different[b].push_back(a);
        }
    }

    // BFS to check connected components and whether each component is solvable
    for (int i = 0 ; i<n; i++) {
        if (visited[i] == 0) {
            n_components+=1;
            bfs_q.push(i);
            visited[i] = 1;
            BFS();
        }
        if (!possible) {
            cout << 0 << endl;
            return 0;
        }
    }
    cout << 1;
    for (int i = 0; i<n_components; i++) {
        cout << 0;
    }
    cout << endl;
    return 0;
}