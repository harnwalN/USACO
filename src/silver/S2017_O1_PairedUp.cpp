#include <bits/stdc++.h>
using namespace std;

int main() {
    // freopen("pairup.in", "r", stdin);
    // freopen("pairup.out", "w", stdout);

    int n;
    cin >> n;

    vector<long> outputs;

    for (int i = 0; i<n; i++) {
        long c, o;
        cin >> c >> o;
        for (int j = 0; j<c; j++) {
            outputs.push_back(o);
        }
    }

    sort(outputs.begin(), outputs.end());

    long result = 0;
    for (int i = 0; i<outputs.size()/2; i++) {
        result = max(result, outputs[i]+outputs[(outputs.size()-1)-i]);
    }
    cout << result << endl;
}