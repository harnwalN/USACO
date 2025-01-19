#include <bits/stdc++.h>
using namespace std;

struct Node {
    vector<int> children;
};
Node nodes[200001];
int gbestcd = -1;

pair<int, int> dfs(int node, int from, int d) {
    int bestc = node;
    int bestcd = d;
    for (auto el : nodes[node].children) {
        if (el != from) {
            pair<int, int> result = dfs(el, node, d+1);
            if (bestcd<result.second) {
                bestc = result.first;
                bestcd = result.second;
            }
        }
    }
    if (node==1) {
        gbestcd = bestcd;
    }
    return make_pair(bestc, bestcd);
}

int main() {
    int n; cin >> n;

    for (int i = 0; i<n-1; i++) {
        int a, b;
        cin >> a >> b;
        nodes[b].children.push_back(a);
        nodes[a].children.push_back(b);
    }

    int ans = dfs((dfs(1, 0, 0).first), 0, 0).second;
    cout << ans << endl;
    return 0;
}