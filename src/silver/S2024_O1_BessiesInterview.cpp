#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k;
    long time = 0;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    map<int, set<int>> links;
    cin >> n >> k;
    queue<int> cows;

    for (int i = 0; i<n; i++) {
        int t; cin >> t;
        cows.push(t);
    }
    for (int i = 0; i<k; i++) {
        pq.push(make_pair(cows.front(), i));
        cows.pop();
        set<int> l;
        links[i] = l;
    }

    while (!cows.empty()) {
        vector<pair<int, int>> open;
        open.push_back(pq.top()); pq.pop();

        while (pq.top().first == open[0].first) {
            open.push_back(pq.top()); pq.pop();
        }
        for (int l = 0; l<open.size(); l++) {
            for (int h = 0; h<open.size(); h++) {
                int a = open[l].second;
                int b = open[h].second;
                links[a].insert(b);
                links[b].insert(a);
            }
        }

        time=open[0].first;
        for (int i = 0; i<open.size(); i++) {
            pq.push(make_pair(cows.front()+open[i].first, open[i].second));
            cows.pop();
        }
    }
    vector<pair<int, int>> open;
    open.push_back(pq.top()); pq.pop();
    while (pq.top().first == open[0].first) {
        open.push_back(pq.top()); pq.pop();
    }
    for (int l = 0; l<open.size(); l++) {
        for (int h = 0; h<open.size(); h++) {
            int a = open[l].second;
            int b = open[h].second;
            links[a].insert(b);
            links[b].insert(a);
        }
    }
    time=open[0].first;

    cout << time << "\n";
    
    for (int i = 0; i<k; i++) {
        if (i == open[0].second || links[open[0].second].count(i)>0) {
            cout << "1";
        } else {
            cout << "0";
        }
    }
    cout << endl;

    return 0;
}