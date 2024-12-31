#include <bits/stdc++.h>
using namespace std;

struct Edge {
    int a;
    int b;
    int st;
    int et;
    bool operator<(const Edge& other) const {
        return (a<other.b || b<other.b || st<other.st || et<other.et);
    }
};

vector<int> layover; // 1 indexed
vector<int> earliest; // 1 indexed
map<int, vector<Edge>> graph;

void dfs(int node, int time, set<Edge> path) {
    if (time<earliest[node] && node !=1) {
        earliest[node] = time;
    }
    time+=layover[node];
    for (auto e : graph[node]) {
        if (path.count(e)>=1) {
            continue;
        } else if (time<=e.st) {
            path.insert(e);
            dfs(e.b, e.et, path);
        }
    }
    return;
}

int main() {
    int n, m;
    cin >> n >> m;

    for (int i = 1; i<=n; i++) {
        vector<Edge> v;
        graph[i] = v;
    }
    for (int i = 0; i<m; i++) {
        int a, b, st, et;
        cin >> a >> st >> b >> et;
        Edge edge;
        edge.a = a;
        edge.b = b;
        edge.st = st; 
        edge.et = et;
        graph[a].push_back(edge);
    }
    layover.push_back(-1);
    earliest.push_back(-1);
    for (int i = 0; i<n; i++) {
        int l;
        cin >> l;
        layover.push_back(l);
        earliest.push_back(INT_MAX);
    }
    earliest[1] = 0;
    set<Edge> path;
    dfs(1, 0-layover[1], path); // start dfs on node 1 with time
    for (int i = 1; i<=n; i++) {
        cout << earliest[i] << "\n";
    }
}