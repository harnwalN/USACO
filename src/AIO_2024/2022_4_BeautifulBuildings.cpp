#include <bits/stdc++.h>

using namespace std;

int main() {
    freopen("buildin.txt", "r", stdin);
    freopen("buildout.txt", "w", stdout);

    int n;
    cin >> n;
    vector<int> heights;

    int init_ugly = 0;

    int h;
    cin >> h;
    heights.push_back(h);
    for (int i = 1; i<n; i++) {
        cin >> h;
        heights.push_back(h);
        init_ugly += abs(heights[i-1]-heights[i]);
    }

    int mod = init_ugly;
    if (n<=2) {
        mod = 0;
    } else {
        for (int i = 0; i<n-2; i++) {
            int a = heights[i];
            int b = heights[i+1];
            int c = heights[i+2];
            mod = min(mod, init_ugly - (abs(b-a)+abs(b-c)) + (abs(c-a)));
        }
    }
    mod = min(mod, init_ugly-abs(heights[0]-heights[1]));
    mod = min(mod, init_ugly-abs(heights[n-1]-heights[n-2]));
    cout << mod << endl;
}