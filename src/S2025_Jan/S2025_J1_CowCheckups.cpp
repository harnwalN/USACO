#include <bits/stdc++.h>
using namespace std;

vector<long long> a;
vector<long long> b;
map<long long, vector<long long>> indexes;
vector<long long> duplicates; // indexes of duplicates
long long n;
long long ans;

int main() {
    ans = 0;
    cin >> n;
    
    for (long long i = 0; i<n; i++) {
        long long el;
        cin >> el;
        a.push_back(el);
    }
    for (long long i = 0; i<n; i++) {
        long long el;
        cin >> el;
        b.push_back(el);

        if (indexes.count(el)>0) {
            indexes[el].push_back(i);
        } else {
            vector<long long> v;
            v.push_back(i);
            indexes[el] = v;
        }
    }

    for (long long i = 0; i<n; i++) {
        long long ai = a[i];
        for (long long b : indexes[ai]) {
            ans+=min(min(i+1, n-i), min(b+1, n-b));
            if (i == b) {
                duplicates.push_back(i);
            }
        }
    }

    for (long long index : duplicates) {
        ans+=(index*(index+1))/2;
        long long right = n-index-1;
        ans+=(right*(right+1))/2;
    }

    cout << ans << endl;
}