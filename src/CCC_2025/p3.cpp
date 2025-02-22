#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    int n, m, q;
    cin >> n >> m >>q;

    vector<pair<int, int>> og;

    priority_queue<pair<int, int>> pq;
    for (int i = 0 ; i<n; i++) {
        int c, p;
        cin >> c >> p;
        pq.push(make_pair(p, c));
        og.push_back(make_pair(c, p));
    }
    
    long long ans = 0;
    bool repeated = false;
    vector<bool> used (m, false);

    int i = 0;
    int end = m;
    while(i<end) {
        int c, p;
        p = pq.top().first;
        c = pq.top().second;
        pq.pop();
        if (used[c]) {
            if (!repeated) {
                ans+=p;
                repeated = true;
            } else {
                end+=1;
            }
        } else {
            used[c] = true;
            ans+=p;

        }
        i++;
    }
    cout << ans << "\n";

    for (int qi = 0; qi<q; qi++) {
        int a, b, c;
        cin >> a >> b >> c;
        if (a==1) {
            og[b-1].first = c;
        } else {
            og[b-1].second = c;
        }
        priority_queue<pair<int, int>> new_pq;
        for (int i = 0; i<n; i++) {
            new_pq.push(make_pair(og[i].second, og[i].first));
        }
        ans = 0;
        repeated = false;
        vector<bool> nused (m, false);

        i = 0;
        end = m;
        while(i<end) {
            int c, p;
            p = new_pq.top().first;
            c = new_pq.top().second;
            // cout << p << "\n";
            new_pq.pop();
            if (nused[c]) {
                if (!repeated) {
                    ans+=p;
                    repeated = true;
                } else {
                    end+=1;
                }
            } else {
                nused[c] = true;
                ans+=p;
            }
            i++;
        }
        cout << ans << "\n";
    }
}