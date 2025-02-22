#include <bits/stdc++.h>
using namespace std;

int main() {
    int a, b, x, y;

    cin >> a >> b >> x >> y;

    cout << min((max(a, x)+b+y), (max(b, y) + a + x)) << endl;
}