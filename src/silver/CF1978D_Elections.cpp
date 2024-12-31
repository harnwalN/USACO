#include <bits/stdc++.h>
using namespace std;

void test() {
    long n; long u;
    cin >> n >> u;

    vector<long> votes;
    vector<long> result;

    long first = -1;
    long first_ind = -1;
    for (long i = 0; i<n; i++) {
        long v; cin >> v;
        if (i==0) v+=u;
        votes.push_back(v);
        result.push_back(-1);
        if (v>first) {
            first = v;
            first_ind = i;
        }
    }

    if (n==1) {
        cout << "0\n";
        return;
    }

    result[first_ind] = 0;
    if (first_ind !=0) {
        result[0] = 1;
    }
    long sum = u+votes[0];
    for (long i = 1; i<n; i++) {
        if (i==first_ind) {
            sum+=votes[i];
            continue;
        } else if (sum+votes[i]>=first) {
            result[i] = i;
        } else {
            result[i] = i+1;
        }
        sum+=votes[i];
    }
    for (long i = 0; i < result.size() - 1; i++) {
        cout << result[i] << " ";
    }
    cout << result[result.size()-1] << "\n";
}

int main() {
    long tc; cin >> tc;
    for (long i = 0; i<tc; i++) {
        test();
    }
    return 0;
}