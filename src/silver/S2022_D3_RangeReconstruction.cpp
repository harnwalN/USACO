#include <bits/stdc++.h>
using namespace std;

int range(int a, int b) {
    return abs(a-b);
}
int range(int a, int b, int c) {
    int smallest = min(min(a, b), c);
    int largest = max(max(a, b), c);
    return largest-smallest;
}

int main() {
    int n; cin >> n;
    vector<int> first;
    vector<int> second;
    if (n == 1) {
        cout << 0 << endl;
        return 0;
    } else if (n == 2){
        int zero, a;
        cin >> zero, a;
        cout << 0 << " " << a << endl;
        return 0;
    } else if (n==3) {
        int x, y, a, b, c;
        cin >> x >> a >> b;
        cin >> y >> c;
        first.push_back(a);
        first.push_back(c);
        second.push_back(b);
    } else {
        for (int i = 0; i<n-2; i++) {
            int zero, g, h;
            cin >> zero >> g >> h;
            string unnecessary;
            cin.ignore(300, '\n');
            first.push_back(g);
            second.push_back(h);
        }
        int _, ay;
        cin >> _ >> ay;
        first.push_back(ay);
    }

    
    cout << 0 << " " << first[0] << " ";

    vector<int> so_far;
    so_far.push_back(0);
    so_far.push_back(first[0]);

    for (int i = 1; i < n-2; i++) {
        int a = so_far[i-1], b = so_far[i];
        int adj_inc = first[i];
        int three_range = second[i-1];

        if (range(a, b, b+adj_inc) == three_range) {
            so_far.push_back(b+adj_inc);
            cout << b+adj_inc << " ";
        } else {
            so_far.push_back(b-adj_inc);
            cout << b-adj_inc << " ";
        }
    }
        // last iteration
    int i = n-2;
    int a = so_far[i-1], b = so_far[i];
    int adj_inc = first[i];
    int three_range = second[i-1];

    if (range(a, b, b+adj_inc) == three_range) {
        so_far.push_back(b+adj_inc);
        cout << b+adj_inc << endl;
    } else {
        so_far.push_back(b-adj_inc);
        cout << b-adj_inc << endl;
    }
    return 0;
}