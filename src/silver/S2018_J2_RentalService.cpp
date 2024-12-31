#include <bits/stdc++.h>
using namespace std;
typedef pair<long long, long long> pi;
typedef vector<long long> vi;

int main() {
    freopen("rental.in", "r", stdin);
    freopen("rental.out", "w", stdout);

    int n, m, r;
    cin >> n >> m >> r;

    priority_queue<long long> cows;
    for (int i = 0; i<n; i++) {
        long long cow; cin >> cow;
        cows.push(cow);
    }
    vector<pi> orders;
    for (int i = 0; i<m; i++) {
        long long g, p;
        cin >> g >> p;
        orders.push_back(make_pair(p, g));
    }
    sort(orders.begin(), orders.end(), [](const pi& a, const pi& b) {
        return a.first>b.first;
    });

    vi rents;
    for(int i = 0; i<r; i++) {
        long long rent; cin >> rent;
        rents.push_back(rent);
    }
    sort(rents.begin(), rents. end(), greater<int>());

    vi r_prefix;
    r_prefix.push_back(0);
    for (int i = 0; i<r; i++) {
        r_prefix.push_back(r_prefix[i]+rents[i]);
    }
    for (int i = r; i<n; i++) {
        r_prefix.push_back(r_prefix[i]);
    }

    long long ans = r_prefix[r_prefix.size()-1];
    long long sold = 0;
    int order_num = 0;
    for (int i = 1; i<=n; i++) {
        long long cow = cows.top(); cows.pop();

        while (cow>0) {
            if (order_num >= orders.size()) { cout << ans << endl; return 0;}
            if (cow>=orders[order_num].second) {
                cow-=orders[order_num].second;
                sold+=orders[order_num].first*orders[order_num].second;
                order_num+=1;
            } else {
                sold+=cow*orders[order_num].first;
                orders[order_num] = make_pair(orders[order_num].first, orders[order_num].second-cow);
                cow=0;
            }
        }
        ans = max(ans, sold+r_prefix[n-i]);
    }
    cout << ans << endl;
}